import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OmokGui extends JFrame {
    Board board = new Board(15);
    Graphics g = getGraphics();

    public OmokGui() {
        var frame = new JFrame("Omok");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 200));

        //human or computer options
        JRadioButton humanPlay = new JRadioButton("Human");
        JRadioButton computerPlay = new JRadioButton("Computer");
        humanPlay.setAlignmentX(Component.CENTER_ALIGNMENT);
        computerPlay.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton play = new JButton("Play"); //start game
        play.setAlignmentX(Component.CENTER_ALIGNMENT);
        play.setAlignmentY(Component.CENTER_ALIGNMENT);

        panel.add(new JLabel("Select your opponent: "));
        panel.add(humanPlay);
        panel.add(computerPlay);
        ButtonGroup options = new ButtonGroup();
        options.add(humanPlay);
        options.add(computerPlay);
        panel.add(play);

        JLabel choice = new JLabel();
        choice.setAlignmentX(Component.CENTER_ALIGNMENT);
        choice.setAlignmentY(55);
        panel.add(choice);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(humanPlay.isSelected()){
                    choice.setText("Human Selected!");

                    initBoardPanel();



                }else if (computerPlay.isSelected()){
                    choice.setText("Computer Selected!");
                    initBoardPanel();
                }
            }
        });
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public void initBoardPanel(){

        BoardPanel boardPanel = new BoardPanel(board); // Create an instance of BoardPanel class
        JFrame frame = new JFrame("Omok"); // Create JFrame object with title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        frame.add(boardPanel.getPanel()); // Add BoardPanel instance to JFrame
        frame.pack(); // Pack JFrame to preferred size
        frame.setVisible(true); // Set JFrame visible
    }



    public static void main(String[] args) {

    }
}
