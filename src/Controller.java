import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Controller {
    private ConsoleUI ui;
    private Game omok;

    public Controller() {
        this.ui = new ConsoleUI();
        this.omok = new Game();
    }

    //todo implement a public void run() function
    public void run() {
        Scanner scan = new Scanner(System.in);
        this.ui.welcome();
        this.ui.askForGame();
        char enterGame = scan.next().charAt(0);

        while(enterGame != 'Y' || enterGame != 'y' || enterGame != 'N' || enterGame != 'n'){
            if(enterGame == 'Y' || enterGame == 'y'){
                selectMode();
            }
            if(enterGame == 'N' || enterGame == 'n'){
                this.ui.leave();
                break;
            }
            this.ui.askForGame();
            enterGame = scan.next().charAt(0);
        }
    }

    public void selectMode(){
        this.ui.promptUser();
        Scanner scan = new Scanner(System.in);
        int gameMode = scan.nextInt();

        while (gameMode != 1 || gameMode != 2) {
            if (gameMode == 1) {
                humanGame();
            }
            if (gameMode == 2) {
                computerGame();
            }

        }
    }

    public void humanGame() {
        ArrayList<Player> players = this.omok.getPlayers();
        Scanner in = new Scanner(System.in);
        int totalMoves = 0;

        boolean endGame = false;
        boolean turnEnd = false;
        boolean win = false;

        char [][] currBoard = this.omok.getGameBoard().getBoard();
        int[] currPos = new int[2];

        while (!endGame) {
            this.ui.displayBoard(currBoard);
            //player1 turn
            while (!turnEnd) {
                ui.pickSpace(players.get(0).getNumber());
                for (int i = 0; i < 2; i++) {
                    currPos[i] = in.nextInt();
                }
                if (omok.canPlace(currPos) == true) {
                    this.omok.setPiece(players.get(0), currPos, true);
                    totalMoves++;
                    turnEnd = true;
                }
            }
            win = this.omok.winChecker(this.omok.getGameBoard().getBoard(),players.get(0).getMark());
            if (win == true) {
                this.ui.displayBoard(currBoard);
                ui.displayWin(currBoard,players.get(0).getMark());
                ui.declareWinner(players.get(0));
                endGame = true;
                break;
            } else if(totalMoves == currBoard.length* currBoard.length){//tie checker
                this.ui.displayBoard(currBoard);
                ui.declareTie();
                endGame = true;
                break;
            }

            turnEnd = false;
            this.ui.displayBoard(currBoard);

            //player2 turn
            while (!turnEnd) {
                ui.pickSpace(players.get(1).getNumber());
                for (int i = 0; i < 2; i++) {
                    currPos[i] = in.nextInt();
                }
                if (this.omok.canPlace(currPos) == true) {
                    this.omok.setPiece(players.get(1), currPos, true);
                    totalMoves++;
                    turnEnd = true;
                }
            }
            win = this.omok.winChecker(this.omok.getGameBoard().getBoard(), players.get(1).getMark());
            if (win == true) {
                ui.displayWin(currBoard,players.get(1).getMark());
                ui.declareWinner(players.get(1));
                endGame = true;
                break;
            } else if(totalMoves == currBoard.length * currBoard.length){ //tie checker
                ui.declareTie();
                endGame = true;
                break;
            }
            turnEnd = false;
        }
    }

    public void computerGame() {
        ArrayList<Player> players = this.omok.getPlayers();
        Scanner in = new Scanner(System.in);
        int totalMoves = 0;
        Random rand = new Random();

        boolean endGame = false;
        boolean turnEnd = false;
        boolean win = false;

        char [][] currBoard = this.omok.getGameBoard().getBoard();
        int[] currPos = new int[2];

        while (!endGame) {
            this.ui.displayBoard(currBoard);
            //player1 turn
            while (!turnEnd) {
                ui.pickSpace(players.get(0).getNumber());
                for (int i = 0; i < 2; i++) {
                    currPos[i] = in.nextInt();
                }
                if (omok.canPlace(currPos) == true) {
                    this.omok.setPiece(players.get(0), currPos, true);
                    totalMoves++;
                    turnEnd = true;
                }
            }
            win = this.omok.winChecker(this.omok.getGameBoard().getBoard(),players.get(0).getMark());
            if (win == true) {
                this.ui.displayBoard(currBoard);
                ui.displayWin(currBoard,players.get(0).getMark());
                ui.declareWinner(players.get(0));
                endGame = true;
                break;
            } else if(totalMoves == currBoard.length* currBoard.length){//tie checker
                this.ui.displayBoard(currBoard);
                ui.declareTie();
                endGame = true;
                break;
            }
            turnEnd = false;
            this.ui.displayBoard(currBoard);

            //player2 turn
            while (!turnEnd) {
                for (int i = 0; i < 2; i++) {
                    currPos[i] = rand.nextInt(15)+1;
                }
                if (this.omok.canPlace(currPos) == true) {
                    this.omok.setPiece(players.get(1), currPos, true);
                    totalMoves++;
                    turnEnd = true;
                }
            }
            win = this.omok.winChecker(this.omok.getGameBoard().getBoard(), players.get(1).getMark());
            if (win == true) {
                ui.displayWin(currBoard,players.get(1).getMark());
                ui.declareWinner(players.get(1));
                endGame = true;
                break;
            } else if(totalMoves == currBoard.length * currBoard.length){ //tie checker
                ui.declareTie();
                endGame = true;
                break;
            }
            turnEnd = false;
        }
    }
}










