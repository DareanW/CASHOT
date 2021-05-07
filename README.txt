3443-002-Team-Project
Payhem by CASHOT
By
grl167 Darean Wilde (Team Leader) (Ean173)
fww704 Jacob Shawver (Yarlow)
hug180 Majerus Sims (hug180)
tvh991 Alexander Delgado (Ad200023)

Using the integrated Git inside of Eclipse made the commits/pulls not show exactly how many commits we actually made. We have made more commits using Eclipse than it might show in Insights. The code still published properly and we were able to build off of the code published, even if the commits don't show.

This application works for screens 800x800 pixels or more. This is from Lab 3, where it stated "Remember to ensure your app works on all display sizes. For this lab, you can do this by making your app no larger than 800x800".

How to clone the GitHub repository on the UTSA VDI (and ensure everything is compatible):
1: Log Into UTSA VDI
2: Open the Eclipse folder and open "eclipse.exe"
* use default workspace
3: Click on "Window" then click "Preferences"
4: Expand "Java" and click on "Installed JREs"
5: Click "Add" then select "Standard VM" then click "Next"
6: Click "Directory" and navigate to "C:\Program Files\Java"
7: Ensure there is "jdk1.8.0_XXX". If not, install a new JDK with this number.
8: Open "jdk1.8.0_XXX" and single click "jre"
9: Click "Select folder" and menu should auto-populate.
10: Click "Finish" and select "C:Program Files\Java\jdk1.8.0_XXX\jre"
11: click "Apply and Close"
12: Now, go to "Help" and expand
13: Open "Install New Software"
14: Press "Add" then in "Name", type 'Mars' and in "Location" type 'http://download.eclipse.org/releases/mars' 
15: Press "Add". Make sure "Work with" is in Mars
16: In "type filter text" type 'fx'
17: Select "e(fx)clipse - IDE" and click "Next"
18: Follow directions until Eclipse needs to restart. Restart.
19: An error might come up, "You are not running your eclipse instance with Java8. The JavaFX tooling is disabled because of this." This is fine.
20: Go to "File" then open "Import"

***Scroll down to "Opening the Project Via .zip" to open the project by downloading it.***

21: Expand "Git" and select "Projects from Git"
22: Select and open "Clone URI"
23: Paste in 'https://github.com/Ean173/CASHOT.git' to URI
* this link also works for opening the GitHub website.
24: Click "Next". Deselect All then select the "main" branch. Click "Next" three times.
25: Select "CASHOT" and then "Finish".
26: Click on "Window" then " hover over "Perspective" then "Open Perspective". Click "Other"
27: Click "Java" and then "Open"
28: On very right-hand side, click "Restore"
29: Click on "CASHOT" folder. Then expand this folder, expand "srs", expand "application" then right click "Main.java". Hover cursor over "Run As" then click "1 Java Application". Project should run correctly.

Opening the Project Via .zip
To open the project by downloading it from GitHub, click the green "Code" dropdown menu, then "Download ZIP". Now extract the file. Once you do this, you can open Eclipse and go to "File" then "Import". Now, expand "General" and select "Existing Projects into Workspace". Now. select the downloaded project folder. Now press "finish". Do not forget to install the software such as JavaFX and, very importantly, the JRE, listed above.

Opening Javadoc:
Once the project has successfully been imported into Eclipse, then the existing folder "doc" should be inside the "CASHOT" folder. All of the different Javadoc files can be opened inside Eclipse.

Opening the UML:
Also inside the "CASHOT" folder is the "UMLdiagram.class.violet.html" diagram. Right click this and hover over "Open with" then "Web Browser". This will show the UML diagram.

Functionality/Features

We wanted to make an all-purpose point-of-sale system so that this software can go wherever you and your business goes. Be it retail, grocery store, supermarket, this software is right for you.

All functionality works so enjoy our application :)
Customize register buttons as an admin in order to fit your needs.
Add, remove, view, and promote employees as an admin.
Train new employees with our training mode.
Cashier can ring up customers and check them out.
Admin can review past receipts on the screen.


