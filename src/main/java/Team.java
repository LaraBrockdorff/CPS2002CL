import java.util.ArrayList;
import java.util.List;

public class Team {

        private int x;
        private int y;
        private List<Observer> observers= new ArrayList<Observer>();

        public void addObserver(Observer observer){
            this.observers.add(observer);
        }

        public void removeObserver(Observer observer){
            this.observers.remove(observer);
        }

        public void setVisited(int x, int y){
            this.x=x;
            this.y=y;

            for(Observer observer: this.observers){
                observer.update(this.x,this.y);
            }
        }
}
