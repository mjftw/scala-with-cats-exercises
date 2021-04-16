# Scala with Cats Exercises

Repo to hold the exercises created while reading the excellent book
[Scala with Cats](https://www.scalawithcats.com/dist/scala-with-cats.html)

## Running the code

The code is run using the [Ammonite](https://ammonite.io/) Scala REPL for
convenience & simplicity.
This will need to be installed first.

In order to run the code, the Scala package dependencies (e.g. [Cats](https://typelevel.org/cats/)) must be installed.
This can be done by copying the `predef.sc` file found here to `~/.ammonite/predef.sc`. Ammonite will then install them when run.

To run one of the exercises in the REPL:

```shell
amm -w -p exercises/1.3.scala
```

> This will run with the `-w` (watch) argument so that the source is recompiled
> on change, as well as the `-p <file>` argument to specify the exercise to run.

The exercise can be run by evaluating the `Main` object:

```scala
Loading...
Compiling /home/merlinwebster/learning/scala-with-cats/exercises/1.3.scala
Welcome to the Ammonite Repl 2.2.0 (Scala 2.13.3 Java 11.0.10)

@ Main 
How many roads must a man walk down?
42
Paws is a 5 years-old turtleshell cat.
Lucky is a 3 years-old dog pretending to be a cat.
res0: Main.type = ammonite.predef.FilePredef$Main$@11e17893
```