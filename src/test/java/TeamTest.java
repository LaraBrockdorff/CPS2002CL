import org.junit.Before;
import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.*;

public class TeamTest {
    Team team= new Team();
    Player Teamplayer;
    @Before
    public void setUp(){

        Position position = new Position( 2,2);
        Teamplayer = new Player(position, 0);
        Teamplayer.setStartingPos(position);
        team.addObserver(Teamplayer);
    }

    @Test
    public void addObserver() {
        int initailSize = team.getObservers().size();

        Player newplayer;
        Position Newposition = new Position( 0,0);
        newplayer = new Player(Newposition, 1);

        team.addObserver(newplayer);

        assertTrue(team.getObservers().stream().anyMatch(new Predicate<Player>() {
            @Override
            public boolean test(Player player) {
                return newplayer.equals(player);
            }
        }));
        assertTrue(team.getObservers().size()==(initailSize+1));
    }

    @Test
    public void removeObserver() {

        int initailSize = team.getObservers().size();



        team.removeObserver(Teamplayer);



        assertFalse(team.getObservers().stream().anyMatch(new Predicate<Player>() {
            @Override
            public boolean test(Player player) {
                return Teamplayer.equals(player);
            }
        }));
        assertTrue(team.getObservers().size()==(initailSize-1));

    }
}