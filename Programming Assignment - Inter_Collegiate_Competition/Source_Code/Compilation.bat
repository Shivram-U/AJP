@echo off
javac Inter_College_Competition.java
jar cfm Inter_College_Competition_Registration.jar Manifest.txt Inter_College_Competition.class
echo Java Class Compilation and Executable .jar File Creation Successfull
pause