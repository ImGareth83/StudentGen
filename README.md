# Web Assessment: StudentGen, Java assessment

This is my solution to the Java Assessment. The assessment requires build a Java-based Student and Student Service features.

## The challenge
Write the methods that complete the program.
Test the program to verify if it works properly.
Prepare the program to handle wrong data format insertion.

[Part 1] Understanding the StudentGen project

[Part 2] Implementing the Student and StudentService missing features

## How to run it
1) git clone https://github.com/ImGareth83/StudentGen.git

2) Execute the follow at StudentGen root folder:

java -cp ./out/production/StudentGen/ com.generation.java.Main

3) Greater convenience, execute runStudentGen.bash on commandline.

Alternatively, open in IntelliJ and execute directly from there. 

## Built with

- Java JDK 17 only

## Reflections

### What did i like about this project?

I love this project mainly because we are tested on OO concepts. The assessment was well documented with questions and a UML diagram. It made the assessment a lot easier to code. 

### What did i struggle with in this project?

3 issues i found during the assessment. 

First i found that the SimpleDateFormat didnt throw ParseException for invalid date - i.e "99/99/9999". I have to research online and found that i just need to setLenient(false).

Another issue i had was rename the project and folder name to StudentGen. i research online and found i had to rename workspace.xml in order to complete the renaming correctly. 

Last issue was using IntelliJ's Git feature to upload the source codes to github. i youtubed some videoes and managed to do so afterwards.

### What would you make your experience with this assessment better?

In my opinion, the assessment has been good especially the guidance from our lecturer, Jean. Anymore is equivalent to giving out obvious answers. 


## Author

- Website - [Gareth's Linkedin](https://www.linkedin.com/in/garethfong/)

## Acknowledgments

I love to thank Generation Singapore and my lecturer, Jean Looi for their guidance and time. 
