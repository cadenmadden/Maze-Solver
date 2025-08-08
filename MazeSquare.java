public class MazeSquare implements Comparable<MazeSquare>{
    private char status;
    private int status_num;
    private int row;
    private int col;
    private MazeSquare previous;
    public boolean isExplored;
    public static final char EMPTY = '_';
    public static final int EMPTY_NUM = 0;
    public static final char WALL = '#';
    public static final int WALL_NUM = 1;
    public static final char START = 'S';
    public static final int START_NUM = 2;
    public static final char EXIT = 'E';
    public static final int EXIT_NUM = 3;
    public static final char WORKING = 'o';
    public static final char PATH = 'x';
    public static final String CODE_CHARS = ""+EMPTY+WALL+START+EXIT;

    public MazeSquare(int r, int c, int type){
        row = r;
        col = c;
        status_num = type;
        status = CODE_CHARS.charAt(type);
        isExplored = false;
    }

    public int getRow(){
        return row;
    }

    public void setExplored(boolean b){
        isExplored = true;
    }

    public boolean isExplored(){
        return isExplored;
    }

    public void setPrevious(MazeSquare p){
        previous = p;
    }

    public MazeSquare getPrevious(){
        return previous;
    }
    
    public int getCol(){
        return col;
    }

    public int getStatusNum(){
        return status_num;
    }

    public char getStatus(){
        return status;
    }

    public void setStatus(char s){
        status = s;
    }

    public int compareTo(MazeSquare other){
        return 0;
    }

    public String toString(){
        return ("(" + getRow() + ", " + getCol() + ")");
    }
}
