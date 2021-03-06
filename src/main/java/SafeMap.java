import java.util.Random;

public class SafeMap  extends Map{
    private Dat[][]map;
    private int waterCount;
    private Double maxWater = 0.1;

    @Override
    public Dat[][] getMap() {
        return map;
    }

    @Override
    public void setMap(Dat[][] map) {
        this.map = map;
    }

    public int getWaterCount() {
        return waterCount;
    }

    public void setWaterCount(int waterCount) {
        this.waterCount = waterCount;
    }

    public Double getMaxWater() {
        return maxWater;
    }

    public void setMaxWater(Double maxWater) {
        this.maxWater = maxWater;
    }

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



            for (int i = 0; i < arrSize; i++) {
                for (int j = 0; j < arrSize; j++) {
                    if((waterCount/getSize()*getSize())<maxWater) {
                        map[i][j].type = alphabet.charAt(r.nextInt(N));
                    }else {
                        map[i][j].type = 'g';
                    }

                    if (map[i][j].type == 'w') {
                        waterCount = waterCount + 1;
                    }
                }
            }


        int x_coordinate = r.nextInt(arrSize);
        int y_coordinate = r.nextInt(arrSize);

        map[x_coordinate][y_coordinate].type = 't';
        super.setMap(map);
    }
}
