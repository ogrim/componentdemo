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

## License

Copyright © 2015 Aleksander Skjæveland Larsen

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
