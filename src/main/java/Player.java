public class Player {

    private Position position;

    private int PlayerId;

    public Player(Position position, int playerId) {
        this.position = position;
        PlayerId = playerId;
    }

    public void move(String direction){
        if(direction.equals("x")){
            position.incrementX();
        }else if(direction.equals("y")){
            position.incrementY();
        }
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getPlayerId() {
        return PlayerId;
    }

    public void setPlayerId(int playerId) {
        PlayerId = playerId;
    }
}
