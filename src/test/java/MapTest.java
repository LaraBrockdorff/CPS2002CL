import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;


public class MapTest {
    Map maps;
    @Before
    public void setup (){
        maps = Map.getInstance();
    }

    @Test
    public  void test_setMapSize() {
        int noOfPlayers = 5;
        int size =10;
        assertEquals(true,maps.setMapSize(noOfPlayers,size));
    }

    @Test
    public  void test_setMapSizeValidParams() {
        int noOfPlayers = 2;
        int size = 7;
        assertEquals(true,maps.setMapSize(noOfPlayers,size));
    }


    @Test
    public  void test_setMapSizeInvalidPlayer() {
        int noOfPlayers = 1;
        int size =10;
        assertEquals(false,maps.setMapSize(noOfPlayers,size));
    }

    @Test
    public  void test_setMapSizeInvalidSize() {
        int noOfPlayers = 3;
        int size =60;
        assertEquals(false,maps.setMapSize(noOfPlayers,size));
    }

    @Test
    public  void test_setMapSizeInvalidParams() {
        int noOfPlayers = 2;
        int size =4;
        assertEquals(false,maps.setMapSize(noOfPlayers,size));
    }

    @Test
    public  void test_getTileType() {
        int x=3;
        int y =7;
        maps.setSize(12);
        maps.generate(5);
        Dat [][] map= maps.getMap();

        assertEquals(map[x][y].type,maps.getTileType(x,y));
        System.out.println(maps.getTileType(x,y) );
        System.out.println(map[x][y]);
    }

    @Test
    public  void test_getTileTypeInvalidParam() {
        int x=1;
        int y =7;
        maps.setSize(3);
        maps.generate(2);
        Dat [][] map= maps.getMap();
        assertEquals('e',maps.getTileType(x,y));
        System.out.println("ERROR");
        System.out.println();
    }


}
