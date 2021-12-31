package lab3;

public class MazeSolverQueue extends MazeSolver {
    MyQueue<Square> worklist;
    public MazeSolverQueue(Maze maze) {
        super(maze);
        // TODO Auto-generated constructor stub
        worklist = new MyQueue<Square>();
        Square current = maze.getStart();
        current.mark();
        add(current);
    }

    @Override
    void makeEmpty() {
        // TODO Auto-generated method stub
        worklist = new MyQueue<Square>();
    }

    @Override
    boolean isEmpty() {
        // TODO Auto-generated method stub
        return worklist.isEmpty();
    }

    @Override
    void add(Square sq) {
        // TODO Auto-generated method stub
        worklist.enqueue(sq);
    }

    @Override
    public Square next() {
        // TODO Auto-generated method stub
        return worklist.dequeue();
    }

}
