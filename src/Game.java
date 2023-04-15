import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private ArrayList<Player> players = new ArrayList<Player>();
    private Board board;

    public Game(){
        Player player1 = new Player(1,'x');
        Player player2 = new Player(2,'o');
        this.players.add(player1);
        this.players.add(player2);
        this.board = new Board(15);
    }

    public ArrayList<Player> getPlayers(){
        return this.players;
    }
    public Board getGameBoard(){
        return board;
    }


    public char [][] setPiece(Player player, int[] pos, boolean valid){
        char[][] currBoard = this.getGameBoard().getBoard();
        if(valid == true){
            currBoard[pos[0]][pos[1]] = player.getMark();
            return currBoard;

        }
        return currBoard;
    }

    public void setStone(int pos[],Player player){
        this.getGameBoard().getBoard()[pos[0]][pos[1]] = player.getMark();;

    }

    public boolean canPlace(int [] pos){
        if (this.getGameBoard().getBoard()[pos[0]][pos[1]] != '.'){return false;}
        else{return true;}
    }

    public boolean winChecker (char [][] board, char mark){
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mark == '.') {
                    continue; // skip empty cells
                }
                //check horizontal line
                if (j <= n - 5 && mark == board[i][j+1] && mark == board[i][j+2] && mark == board[i][j+3] && mark == board[i][j+4]) {

                    return true;
                }
                //check vertical line
                if (i <= n - 5 && mark == board[i+1][j] && mark == board[i+2][j] && mark == board[i+3][j] && mark == board[i+4][j]) {
                    return true;
                }
                //check diagonal line (top-left to bottom-right)
                if (i <= n - 5 && j <= n - 5 && mark == board[i+1][j+1] && mark == board[i+2][j+2] && mark == board[i+3][j+3] && mark == board[i+4][j+4]) {
                    return true;
                }
                //check diagonal line (bottom-left to top-right)
                if (i >= 4 && j <= n - 5 && mark == board[i-1][j+1] && mark == board[i-2][j+2] && mark == board[i-3][j+3] && mark == board[i-4][j+4]) {
                    return true;
                }
            }
        }
        return false;
    }


}
