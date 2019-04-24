public class Dat {
    char type;
    boolean [] visited;
    boolean [] isVisiting;

    public Dat(){
    }

    public Dat(char type, int num) {
        this.type = type;
        this.visited= new boolean[num];
        this.isVisiting=new boolean[num];
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public boolean isVisited(int num) {
        return visited[num];
    }

    public void setVisited(boolean visited,int num) {
        this.visited[num] = visited;
    }

    public boolean isVisiting(int num) {
        return isVisiting[num];
    }

    public void setVisiting(boolean visiting,int num) {
        isVisiting[num] = visiting;
    }

    @Override
    public String toString() {
        return "Dat{" +
                "type=" + type +
                ", visited=" + visited +
                '}';
    }
}
