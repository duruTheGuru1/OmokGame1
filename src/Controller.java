public class Controller {
private Player player1;
private Player player2;
private Board board;


    //controller is meant to control the flow of the game itself
    public Controller(){
        this.player1 = new Player('x');
        this.player2 = new Player('o');
        this.board = new Board(15);
    }

    //todo implement a public void run() function
    public void run(){

    }

    public Player getPlayer1() {
        return this.player1;
    }
    public Player getPlayer2(){
        return  this.player2;
    }

    public Board getBoardC(){
        return board;
    }

    public void setPiece(char [][] board, Player player, int[] space, boolean valid){

        if(valid == true){
            char[][] currBoard = this.board.getBoard();
            char mark = player.getMark();
            //currBoard[space[0]][space[1]] = mark;
            currBoard[space[0]][space[1]] = mark; //reversed the logic because it didnt place pieces correctly

        }else if(valid == false){
            System.out.println("Invalid. Position: " + space[0] + space[1] + " is taken");
        }
    }

    public boolean canPlace(char [][] board, int [] pos){
        board = this.board.getBoard();
        if (board[pos[0]][pos[1]] != '.'){return false;}
        return true;
    }

    //todo move this into console UI
    public void displayBoard(){
        //using formatting to print statements so that it doesn't look ugly
        char[][] currBoard = this.board.getBoard();
        System.out.print("  ");
        //this will print out the top row guide of numbers
        for (int i = 0; i < currBoard.length; i++) {
            System.out.printf("%2d ", i);

        }
        System.out.println();
        //this prints out the side guide
        for (int i= 0; i < currBoard.length; i++) {
            System.out.printf("%2d ", i);
            //System.out.print(';');

            for (int j = 0; j < currBoard.length; j++) {
                System.out.print(currBoard[i][j] + "  ");
            }

            System.out.println();
        }
        System.out.println();
    }


//    public static void main(String[] args) {
//        Controller control = new Controller();
//        Player play1 = control.getPlayer1();
//        Player play2 = control.getPlayer2();
//
//        char [][] omok1 = control.getBoardC().getBoard();
//
//        control.displayBoard();
//        int[] space = {0,1};
//        control.setPiece(omok1, play1,space);
//
//        control.displayBoard();
//
//    }


}
