public class Player {

    private Position position;

    private int PlayerId;

    public Player(Position position, int playerId) {
        this.position = position;
        PlayerId = playerId;
    }

    public boolean move(String direction){
        if(direction.equalsIgnoreCase("l")){
            position.setX(position.getX() -1);
            return true;
        }else if(direction.equalsIgnoreCase("r")){
            position.setX(position.getX() +1);
            return true;
        }else if(direction.equalsIgnoreCase("u")){
            position.setY(position.getY() -1);
            return true;
        }else if(direction.equalsIgnoreCase("d")){
            position.setY(position.getY() +1);
            return true;
        }else{
            System.out.println("Invalid direction. Only : U, D, L ,R are accepted");
            return false;

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
