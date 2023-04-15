
public class ConsoleUI {
    private Game currGame;

    public ConsoleUI(){
        this.currGame = new Game();
    }

    public void welcome(){
        System.out.println("Welcome to Omok! a 5 in a row game.");
    }

    public void askForGame(){
        System.out.println("Would you like to play? Y - Yes, N - No:");
    }

    public void promptUser(){
        System.out.println("Press 1 for Human vs. Human Game. Press 2 for Human vs. Computer mode:");
    }

    public void newGame(){
        System.out.println("new game?");
    }

    public void pickSpace(int player){
        System.out.println("Player " + player + "'s turn. Pick a spot on the board please \nFrom 0 - "
                + currGame.getGameBoard().getBoard().length + ". Your 1st input will be for the row, and the 2nd for the column.");
    }

    public void displayBoard(Board currBoard){
        //using formatting to print statements so that it doesn't look ugly

        System.out.print("  ");
        //this will print out the top row guide of numbers
        for (int i = 0; i < this.currGame.getGameBoard().getBoard().length; i++) {
            System.out.printf("%2d ", i);
            System.out.println("-");

        }
        System.out.println();
        //this prints out the side guide
        for (int i= 0; i < this.currGame.getGameBoard().getBoard().length; i++) {
            System.out.printf("%2d ", i);
            System.out.print('|');

            for (int j = 0; j < this.currGame.getGameBoard().getBoard().length; j++) {
                System.out.print(this.currGame.getGameBoard().getBoard()[i][j] + "  ");
            }

            System.out.println();
        }
        System.out.println();
    }

    public void displayBoard(char[][] board){

        System.out.print("  ");
        //this will print out the top row guide of numbers
        for (int i = 0; i < board.length; i++) {
            System.out.printf("%2d ", i);

        }
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < board.length; i++) {
            System.out.printf("%2c ", '-');

        }
        System.out.println();
        //this prints out the side guide
        for (int i= 0; i < board.length; i++) {
            System.out.printf("%2d ", i);
            System.out.print('|');

            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "  ");
            }

            System.out.println();
        }
        System.out.println();
    }

    public void declareWinner(Player winner){
        System.out.println("The winner is Player " + winner.getNumber() + "!!!");

    }

    public void declareTie(){
        System.out.println("A draw has occurred! No winners this game");
    }

    public void newMatch(){
        System.out.println("Would you like to play again?");
    }

    public void leave(){
        System.out.println("Bye Bye! Hope to see you again soon!");
    }

    public void displayWin(char[][] board, char mark){

        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (mark == '.') {
                    continue; // skip empty cells
                }
                // check horizontal line
                if (j <= n - 5 && mark == board[i][j+1] && mark == board[i][j+2] && mark == board[i][j+3] && mark == board[i][j+4]) {
                    System.out.println("5 in a row at positions: ");
                    for (int k = 0; k < 5; k++) {
                        System.out.print("(" + i + ", " + (j+k) + ") ");
                    }
                }
                // check vertical line
                if (i <= n - 5 && mark == board[i+1][j] && mark == board[i+2][j] && mark == board[i+3][j] && mark == board[i+4][j]) {
                    System.out.println("5 in a row at positions: ");
                    for (int k = 0; k < 5; k++) {
                        System.out.println("(" + (i+k) + ", " + j + ") ");
                    }
                }
                // check diagonal line (top-left to bottom-right)
                if (i <= n - 5 && j <= n - 5 && mark == board[i+1][j+1] && mark == board[i+2][j+2] && mark == board[i+3][j+3] && mark == board[i+4][j+4]) {
                    System.out.println("5 in a row at positions: ");
                    for (int k = 0; k < 5; k++) {
                        System.out.println("(" + (i+k) + ", " + (j+k) + ") ");
                    }
                }
                // check diagonal line (bottom-left to top-right)
                if (i >= 4 && j <= n - 5 && mark == board[i-1][j+1] && mark == board[i-2][j+2] && mark == board[i-3][j+3] && mark == board[i-4][j+4]) {
                    System.out.println("5 in a row at positions: ");
                    for (int k = 0; k < 5; k++) {
                        System.out.println("(" + (i-k) + ", " + (j+k) + ") ");
                    }
                }
            }
        }

    }



}


