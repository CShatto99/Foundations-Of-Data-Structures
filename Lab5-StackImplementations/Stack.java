import java.util.EmptyStackException;

public class Stack<T> implements StackInterface<T> {
	
	private T[] stack;
	private int topIndex;
	
	public Stack(int size) {
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])(new Object[size]);
		stack = tempStack;
		topIndex = size;
	}

	public void push(T newEntry) {
		ensureCapacity();
		stack[topIndex - 1] = newEntry;
		topIndex--;
	}

	public T pop() {
		if(isEmpty())
			throw new EmptyStackException();
		else {
			T top = stack[topIndex];
			stack[topIndex++] = null;
			return top;
		}
	}

	public T peek() {
		if(isEmpty())
			throw new EmptyStackException();
		else
			return stack[topIndex];
	}

	public boolean isEmpty() {
		return topIndex == stack.length;
	}

	public void clear() {
		while(!isEmpty())
			pop();
	}
	
	public void ensureCapacity() {
		if (topIndex <= 0) {
			int newLength = 2 * stack.length, stackIndex = 0;
			
			@SuppressWarnings("unchecked")
			T[] temp = (T[])(new Object[newLength]);
			
			for(int i = stack.length; i < newLength; i++)
				temp[i] = stack[stackIndex++];
			
			topIndex = stack.length;
			stack = temp;
		}
	}
	
	public T[] toArray() {
		T[] temp = stack;
		return temp;
	}
}