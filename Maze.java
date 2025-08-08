import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;


public class Maze {
    private MazeSquare[][] maze;
    private MazeSquare start, exit;
    private int numRows;
    private int numCols;

    public Maze(){
        maze = null;
    }

    public void loadMaze(String fname) throws Exception{
        File file = new File(fname);
        Scanner sc = new Scanner(file);
        String[] firstLine = sc.nextLine().split(" ");
        numRows = Integer.valueOf(firstLine[0]);
        numCols = Integer.valueOf(firstLine[1]);
        maze = new MazeSquare[numRows][numCols];
        
        if (sc.hasNextLine()){
            for (int r = 0; r < numRows; r++){
                String line = sc.nextLine().replaceAll(" ", "");
                for (int c = 0; c < line.length(); c++){
                    maze[r][c] = new MazeSquare(r, c, Integer.valueOf(line.substring(c, c+1)));
                    if (maze[r][c].getStatusNum() == 3) exit = maze[r][c];
                    if (maze[r][c].getStatusNum() == 2) start = maze[r][c];
                }
            }
        }
        sc.close();
    }

    public ArrayList<MazeSquare> getNeighbors (MazeSquare sq){
        ArrayList<MazeSquare> neighbors = new ArrayList<>();
        int r = sq.getRow();
        int c = sq.getCol();
        if (r > 0)
            neighbors.add(maze[r-1][c]);
        if (c < numCols-1)
            neighbors.add(maze[r][c+1]);
        if (r < numRows - 1)
            neighbors.add(maze[r+1][c]);
        if (c > 0)
            neighbors.add(maze[r][c-1]);
        return neighbors;
    }

    public MazeSquare getStart(){
        return start;
    }

    public MazeSquare getFinish(){
        return exit;
    }

    public void reset(){

    }

    public String toString(){
        String result = "";
        for (int r = 0; r < numRows; r++){
                for (int c = 0; c < numCols; c++){
                    MazeSquare sq = maze[r][c];
                    result += MazeSquare.CODE_CHARS.charAt(sq.getStatusNum());
                }
                result += "\n";
            }
            return result;
    }

    public static void main(String[] args) throws Exception{
        Maze m = new Maze();
        m.loadMaze("MazeExample.txt");
        System.out.println(m.toString());
        System.out.println("Start: " + m.getStart().toString());
        System.out.println("End: " + m.getFinish().toString());
    }
}
