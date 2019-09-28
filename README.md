# AtariBreakout

Problem Statement
To develop a breakout game with start, stop, replay and undo functionalities along with the ability to allow users to save and load the game to/from the disk and dynamically change the layout of the control panel. 

Architecture Overview 
We have implemented the game using Java Swing package and three design patterns- The Strategy, Observable, Command and Composite Pattern. 

Strategy Pattern 
We used Strategy Pattern because the components that it was implemented on had some common as well as varying properties, hence future-proofing the code in the process. To implement this pattern, we created three interfaces - Drawable, Behavioral and Controls interface. 

Observer Pattern 
To implement this pattern we have used Java’s utils Observable and Observer package. The objects ball, brick, slider are added as Observers and they update their states when notified by Observable ie the Breakout class when the movement of the ball changes. 

Command Pattern 
Command Pattern is used in the code for easy accommodation of future functionalities. To implement this pattern, a Command interface was created.
 
Composite Pattern 
The Composite Pattern is used in conjunction with the command pattern to overcome its shortcomings. The drawback of the Command Pattern is that it creates too many classes, using the Composite Pattern a single class can be used handle all the related classes. 
