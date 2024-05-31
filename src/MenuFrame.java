import javax.swing.*;
import java.awt.*;
public class MenuFrame extends JFrame{

    JPanel buttonPanel;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final Dimension buttonSize = new Dimension(400,150);

    private final JButton startButton;
//    private final JButton loadButton;
//    private final quitButton;
    public MenuFrame(){
        this.setTitle("Menu");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        buttonPanel = new JPanel();
        startButton = new JButton("Start Game!");
        startButton.setPreferredSize(buttonSize);

        startButton.addActionListener(e -> {
            this.dispose();
            new GraphicsFrame();
        });

        JButton LoadButton = new JButton("Load Game!");
        LoadButton.setPreferredSize(buttonSize);
        LoadButton.addActionListener(e -> {
        });

        JButton quitButton = new JButton("Quit");
        quitButton.setPreferredSize(buttonSize);
        quitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Goodbye!");
        });

        buttonPanel.add(startButton);
        buttonPanel.add(LoadButton);
        buttonPanel.add(quitButton);

        this.getContentPane().add(buttonPanel, BorderLayout.CENTER);
        this.setSize(screenSize.width, screenSize.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
