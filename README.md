# JDT Call Hierarchy: Filter Test Code

_tldr;_ Eclipse plugin to show and hide callers from tests in the call hierarchy

Often when browsing a code base, you want to know where certain constructors/methods are used.
JDTs call hierarchy offers great insight but easily becomes messy when you have a lot of tests using the same methods as well. Depending on your activity, the test code may or may not be relevant to look at (e.g. where is this code used in production code). JDT itself already offers a filter to ignore test
code in the call hierarchy but the feature is well hidden and hard to toggle.

# Usage

![Demo](https://user-images.githubusercontent.com/316929/54784185-7f034d80-4c23-11e9-8665-ddaa06e495a0.gif)

## Keyboard
The toggle is available as command and thus can be triggered using 

<kbd>⌘ Command</kbd> + <kbd>3</kbd> + `Filter Test Code`

# Installation
Use the following p2 repository
```
https://dl.bintray.com/bmuskalla/eclipse-toggletestfilter/
```

# How it works
Which classes are considered tests is based on whether the source folder is marked as test source folder. This can be done in the `Project properties > Java Build Path`. By default, Maven projects have this configured for their `src/test/java` source folder.

![Contains test sources](https://user-images.githubusercontent.com/316929/54849469-a8d07900-4ce4-11e9-9b37-83d23f509ce4.png)


# License
Released under the [EPL 2.0](https://www.eclipse.org/legal/epl-2.0/)
