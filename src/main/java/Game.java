import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private int turns;
    private List<Player> players = new ArrayList<Player>();
    List<Team> teamList=new ArrayList<Team>();

    private Map map;

    private  int n; // number of players
    private int mode;



  public static void main(String[] args) {
        Map map;
        map= Map.getInstance();
        Game thisGame = new Game();
        thisGame.startGame(map);


    }

    public void startGame(Map map){
        boolean valid= true;
        boolean teamValid=true;
        boolean validChar=true;
        boolean teamMode=true;

        int teams=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Game");

        System.out.println(" * Please choose : Safe [0] or Hazardous [1] Game mode \n by entering the corresponding number");
        mode = sc.nextInt();

        if(mode ==0 ){
            map = new SafeMap();
        } else if (mode ==1){
            map = new HazardousMap();
        }

        do {
            System.out.println("Collaborative mode( or Single Player)? (Y- COll or N- SING)");
            String choice = sc.next();
            teamMode=true;
            if (choice.contains("Y") || choice.contains("y")) {
                do {
                    System.out.println("How many teams would you like");
                    teams = sc.nextInt();

                    if (n >= 1) {
                        System.out.println("** Please enter a valid integer greater than 2 or 2 **");
                        teamValid = false;
                    } else {
                        teamValid = true;
                    }

                } while (!teamValid);

                do {
                    System.out.println("How many players would you like? ");

                    n = sc.nextInt();
                    if (n < 2 || n > 8) {
                        System.out.println("**Please enter a valid integer between 2 and 8 **");
                        valid = false;
                    } else {
                        valid = true;
                    }
                } while (!valid);
                validChar=true;


            } else if (choice.contains("N") || choice.contains("n")) {
                do {
                    System.out.println("How many players would you like? ");

                    n = sc.nextInt();
                    if (n < 2 || n > 8) {
                        System.out.println("**Please enter a valid integer between 2 and 8 **");
                        valid = false;
                    } else {
                        valid = true;
                    }
                } while (!valid);

                validChar=true;
            } else {
                System.out.println("INVALID CHARACTERS");
                validChar=false;
            }
        }while(!validChar);

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
        if(teams==0) {
            setNumberOfPlayers(n, map);
        }
        else{
            setNumberOfPlayersAndTeams(n,map,teams);
        }

        gameLoop(n,teamMode);


    }

    public void setNumberOfPlayersAndTeams(int n, Map map, int teams){

        this.n =n;
        int randX = 0;
        int randY = 0;
        int teamNo=0;
        for (int i = 0; i < teams; i++) {
            Team team = new Team();
            teamList.add(team);
        }
        for(int i =0; i<n ; i++) {

            do {
                randX = (int) (Math.random() * map.getSize());
                randY = (int) (Math.random() * map.getSize());
            } while (map.getTileType(randX, randY) != 'g');

            Position newPosition = new Position(randX, randY);

            Player newPlayer = new Player(newPosition, i);
            newPlayer.setStartingPos(newPosition);
            newPlayer.setMap(map);

            teamNo = (int) (Math.random() * teams);
            teamList.get(teamNo).addObserver(newPlayer);

            newPlayer.setTeamNumber(teamNo);
            players.add(newPlayer);

        }

        for(int i=0; i<teams;i++){
            System.out.println(teamList.get(i).toString()+ "\n");
        }
    }

    public void setNumberOfPlayers(int n, Map map){
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
            newPlayer.setStartingPos(newPosition);
            newPlayer.setMap(map);
            players.add(newPlayer);
        }

    }

    public void gameLoop(int noOfPlayers,boolean teamMode){
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
                    if(!teamMode) {
                        treasureFound = playerMap.visitMap(x, y, playerMap, i, players);

                    }
                    else {
                        List<Player> currentTeamPLayers = teamList.get(player.getTeamNumber()).getObservers() ;
                        playerMap.visitMapTeam(x,y,playerMap,i,currentTeamPLayers, teamList.get(player.getTeamNumber()));
                    }
                    playerMap.generateFile(player);

                }
            }
        } while(!treasureFound);
    }



}
