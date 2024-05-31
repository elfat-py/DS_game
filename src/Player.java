import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Player extends JFrame implements Serializable {
    private int playerPositionY;
    private int playerPositionX;
    private int treasureCount;
    private MazeGeneration maze;
    private JLabel playerLabel;
    public Player(MazeGeneration maze){
        this.playerPositionX = 0;
        this.playerPositionY = 0;
        this.treasureCount = 0;
        this.maze = maze;

        ImageIcon character = new ImageIcon("C:\\Users\\User\\IdeaProjects\\DS_game\\MazeGame\\img\\character.png");
        character = new ImageIcon(character.getImage().getScaledInstance(this.maze.getSpacing(),this.maze.getSpacing(), Image.SCALE_SMOOTH));
        playerLabel = new JLabel();
        playerLabel.setBounds(this.getPlayerPositionX(),this.getPlayerPositionY(),this.maze.getSpacing(),this.maze.getSpacing());
        playerLabel.setIcon(character);
    }

    public Player(int playerPositionY, int playerPositionX, int treasureCount){
        this.playerPositionY = playerPositionY;
        this.playerPositionX = playerPositionX;
        this.treasureCount = treasureCount;
    }

    public void movePlayerRight(){
        if(!this.HasRightWall())
            playerLabel.setLocation(playerPositionX+=maze.getSpacing(),playerPositionY);
        collectTreasure();
    }
    public void movePlayerLeft(){
        if(!this.hasLeftWall())
            playerLabel.setLocation(playerPositionX-=maze.getSpacing(),playerPositionY);
        collectTreasure();
    }
    public void movePlayerUp(){
        if (!this.hasTopWall())
            playerLabel.setLocation(playerPositionX,playerPositionY-=maze.getSpacing());
        collectTreasure();
    }
    public void movePlayerDown(){
        if (!this.hasBottomWall())
            playerLabel.setLocation(playerPositionX,playerPositionY+=maze.getSpacing());
        collectTreasure();
    }

    private boolean hasTopWall(){
            return maze.getCells().get(this.getPlayerCellIndex()).hasTopWall();
    }
    private boolean hasLeftWall(){
        return maze.getCells().get(this.getPlayerCellIndex()).hasLeftWall();
    }
    private boolean hasBottomWall(){
        return maze.getCells().get(this.getPlayerCellIndex()).hasBottomWall();
    }
    private boolean HasRightWall(){
        return maze.getCells().get(this.getPlayerCellIndex()).hasRightWall();
    }

    private int getPlayerCellIndex(){
        return (((int) Math.round((double) playerPositionY/maze.getSpacing()))*maze.getMAZE_COLUMNS() + (int) Math.round((double) playerPositionX/maze.getSpacing()));
    }

    public void collectTreasure(){
        if(maze.getCells().get(getPlayerCellIndex()).containsTreasure()){
            maze.getCells().get(getPlayerCellIndex()).setContainsTreasure(false);
            treasureCount++;
        }
    }

    public boolean isAnExit(){
        return true;
    }

    public int getPlayerPositionX() {
        return playerPositionX;
    }
    public int getPlayerPositionY() {
        return playerPositionY;
    }
    public JLabel getPlayerLabel() {
        return playerLabel;
    }
}
