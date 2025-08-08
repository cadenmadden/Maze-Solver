public class MazeSolverStack extends MazeSolver {
    private Stack<MazeSquare> stack;

    public MazeSolverStack(Maze maze) {
        super(maze);
        stack = new Stack<>();
        makeEmpty();
        add(maze.getStart());
    }

    @Override
    public void makeEmpty() {
        while (!stack.isEmpty()){
            stack.pop();
        }
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public void add(MazeSquare sq) {
        stack.push(sq);
    }

    @Override
    public MazeSquare next() {
        return stack.pop();
    }

    public static void main(String[] args) {
        Maze maze = new Maze();
        try {
            maze.loadMaze("MazeExample.txt");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        MazeSolverStack mss = new MazeSolverStack(maze);
        mss.solve();
        System.out.println(mss.getPath());
    }
}
