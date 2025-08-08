public class MazeSolverQueue extends MazeSolver {
    private Queue<MazeSquare> queue;
    public MazeSolverQueue(Maze maze) {
        super(maze);
        queue = new Queue<>();
        makeEmpty();
        add(maze.getStart());
    }

    @Override
    public void makeEmpty() {
        queue = new Queue<>();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void add(MazeSquare sq) {
        queue.enqueue(sq);
    }

    @Override
    public MazeSquare next() {
        return queue.dequeue();
    }

    public static void main(String[] args) {
        Maze maze = new Maze();
        try {
            maze.loadMaze("MazeExample.txt");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        MazeSolverQueue msq = new MazeSolverQueue(maze);
        msq.solve();
        System.out.println(msq.getPath());
    }
}
