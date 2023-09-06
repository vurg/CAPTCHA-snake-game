# CAPTCHA Snake Game
The goal of this project was to create a fun snake game that gamifies the solving of CAPTCHA puzzles. It solves the problem of users needing to switch between different keyboard languages to verify that they are human.
 
<img src="https://imgur.com/Rm957nO.jpg" alt="Snake Game 1" width="1000">
<img src="https://imgur.com/s9k4Ijh.jpg" alt="Snake Game 2" width="1000">
<img src="https://imgur.com/BHcsP01.jpg" alt="Snake Game 3" width="1000">
<img src="https://imgur.com/NqpVCdy.jpg" alt="Snake Game 4" width="1000">
<img src="https://imgur.com/DBO9fR3.jpg" alt="Snake Game 5" width="1000">


### Git Clone the GitLab repository:

[GitLab Repository](https://git.chalmers.se/nasit/group16teamprogramming.git)

### IntelliJ IDE:

1. Go to File -> Project Structure:
2. Set Project SDK to Java 18
3. Import Library: `fasterxml.jackson.core.databind` using Maven: `com.fasterxml.jackson.core:jackson-databind:LATEST`

### VisualStudio IDE:

1. Navigate to the tab “Java Projects” -> navigate to the folder “Referenced Libraries”:
2. Click on the plus icon next to the “Referenced Libraries” label, this opens the File Manager
3. In the File Manager, navigate to the directory where CAPTCHA Snake Game is saved
4. Find the “lib” folder, and add each of the 3 listed .jar files to the “Referenced Libraries” tab
5. If you encounter the `java.io.FileNotFoundException`: The system cannot find the file path specified. Make sure you are in the correct workspace. If the project was cloned, set the folder `group16teamprogramming/` as your workspace. That is to say, you need to open a workspace in the IDE that directly contains the folders: `.vscode/`, `CAPTCHA/`, `data/`, `lib/`, `src/`, and `wallpapers/`.
6. Clean Java Workspace or close and reopen VSCode if any issues persist.

### GAMEPLAY INSTRUCTIONS:
- From the main menu, launch the CAPTCHA Snake Game or click "Settings” to modify the alphabet to Swedish (default) or English, and set puzzle size to 5, 6 (default), 7, or 8 characters.
- Control the snake using keyboard arrow keys (UP, DOWN, LEFT, RIGHT). Collect the CAPTCHA puzzle symbols in the order they appear on the right side of the menu. The puzzle must be completed within the 60 seconds to verify the user.
- The user fails verification if the snake’s head collides with its tail, if the snake collides with the walls of the puzzle, if the snake collects the CAPTCHA symbols in the incorrect order, or if the puzzle is not completed within 60 seconds.
- Failing verification, the user can retry a different puzzle (same settings), return to the main menu, or type the CAPTCHA puzzle using their keyboard to complete verification.
- The CAPTCHA Snake Game saves the puzzle size and time taken for verification (if verified using the snake game), and displays it on the main menu the next time the game is launched.

#### Feedback:
For any questions related to the software (e.g. reporting bugs), please direct your inquiries to:
- [Nasit Vurgun](mailto:gusvurna@student.gu.se)
- [Kai Rowley](mailto:gusrowkai@student.gu.se)
