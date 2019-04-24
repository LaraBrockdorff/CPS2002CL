import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    Player player;

    @Before
    public void setup(){
        Map map = new Map();

        Position position = new Position( 2,2);
        player = new Player(position, 0);
        player.setStartingPos(position);

        map.setMapSize(2, 5);
        map.generate(2);

        player.setMap(map);
    }

    @Test
    public  void test_moveInvalid() {
       boolean retValue = player.move("i");
       assertFalse(retValue);
    }

    @Test
    public  void test_moveR() {
        boolean retValue = player.move("R");
        assertTrue(retValue);
        Position expectedPosition =new Position(2,3);
        assertEquals(expectedPosition.getX(), player.getPosition().getX());
        assertEquals(expectedPosition.getY(), player.getPosition().getY());
    }

    @Test
    public  void test_mover() {
        boolean retValue = player.move("r");
        assertTrue(retValue);
        Position expectedPosition =new Position(2,3);
        assertEquals(expectedPosition.getX(), player.getPosition().getX());
        assertEquals(expectedPosition.getY(), player.getPosition().getY());
    }

    @Test
    public  void test_moveL() {
        boolean retValue = player.move("L");
        assertTrue(retValue);
        Position expectedPosition =new Position(2,1);
        assertEquals(expectedPosition.getX(), player.getPosition().getX());
        assertEquals(expectedPosition.getY(), player.getPosition().getY());
    }

    @Test
    public  void test_movel() {
        boolean retValue = player.move("l");
        assertTrue(retValue);
        Position expectedPosition =new Position(2,1);
        assertEquals(expectedPosition.getX(), player.getPosition().getX());
        assertEquals(expectedPosition.getY(), player.getPosition().getY());
    }

    @Test
    public  void test_moveU() {
        boolean retValue = player.move("U");
        assertTrue(retValue);
        Position expectedPosition =new Position(1,2);
        assertEquals(expectedPosition.getX(), player.getPosition().getX());
        assertEquals(expectedPosition.getY(), player.getPosition().getY());
    }

    @Test
    public  void test_moveu() {
        boolean retValue = player.move("u");
        assertTrue(retValue);
        Position expectedPosition =new Position(1,2);
        assertEquals(expectedPosition.getX(), player.getPosition().getX());
        assertEquals(expectedPosition.getY(), player.getPosition().getY());
    }

    @Test
    public  void test_moveD() {
        boolean retValue = player.move("D");
        assertTrue(retValue);
        Position expectedPosition =new Position(3,2);
        assertEquals(expectedPosition.getX(), player.getPosition().getX());
        assertEquals(expectedPosition.getY(), player.getPosition().getY());
    }

    @Test
    public  void test_moved() {
        boolean retValue = player.move("d");
        assertTrue(retValue);
        Position expectedPosition =new Position(3,2);
        assertEquals(expectedPosition.getX(), player.getPosition().getX());
        assertEquals(expectedPosition.getY(), player.getPosition().getY());
    }
}