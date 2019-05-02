import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public abstract class Map {
    private int size;
    private Dat[][]map;


    public Dat[][] getMap() {
        return map;
    }

    public void setMap(Dat[][] map) {
        this.map = map;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean setMapSize(int noOfPlayers, int size){

        boolean valid=false;
        if(noOfPlayers>=2 && noOfPlayers<=4){
            if(size>=5 && size<=50) {
                valid= true;
                setSize(size);
            }
        }
        else if(noOfPlayers>=5 && noOfPlayers<=8){
            if(size>=8 && size<=50){
                valid= true;
                setSize(size);
            }
        }
        else{
            valid=false;
        }
        return valid;
    }

    public abstract void generate(int num);



    public char getTileType(int x, int y){
        int arrSize=size-1;
        char type=' ';

        if(x<arrSize && y<arrSize) {
            if (map[x][y].type == 'g') {
                type = 'g';
            } else if (map[x][y].type == 'w') {
                type = 'w';
            } else if (map[x][y].type == 't') {
                type = 't';
            }
        }
        else {
           type=  'e';
        }
        return type;
    }

    public String generateHTML(Map mapp, int no) {
        Dat[][] mp = mapp.map;

        StringBuilder sb = new StringBuilder();
        int width = 100;
        int vx = 0;
        int vy = 0;
        sb.append("<table style=\"width:100%\">\n");
        for (int row = 0; row < mp.length; row++) {
            sb.append("<STYLE TYPE=\"text/css\">");
            sb.append("<!--");
            sb.append("TD{font-family: Arial; font-size: 50pt;}");
            sb.append("--->");
            sb.append("</STYLE>");
            sb.append("\t<tr>\n");

            for (int col = 0; col < mp[0].length; col++) {
                if (mp[row][col].type == 'g' && mp[row][col].visited[no] && !mp[row][col].isVisiting[no]) {
                    sb.append("\t\t<td  height = \"" + width + "\"  width=\"" + width + " \" bgcolor=\"green\"   align = \" center\"  >" + "          " + "</td>\n");

                } else if (mp[row][col].type == 'w' && mp[row][col].visited[no] && !mp[row][col].isVisiting[no]) {
                    sb.append("\t\t<td  height = \"" + width + "\"  width=\"" + width + " \" bgcolor=\"blue\"   align = \" center\"  >" + "          " + "</td>\n");
                } else if (mp[row][col].type == 't' && mp[row][col].visited[no] && !mp[row][col].isVisiting[no]) {
                    sb.append("\t\t<td  height = \"" + width + "\"  width=\"" + width + " \" bgcolor=\"yellow\" align = \" center\"  >" + "          " + "</td>\n");
                } else if (mp[row][col].type == 'g' && mp[row][col].visited[no] && mp[row][col].isVisiting[no]) {
                    sb.append("\t\t<td  height = \"" + width + "\"  width=\"" + width + " \" bgcolor=\"green\"   align = \" center\"  >" + " &#128519 " + "</td>\n");
                    vx = row;
                    vy = col;
                } else if (mp[row][col].type == 't' && mp[row][col].visited[no] && mp[row][col].isVisiting[no]) {
                    sb.append("\t\t<td   height = \"" + width + "\" width=\"" + width + "\" bgcolor=\"yellow\"  align = \" center\"  >" + " &#128519" + "</td>\n");
                    vx = row;
                    vy = col;
                } else if (mp[row][col].type == 'w' && mp[row][col].visited [no]&& mp[row][col].isVisiting[no]) {
                    sb.append("\t\t<td height= \"" + width + "\" width=\"" + width + " \"  bgcolor=\"blue\"  align = \" center\"  >" + " &#128519" + "</td>\n");
                    vx = row;
                    vy = col;
                } else {
                    sb.append("\t\t<td height= \"" + width + "\" width=\"" + width + " \"  bgcolor=\"grey\" valign =\" middle \" align = \" center\" >" + "      " + "</td>\n");
                }

                //map[row][col].isVisiting=false;
            }
        }
        sb.append("\t</tr>\n");

        sb.append("</table>");

        map[vx][vy].isVisiting[no] = false;
        return sb.toString();
    }

    public void generateFile(int i, List<Player> players) {

        File f = new File("test_" + i + ".html");
        Map map = players.get(i).getMap();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write(generateHTML(map,i));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public boolean visitMap(int x, int y, Map mapp, int no,List<Player>players) {
         Dat[][] mp = mapp.getMap();
        boolean found = false;
        if (mp[x][y].type == 'g') {
            mp[x][y].visited[no] = true;
            mp[x][y].isVisiting[no] = true;
            System.out.println(" PHEWWW ! COORDINATES (" + x + "," + y + ") ARE SAFE :| CONTINUE");

        } else if (mp[x][y].type == 'w') {
            mp[x][y].visited[no]= true;
            mp[x][y].isVisiting[no] = true;
            System.out.println("OOPS! COORDINATES (" + x + "," + y + ") ARE WATER :( GO BACK TO THE STARTING POSITION");
            players.get(no).setPosition(players.get(no).getStartingPos());

        } else if (mp[x][y].type == 't') {
            mp[x][y].visited[no] = true;
            mp[x][y].isVisiting[no] = true;
            System.out.println("COORDINATES (" + x + "," + y + ")  IS THE TREASURE :) YOU WON");
            found = true;
        }

        return found;
    }




}
