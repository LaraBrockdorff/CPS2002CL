public class Player {

    private Position position;
    private Map map;
    private int PlayerId;
    private  Position startingPos;

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Position getStartingPos() {
        return startingPos;
    }

    public void setStartingPos(Position startingPos) {
        this.startingPos = startingPos;
    }

    public Player(Position position, int playerId) {
        this.position = position;
        PlayerId = playerId;
    }

    public boolean move(String direction){
        int newPos=0;
        if(direction.equalsIgnoreCase("u")){
            newPos= (position.getX() -1) %(map.getSize()-1);
            if(newPos==-1){
                newPos=map.getSize()-1;
            }
            System.out.println(newPos);
            position.setX(newPos);
            return true;
        }else if(direction.equalsIgnoreCase("d")){
            newPos=(position.getX() +1) % (map.getSize()-1);
            if(newPos==-1){
                newPos=map.getSize()-1;
            }
            System.out.println(newPos);
            position.setX(newPos);
            return true;
        }else if(direction.equalsIgnoreCase("l")){
            newPos=(position.getY() -1) % (map.getSize()-1);

            if(newPos==-1){
                newPos=map.getSize()-1;
            }
            System.out.println(newPos);
            position.setY(newPos);

            return true;
        }else if(direction.equalsIgnoreCase("r")){
            newPos= (position.getY() +1) %(map.getSize()-1);

            if(newPos==-1){
                newPos=map.getSize()-1;
            }
            position.setY(newPos);
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
