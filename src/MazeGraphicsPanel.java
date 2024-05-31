import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MazeGraphicsPanel extends JPanel {

    private final MazeGeneration maze;
    private Image wallImage;
    private Image background;
    private Image treasureImage;
    public MazeGraphicsPanel(MazeGeneration maze) {
        this.setBounds(0,0,1000,650);
        this.maze = maze;
        try {
            // Load the PNG image for walls
            wallImage = ImageIO.read(new File("C:\\Users\\User\\IdeaProjects\\DS_game\\MazeGame\\img\\wall.png"));
            background = ImageIO.read(new File("C:\\Users\\User\\IdeaProjects\\DS_game\\MazeGame\\img\\background.png"));
            treasureImage = ImageIO.read(new File("C:\\Users\\User\\IdeaProjects\\DS_game\\MazeGame\\img\\coin1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (Cell cell : maze.getCells()) {
            int x = cell.getX() * maze.getSpacing();
            int y = cell.getY() * maze.getSpacing();


            graphics.drawImage(background,x,y,maze.getSpacing(),maze.getSpacing(),null);
            if (cell.hasTopWall()) {
                graphics.drawImage(wallImage, x, y, maze.getSpacing(), maze.getSpacing() / 8, null);
            }
            if (cell.hasLeftWall()) {
                graphics.drawImage(wallImage, x, y, maze.getSpacing() / 8, maze.getSpacing(), null);
            }
            if (cell.hasRightWall()) {
                graphics.drawImage(wallImage, x + maze.getSpacing() - maze.getSpacing() / 8, y, maze.getSpacing() / 8, maze.getSpacing(), null);
            }
            if (cell.hasBottomWall()) {
                graphics.drawImage(wallImage, x, y + maze.getSpacing() - maze.getSpacing() / 8, maze.getSpacing(), maze.getSpacing() / 8, null);
            }
            if(cell.containsTreasure()){
                graphics.drawImage(treasureImage, x+(maze.getSpacing()/4) , y+(maze.getSpacing()/4), maze.getSpacing()-40, maze.getSpacing()-40, null);
            }
        }
    }

}
