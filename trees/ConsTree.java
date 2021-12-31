package trees;

import java.util.List;

public class ConsTree<T> extends BinaryTree<T> {
	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;

	public ConsTree(T data, BinaryTree<T> left, BinaryTree<T> right) {
		this.data = data;
		this.leftChild = left;
		this.rightChild = right;
	}

	public ConsTree(T data) {
		this(data, new EmptyTree<T>(), new EmptyTree<T>());
	}
	
    @Override
    public T data() {
        return this.data;
    }

    @Override
    public BinaryTree<T> leftChild() {
        return this.leftChild;
    }

    @Override
    public BinaryTree<T> rightChild() {
        return this.rightChild;
    }

    @Override
    public boolean isEmpty() {
    	return false;
    }

    @Override
    public int height() {
    	if(data == null) {
    		return -1;
    	}
    	else {
    		return 1 + Math.max(leftChild.height(), rightChild.height());
    	}
    }

    @Override
    public int diameter() {
    	if (data == null) {
            return 0;
    	}
    	else {
	        int leftHeight = height();
	        int rightHeight = height();
	        int leftDiameter = leftChild.diameter();
	        int rightDiameter = rightChild.diameter();
	        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    	}
    }

    @Override
    public int nodeCount() {
    	return 1 + leftChild.nodeCount() + rightChild.nodeCount();
    }

    @Override
    public int leafCount() {
    	if (data == null) {
    		return -1;
    	}
    	else if (leftChild == null && rightChild == null) { 
    		return 0;
    	}
    	else {
    		return 1 + Math.max(leftChild.leafCount(), rightChild.leafCount());
    	}
    }

    @Override
    public int levelCount(int level) {
    	if (data == null) {
            return 0;
        }
        else {
            return 1 + Math.max(leftChild.height(), rightChild.height());
        }
    }

    @Override
    public BinaryTree<T> mirrorImage() {
    	BinaryTree<T> temp;
    	leftChild.mirrorImage();
    	rightChild.mirrorImage();
    	temp = leftChild;
    	leftChild = rightChild;
    	rightChild = temp;
    	return temp.mirrorImage();
    }

    @Override
    public BinaryTree<T> pare() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BinaryTree<T> cutLeaves() {
    	if (data == null) {
            return null;
        }
        if (leftChild == null && rightChild == null) {
            return null;
        }
        else {    	
        	leftChild = leftChild.cutLeaves();
        	rightChild = rightChild.cutLeaves();
        	return leftChild;
        }
    }
    

    @Override
    public int weightBalanceFactor() {
        int f = leftChild.nodeCount() - rightChild.nodeCount();
        if (f < 0) {
        	f = -f;
        }
        return 1 + Math.max(leftChild.weightBalanceFactor(), rightChild.weightBalanceFactor());
    }

    @Override
    public void preOrderElements(List<T> list) {
    	list.add(data);
    	leftChild.preOrderElements(list);
    	rightChild.preOrderElements(list);
    }

    @Override
    public void postOrderElements(List<T> list) {
        leftChild.postOrderElements(list);
        rightChild.postOrderElements(list);
        list.add(data);
    }

    @Override
    public void inOrderElements(List<T> list) {
        leftChild.inOrderElements(list);
        list.add(data);
        rightChild.inOrderElements(list);
    }
}
