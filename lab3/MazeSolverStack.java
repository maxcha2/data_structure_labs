package lab3;

public class MazeSolverStack extends MazeSolver {
    MyStack<Square> worklist;

    public MazeSolverStack(Maze maze) {
        super(maze);
        worklist = new MyStack<Square>();
        Square current = maze.getStart();
        current.mark();
        add(current);
    }
    
    // creates an empty worklist
    public void makeEmpty() {
        worklist = new MyStack<Square>();
    }
    
    public boolean isEmpty() {
        return worklist.isEmpty();
    }

    public void add(Square sq) {
        worklist.push(sq);
    }

    public Square next() {
        return worklist.pop();
    }


}