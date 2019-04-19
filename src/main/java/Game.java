import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private int turns;
    private List<Player> players = new ArrayList<Player>();
    //private Map map = new Map
    private  int n; // number of players



    public static void main(String[] args) {


        Game thisGame = new Game();
        thisGame.startGame();


    }

    public void startGame(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Game");
        System.out.println("How many players would you like? ");

        setNumberOfPlayers(sc.nextInt());
        //TODO: Add validation
    }

    public void setNumberOfPlayers(int n){

        for(int i =0; i<n ; i++){
            Position newPosition = new Position(0,0);
            //TODO : add logic re initial postion
            Player newPlayer = new Player( newPosition,i);
            players.add(newPlayer);
        }

    }



}
