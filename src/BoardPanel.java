import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardPanel extends JPanel {
    private Board board;
    private JPanel grid;
    boolean turn = true;



    public BoardPanel(Board board) {
        this.board = board;
        this.grid = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int w = getWidth();
                int h = getHeight();
                int gridSize = Math.min(w, h) / 15;
                for (int i = 0; i <= 15; i++) {
                    int x = i * gridSize;
                    g.drawLine(x, 0, x, h);
                    g.drawLine(0, x, w, x);
                }


                //after placing a stone, the boardpanel will repaint and update it accordingly
                for (int i = 0; i < board.getBoard().length; i++) {
                    for (int j = 0; j < board.getBoard().length; j++) {
                        if (board.getBoard()[i][j] == 'X') {
                            g.setColor(Color.BLACK);
                            g.fillOval(i * gridSize + gridSize / 4, j * gridSize + gridSize / 4,
                                    gridSize / 2, gridSize / 2);
                        } else if (board.getBoard()[i][j] == 'O') {
                            g.setColor(Color.WHITE);
                            g.fillOval(i * gridSize + gridSize / 4, j * gridSize + gridSize / 4,
                                    gridSize / 2, gridSize / 2);
                        }
                    }
                }
            }
        };

        grid.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                int w = grid.getWidth();
                int h = grid.getHeight();
                int gridSize = Math.min(w, h) / 15;
                int xPos = e.getX() / gridSize;
                int yPos = e.getY() / gridSize;

                if (turn) {
                    if (board.isEmpty(xPos,yPos)) {
                        board.placeStone(xPos,yPos,'X');
                        grid.repaint();
                        turn = false;
                    }
                } else {
                    if (board.isEmpty(xPos,yPos)) {
                        board.placeStone(xPos,yPos,'O');
                        grid.repaint();
                        turn = true;
                    }
                }
            }

        });

    }

    public JPanel getPanel(){
        return grid;
    }

}
