godev-educativeGame
===================

========================software Requirements========================

- Have JDK 7 or higher on the system in use
- Use an Operating system that supports Java


========================HardwareRequirements========================

- 512mb RAM
- 50 mb Storage space
- Headphones/Speakers (Optional)
- On board graphics card


========================BUILD OUTPUT DESCRIPTION========================

When you build an Java application project that has a main class, the IDE
automatically copies all of the JAR
files on the projects classpath to your projects dist/lib folder. The IDE
also adds each of the JAR files to the Class-Path element in the application
JAR files manifest file (MANIFEST.MF).

To run the project from the command line, go to the dist folder and
type the following:

java -jar "KnowAfricaGame.jar" 

To distribute this project, zip up the dist folder (including the lib folder)
and distribute the ZIP file.
Notes:

* If two JAR files on the project classpath have the same name, only the first
JAR file is copied to the lib folder.


* Only JAR files are copied to the lib folder.
If the classpath contains other types of files or folders, these files (folders)
are not copied.


* If a library on the projects classpath also has a Class-Path element
specified in the manifest,the content of the Class-Path element has to be on
the projects runtime path.


* To set a main class in a standard Java project, right-click the project node
in the Projects window and choose Properties. Then click Run and enter the
class name in the Main Class field. Alternatively, you can manually type the
class name in the manifest Main-Class element.


========================Install Instructions========================

- Double click the setup.exe
- Click Next
- Choose the install path
- Click Next
- The program is installed, a shortcut will be generated on the desktop

========================Uninstall Instructions========================

- Double click the Uninstall.exe in the install directory of the application
- Follow the prompts to uninstall the application


========================Third Party Software========================

InstallSimple:
Used to compile the netbeans project inot an installable application.
Once installed, open the application and follow the prompts until file selection; then select the netbeans project and continue with the prompts until completion.
A setup.exe is created that can install the application.
