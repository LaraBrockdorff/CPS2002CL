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

            }
        }while (!valid);

        int mapSize=0;
        do{
        System.out.println("How many rows (and columns) would you like? ");
         mapSize = sc.nextInt();
        if (( n<6 && (mapSize < 5 || mapSize> 50)) || ((n>5 && n<9)&&(mapSize < 8 || mapSize> 50))){
            valid= false;
        }else{
            valid=true;

        }

        }while(!valid);

       // setNumberOfPlayers(n);
        map.setMapSize(n, mapSize);
        map.generate(n);
        setNumberOfPlayers(n);
        gameLoop(n);

    }

    public void setNumberOfPlayers(int n){
        this.n =n;
        int randX = 0;
        int randY = 0;

        for(int i =0; i<n ; i++){

                do {
                    randX = (int) (Math.random() * map.getSize()+1) ;
                    randY = (int) (Math.random() * map.getSize()+1) ;
                }while (map.getTileType(randX,randY) != 'g');

            Position newPosition = new Position(randX,randY);

            Player newPlayer = new Player( newPosition,i);
            newPlayer.setStartingPos(newPosition);
            newPlayer.setMap(map);
            players.add(newPlayer);
        }

    }

    public void gameLoop(int noOfPlayers){
        Scanner sc = new Scanner(System.in);
        boolean treasureFound=false;
        String [] directions= new String[noOfPlayers];
        do {
            for (int i = 0; i < noOfPlayers; i++) {
                System.out.println("PLAYER NO: "+ i);
                System.out.println("ENTER DIRECTION TO MOVE IN");
                String direction= sc.next();
                directions[i]=direction;
            }

            for(int i=0 ; i<noOfPlayers;i++) {
                System.out.println("PLAYER : "+ i);
                Player player= players.get(i);
                String dir= directions[i];
                if (player.move(dir)) {
                    Position pos = player.getPosition();
                    int x = pos.getX();
                    int y = pos.getY();
                    Map playerMap = player.getMap();
                    treasureFound = playerMap.visitMap(x, y,playerMap,i,players);
                    playerMap.generateFile(i,players);
                }
            }
        } while(!treasureFound);
    }



}
