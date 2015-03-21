(ns componentdemo.core
  (:require [chime :refer [chime-ch]]
            [clj-time.core :refer [minutes seconds]]
            [clj-time.periodic :refer [periodic-seq]]
            [clj-time.local :refer [local-now]]
            [clojure.core.async :as a :refer [<! go-loop <!! close!]]
            [com.stuartsierra.component :as component])
  (:gen-class))

(defn- update-intervals [interval]
  (periodic-seq (local-now) (-> interval seconds)))

(defrecord Scheduler []
  component/Lifecycle
  (start [component]
    (println ";; Starting scheduler")
    (assoc component :channel (chime-ch (update-intervals 3))))
  (stop [component]
    (println ";; Stopping scheduler")
    (assoc component :channel nil)
    component))

(defn run-app [app]
  (go-loop []
    (when-let [msg (<! (:channel (:scheduler app)))]
      (println "We get signal!")
      (recur))))

(defrecord App [scheduler]
  component/Lifecycle
  (start [component]
    (println ";; Starting app")
    (assoc component :app-channel (run-app component)))
  (stop [component]
    (println ";; Stopping app")
    (close! (:channel (:scheduler component)))
    (assoc component :app-channel nil)))

(defn system [config-options]
  (component/system-map
   :scheduler (map->Scheduler {})
   :app (component/using
         (map->App {})
         [:scheduler])))

(defn -main [& args]
  (let [sys (component/start-system (system {}))]
    (println ";; System is running - Press enter to stop")
    (read-line)
    (component/stop-system sys)))
