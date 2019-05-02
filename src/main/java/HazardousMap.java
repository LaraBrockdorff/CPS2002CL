import java.util.Random;

public class HazardousMap extends Map{
    private Dat[][]map;
    private int waterCount;
    private Double maxWater = 0.35;


    public void generate(int num){
        int arrSize= getSize();
        Random r = new Random();
        map= new Dat[arrSize][arrSize];




        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < arrSize; j++) {
                char x=' ';
                map[i][j] = new Dat(x,num);
            }
        }

        final String alphabet = "gw";
        final int N = alphabet.length();



        do {
            for (int i = 0; i < arrSize; i++) {
                for (int j = 0; j < arrSize; j++) {
                    map[i][j].type = alphabet.charAt(r.nextInt(N));
                    if (map[i][j].type == 'w') {
                        waterCount = waterCount + 1;
                    }
                }
            }
        }while((waterCount/getSize()*getSize())<maxWater);

        int x_coordinate = r.nextInt(arrSize);
        int y_coordinate = r.nextInt(arrSize);

        map[x_coordinate][y_coordinate].type = 't';
        setMap(map);
    }
}
