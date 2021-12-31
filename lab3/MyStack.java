package lab3;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyStack<T> implements StackADT<T> {

    ArrayList<T> stack;
    int size;
    MyStack(){
        stack = new ArrayList<T>();
        this.size = 0;
    }
    public void push(T element){
        stack.add(element);
    }
    @Override
    public T pop() throws NoSuchElementException {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public T top() throws NoSuchElementException {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }




}
