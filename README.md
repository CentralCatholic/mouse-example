# Mouse Example

This repo is a tiny `MouseListener` and `MouseMotionListener` example using Java 9.

To compile, change into this directory and run `javac Main.java`

To run, `java Main`

# Usage

Once you've run `java Main`, you should see a Java Swing popup window. Note the title of this window
displays the (x, y) position of the mouse. This is done with a `MouseMotionListener`, which fires an event
every time the mouse of moved.

Click the mouse once. This should draw a circle to the screen. This is done with a `MouseListener` responding to a `MouseClicked` event. 

Click and drag the mouse. This should display a blue line on the panel. This is done with a `MouseMotionListener` responding to the `mousePressed` and `mouseReleased` events. First, when the `mousePressed` event is fired, the program stores the point on the panel which was clicked; it is stored in an instance variable local to the `MouseAdapter` type. Next, when a `mouseReleased` event is fired, the program is passed the new `MouseEvent` with the location from which the mouse was released. This gives us our endpoint of the line. Using the cached value of the starting point, the program draws the line.

Note that the `mouseReleased` event checks to make sure that the Point has been approperately cached. At first bluff you might think this is unnecessary since the mouse much be pressed before it is released. However, Java Swing events are asynchronous, and thus there is no guarantee that the `mousePressed` event will complete its processing before the `mpouseReleased` events starts! You'll likely find a nasty null pointer bug if you skip the null pointer check in `mouseReleased`. This is an illustrative example of a race condition.

All of this is implemented in a couple of lines with an inline, anonymous subclass of `MouseAdapter`.

# About

This repository was written for the Central Catholic Honors Java Structures class to demonstrate

1. the `MouseAdapter` class

2. anonymous types

3. as repeated above, the `MouseListener` and `MouseMotionListener` classes.
