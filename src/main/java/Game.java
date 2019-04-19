import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private int turns;
    private List<Player> players = new ArrayList<Player>();
    private Map map = new Map();
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

        System.out.println("How many rows (and colums) would you like? ");
        map.setMapSize(sc.nextInt(),n);

    }

    public void setNumberOfPlayers(int n){
        this.n =n;
        int randX = 0;
        int randY = 0;

        for(int i =0; i<n ; i++){
            if(n<5){
                do {
                    randX = (int) (Math.random() * ((50 - 5) + 1)) + 5;
                    randY = (int) (Math.random() * ((50 - 5) + 1)) + 5;
                }while (map.getTileType(randX,randY) != 'g');
            }else {
                do {
                    randX = (int) (Math.random() * ((50 - 8) + 1)) + 8;
                    randY = (int) (Math.random() * ((50 - 8) + 1)) + 8;
                }while (map.getTileType(randX,randY) != 'g');
            }

            Position newPosition = new Position(randX,randY);

            Player newPlayer = new Player( newPosition,i);
            players.add(newPlayer);
        }

    }



}
