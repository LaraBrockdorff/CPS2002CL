import java.util.ArrayList;
import java.util.List;

public class PlayersTeam  {

    private int x;
    private int y;
    private List<Player> observers= new ArrayList<Player>();

    public void addObserver(Player observer){
        this.observers.add(observer);
    }

    public void removeObserver(Player observer){
        this.observers.remove(observer);
    }

    public void setVisited(int x, int y){
        this.x=x;
        this.y=y;

        for(Player observer: this.observers){
            observer.update(this.x,this.y);
        }
    }

    public List<Player> getObservers() {
        return observers;
    }


    public void setObservers(List<Player> observers) {
        this.observers = observers;
    }

    public String toString() {
        return "Team{" +
                "observers=" + observers +
                '}';
    }
}
