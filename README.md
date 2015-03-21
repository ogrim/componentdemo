# componentdemo

A small demo showing a runnable component system.

When the system is running, it will print a message every three seconds.

## Usage

If you `cider-jack-in` in Emacs, the user namespace in dev should be loaded and compiled by default. Then you can just say `(go)` to make it go..

For production you will run the main function. Just use `lein run` to watch it go, press `enter` to gracefully stop.


```Shell
lein run
;; Starting scheduler
;; Starting app
;; System is running - Press enter to stop
We get signal!
We get signal!
We get signal!
We get signal!
We get signal!

;; Stopping app
;; Stopping scheduler
```

## Resources

Some links to articles I used figuring out everything:

- [stuartsierra/component](https://github.com/stuartsierra/component)
- [My Clojure Workflow, Reloaded](http://thinkrelevance.com/blog/2013/06/04/clojure-workflow-reloaded)
- [Retrofitting the Reloaded pattern into Clojure projects](http://martintrojer.github.io/clojure/2013/09/07/retrofitting-the-reloaded-pattern-into-clojure-projects/)
- [Master Concurrent Processes with core.async](http://www.braveclojure.com/core-async/)
- [Clojurecore.async API Reference](https://clojure.github.io/core.async/#clojure.core.async/go-loop)

## License

Copyright © 2015 Aleksander Skjæveland Larsen

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
