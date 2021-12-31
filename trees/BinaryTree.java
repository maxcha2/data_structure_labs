package trees;

import java.util.List;

public abstract class BinaryTree<T> {
    public abstract T data();
    public abstract BinaryTree<T> leftChild();
    public abstract BinaryTree<T> rightChild();
    public abstract boolean isEmpty();
    public abstract int height();
    public abstract int diameter();
    public abstract int nodeCount();
    public abstract int leafCount();
    public abstract int levelCount(int level);
    public abstract BinaryTree<T> mirrorImage();
    public abstract BinaryTree<T> pare();
    public abstract BinaryTree<T> cutLeaves();
    public abstract int weightBalanceFactor();
    public abstract void preOrderElements(List<T> list);
    public abstract void postOrderElements(List<T> list);
    public abstract void inOrderElements(List<T> list);
}
