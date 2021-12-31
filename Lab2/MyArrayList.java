package Lab2;

import java.util.AbstractList;

public class MyArrayList<E> extends AbstractList<E> {
	
	private int size;
	
	private E[] data;
	
	MyArrayList(int startSize){
		this.size = 0;
		@SuppressWarnings("unchecked")
		E[] newArray = (E[])new Object[startSize];
		data = newArray;
	}
	
	MyArrayList(){
		this(2);
	}
	
	private void resize(){
		int len = data.length;
		E[] newArray = (E[]) new Object[len*2];
		this.data = newArray;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public void add(int index, E element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if(size == data.length) {
			resize();
		}
		for (int i = size; i> index; i--) {
				data[i] = data[i-1];
		}
		data[index] = element;
		size++;
	}
	
	public boolean add(E element){
		add(size(), element);
		return true;
	}
	
	@Override
	public E get(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		return data[index];
	}

	public E set(int index, E element){
		E val = get(index);
		data[index] = element;
		return val;
	}
	
	public E remove(int index) {
		E reval = get(index);
		for (int i = index; i< size; i++) {
			data[i] = data[i+1];
		}
		return reval;
	}
	
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void clear() {
		size = 0;
		data = null;
	}
}
