package lab3;

import java.util.*;

abstract class MazeSolver {
    protected Maze maze;
    protected boolean finished = false;
    protected boolean pathFound = false; 
    ArrayList<Square> worklist = new ArrayList<>();
    MazeSolver(Maze maze) {
        this.maze = maze;
    }
    
    // creates an empty worklist
    abstract void makeEmpty();

    // tests if the worklist is empty
    abstract boolean isEmpty();

    // adds a squaren to the worklist
    abstract void add(Square sq);

    // removes the next element from the worklist and returns it
    abstract Square next();

    public boolean isFinished() {
        return finished;
    }

    public boolean pathFound() {
        return pathFound;
    }

    /*
     * makes a list of the squares on a path from the start square to the exit
     * square
     */
    public List<Square> getPath() {
        // TODO: write the getPath method
        MyStack<Square> stack = new MyStack<Square>();
        Square s = maze.getExit();
        for (int i = 0; i < stack.size(); i++) {
            stack.push(s);
            s = s.getPrevious();
            if (s.getType() == Square.START) {
                break;
            }
        }
        ArrayList<Square>path = new ArrayList<Square>();
        while (!stack.isEmpty()) {
            Square t = stack.pop();
            path.add(t);
        }
        return path;
    }

    /* performs one step of the maze solver algorithm */
    public void step() {
       Square current = null;
       if (!worklist.isEmpty()) {
           ArrayList<Square> neighbor = maze.getNeighbors(current);
           for (int i = 0; i < neighbor.size(); i++) {
               Square e = neighbor.get(i);
               if (e.isMarked()) {
                   continue;
               }
               else {
                   e.mark();
                   e.setPrevious(current);
                   worklist.add(e);
               }
           }
       }
       else {
           pathFound = true;
           finished = true;
       }
    }
}
    
