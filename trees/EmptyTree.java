package trees;

import java.util.List;
import java.util.NoSuchElementException;

public class EmptyTree<T> extends BinaryTree<T> {
    @Override
    public T data() {
        throw new NoSuchElementException();
    }

    @Override
    public BinaryTree<T> leftChild() {
        throw new NoSuchElementException();
    }

    @Override
    public BinaryTree<T> rightChild() {
        throw new NoSuchElementException();
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int height() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int diameter() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int nodeCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int leafCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int levelCount(int level) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public BinaryTree<T> mirrorImage() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BinaryTree<T> pare() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BinaryTree<T> cutLeaves() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int weightBalanceFactor() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void preOrderElements(List<T> list) {
        // TODO Auto-generated method stub

    }

    @Override
    public void postOrderElements(List<T> list) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void inOrderElements(List<T> list) {
        // TODO Auto-generated method stub
        
    }
}
