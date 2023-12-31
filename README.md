# Advanced Scala Crash Course

This is the repository for the workshop _Advanced Scala Crash Course_, containing teaching material and workshop exercises.

## Downloading

To download this repository onto your machine, make sure you have 
[Git](https://git-scm.com/downloads) installed.

Then open a terminal, change the directory to wherever you want to store the files contained
in this repository, and then enter the following command:

```
git clone git@github.com:jdegoes/advanced-scala-cc.git .
```

Note that if you haven't configured SSH, you may have to use the HTTP protocol to perform the 
download, which can be done as follows:

```
git clone https://github.com/jdegoes/advanced-scala-cc.git .
```

## Building

The project contains an [SBT](https://www.scala-sbt.org/) build file. SBT is the most common Scala
build tool. You can download the build tool [here](https://www.scala-sbt.org/).

**Be sure to download SBT 1.5.0 or later, as earlier versions do not support Scala 3.0.**

SBT build files can be imported into [IntelliJ IDEA](https://www.jetbrains.com/idea/), an IDE that
has a [plugin](https://plugins.jetbrains.com/plugin/1347-scala) for developing Scala applications.

Alternately, some people use [Visual Studio Code](https://code.visualstudio.com/) to develop Scala
applications. If you choose to use Visual Studio Code, then make sure you install the 
[Metals](https://marketplace.visualstudio.com/items?itemName=scalameta.metals) plugin and the 
[Scala Syntax](https://marketplace.visualstudio.com/items?itemName=scala-lang.scala) plugin.

Even if not using IntelliJ IDEA or Visual Studio Code with Metals, you can build the project from
any terminal by using SBT directly.

After opening a terminal and changing the directory to wherever you downloaded the files, simply
enter the following command:

```
sbt
```

This will start SBT in interactive mode, where you can type commands into the console in order to 
compile, run, and test your SBT project.

To compile the code in the project, type the following command at the SBT prompt:

```
compile
```

If there are any compiler errors, they will be reported to you, and you can edit the source code to
fix the compiler errors and try again.

Alternately, you can put SBT into continuous compilation mode. In this mode, SBT will attempt to 
compile your project whenever any files change state.

To place SBT into this mode, type the following command at the SBT prompt:

```
~ compile
```
