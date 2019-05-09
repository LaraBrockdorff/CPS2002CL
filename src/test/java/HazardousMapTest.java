import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;


public class HazardousMapTest {
    HazardousMap maps;
    @Before
    public void setup (){
<<<<<<< HEAD:src/test/java/HazardousMapTest.java
        maps = new HazardousMap();
=======
        maps = Map.getInstance();
>>>>>>> ca554000c3c9dfa0bca9750bda7082cceeb26725:src/test/java/MapTest.java
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

    @Test
    public void test_WaterRange(){
        maps.setSize(5);
        maps.generate(2);
        int waterRatio = maps.getWaterCount();


        assertTrue(((waterRatio/(maps.getSize()*maps.getSize()))<= 0.35));


    }
}
