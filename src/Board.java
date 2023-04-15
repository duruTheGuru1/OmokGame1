/**
 * @author David duru
 * @version 1
 * @since 2023
 * A class which creates a 2d character array that acts as a board for an omok match*/
public class Board {
    private final int size;
    private char[][] board;

    //Constructor
    /**Creates an instance of the board
     * @param size a integer that defines the dimension of the omok board */
    public Board(int size){
        this.size = size;
        this.board = new char[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                board[i][j] = '.';
            }
        }
    }

    /** gives access to the board for other classes to use.
     * @return a 2d character array
     * */
    public char[][] getBoard(){
        return this.board;
    }

    public void clear(){
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                board[i][j] = '.';
            }
        }
    }

    public boolean isEmpty(int x, int y){
        if(this.board[x][y] == '.') {
            return true;
        }
        return false;
    }

    public void placeStone(int x, int y, char stone){
        this.board[x][y] = stone;
    }

    //added to use
    public boolean findWinner(char mark){
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (mark == '.') {
                    continue; // skip empty cells
                }
                // check horizontal line
                if (j <= n - 5 && mark == board[i][j+1] && mark == board[i][j+2] && mark == board[i][j+3] && mark == board[i][j+4]) {
                    return true;
                }
                // check vertical line
                if (i <= n - 5 && mark == board[i+1][j] && mark == board[i+2][j] && mark == board[i+3][j] && mark == board[i+4][j]) {
                    return true;
                }
                // check diagonal line (top-left to bottom-right)
                if (i <= n - 5 && j <= n - 5 && mark == board[i+1][j+1] && mark == board[i+2][j+2] && mark == board[i+3][j+3] && mark == board[i+4][j+4]) {
                    return true;
                }
                // check diagonal line (bottom-left to top-right)
                if (i >= 4 && j <= n - 5 && mark == board[i-1][j+1] && mark == board[i-2][j+2] && mark == board[i-3][j+3] && mark == board[i-4][j+4]) {
                    return true;
                }
            }
        }
        return false;
    }


}
