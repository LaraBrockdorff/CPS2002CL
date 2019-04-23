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
        boolean valid= true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Game");
        do {
            System.out.println("How many players would you like? ");

            n = sc.nextInt();
            if (n < 2 || n > 8) {
                System.out.println("**Please enter a valid integer between 2 and 8 **");
                valid = false;
            }else {
                valid =true;
                setNumberOfPlayers(n);
            }
        }while (!valid);



        do{
        System.out.println("How many rows (and colums) would you like? ");
        int mapSize = sc.nextInt();
        if (( n<6 && (mapSize < 5 || mapSize> 50)) || ((n>5 && n<9)&&(mapSize < 8 || mapSize> 50))){
            valid= false;
        }else{
            valid=true;
            map.setMapSize(sc.nextInt(),n);
        }

        }while(!valid);


    }

    public void setNumberOfPlayers(int n){
        this.n =n;
        int randX = 0;
        int randY = 0;

        for(int i =0; i<n ; i++){

                do {
                    randX = (int) (Math.random() * map.getSize()) ;
                    randY = (int) (Math.random() * map.getSize()) ;
                }while (map.getTileType(randX,randY) != 'g');

            Position newPosition = new Position(randX,randY);

            Player newPlayer = new Player( newPosition,i);
            players.add(newPlayer);
        }

    }



}
