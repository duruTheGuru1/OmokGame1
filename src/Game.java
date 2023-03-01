import java.util.Scanner;
public class Game {
//private Board board = new Board(15);
    private Scanner scan;
    private boolean endGame;
    private Controller controller;

    public Game(){
        this.controller = new Controller();
    }

    public Controller getController() {
        return this.controller;
    }

    public void humanGame(){
        char [][] board = controller.getBoardC().getBoard();
        scan = new Scanner(System.in);

    }

    public void computerGame(){

    }



    public boolean winChecker (char [][] board){
        board = controller.getBoardC().getBoard();
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char marker = board[i][j];
                if (marker == '.') {
                    continue; // skip empty cells
                }
                // check horizontal line
                if (j <= n - 5 && marker == board[i][j+1] && marker == board[i][j+2] && marker == board[i][j+3] && marker == board[i][j+4]) {
                    return true;
                }
                // check vertical line
                if (i <= n - 5 && marker == board[i+1][j] && marker == board[i+2][j] && marker == board[i+3][j] && marker == board[i+4][j]) {
                    return true;
                }
                // check diagonal line (top-left to bottom-right)
                if (i <= n - 5 && j <= n - 5 && marker == board[i+1][j+1] && marker == board[i+2][j+2] && marker == board[i+3][j+3] && marker == board[i+4][j+4]) {
                    return true;
                }
                // check diagonal line (bottom-left to top-right)
                if (i >= 4 && j <= n - 5 && marker == board[i-1][j+1] && marker == board[i-2][j+2] && marker == board[i-3][j+3] && marker == board[i-4][j+4]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Game omok = new Game();
        Controller test = omok.getController();
        char[][] board = test.getBoardC().getBoard();
        int[] pos = {1,6};
        for(int i = 0; i < 5; i++){
            pos[0] = 0;
            boolean valid = test.canPlace(board, pos);
            test.setPiece(board, test.getPlayer1(),pos, valid);
            test.displayBoard();
        }

        System.out.println(omok.winChecker(board));

    }
}






