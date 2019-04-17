import java.util.Random;

public class Map {
    int size;


    private char [][]map;


    public char[][] getMap() {
        return map;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean setMapSize(int noOfPlayers, int size){

        boolean valid=false;
        if(noOfPlayers>=2 && noOfPlayers<=4){
            if(size>=5 && size<=50) {
                valid= true;
                setSize(size);
            }
        }
        else if(noOfPlayers>=5 && noOfPlayers<=8){
            if(size>=8 && size<=50){
                valid= true;
                setSize(size);
            }
        }
        else{
            valid=false;
        }
        return valid;
    }

    public void generate(){
        int arrSize=size-1;
        Random r = new Random();
        map= new char[arrSize][arrSize];

        int x_coordinate= r.nextInt(arrSize);
        int y_coordinate=r.nextInt(arrSize);

        map[x_coordinate][y_coordinate]='t';

        final String alphabet = "gw";
        final int N = alphabet.length();



        for(int i=0; i<arrSize; i++){
            for(int j=0; j<arrSize;j++){
                if(i!=x_coordinate && j!=y_coordinate) {
                    map[i][j] = alphabet.charAt(r.nextInt(N));
                }
            }
        }

    }

    public char getTileType(int x, int y){
        int arrSize=size-1;
        char type=' ';

        if(x<=arrSize && y<=arrSize) {
            if (map[x][y] == 'g') {
                type = 'g';
            } else if (map[x][y] == 'w') {
                type = 'w';
            } else if (map[x][y] == 't') {
                type = 't';
            }
        }
        else {
           type=  'e';
        }
        return type;
    }
}
