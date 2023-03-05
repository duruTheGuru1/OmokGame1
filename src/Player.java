import java.util.Scanner;


public class Player {
    private char mark;
    private int number;

    //default constructor

    //constructor
    public Player(int num,char mark){
        this.mark = mark;
        this.number = num;
    }
    //getter
    public char getMark(){
        return this.mark;
    }
    public int getNumber(){return this.number;}


}
