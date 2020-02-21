
public final class LinkedSet<T> implements SetInterface<T> {
	
	private Node firstNode;
	private int numberOfEntries;
	
	public LinkedSet() {
		firstNode = null;
		numberOfEntries = 0;
	}

	public int getCurrentSize() {
		return numberOfEntries;
	}

	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	public boolean add(T newEntry) {
		if(contains(newEntry))
			return false;
		
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;
		firstNode = newNode;
		numberOfEntries++;
		return true;
	}

	public boolean remove(T anEntry) {
		boolean result = false;
		Node nodeN = getReferenceTo(anEntry);

		if (nodeN != null)
		{
			nodeN.data = firstNode.data;
			firstNode = firstNode.next;
			numberOfEntries--;
			result = true;
		}

		return result;
	}

	public T remove() {
		T result = null;
		if (firstNode != null) {
			result = firstNode.data; 
			firstNode = firstNode.next;
			numberOfEntries--;
		}

		return result;
	}

	public void clear() {
		while(!isEmpty())
			remove();
	}

	public boolean contains(T anEntry) {
		return getReferenceTo(anEntry) != null;
	}
	
	public Node getReferenceTo(T anEntry) {
		boolean found = false;
		Node current = firstNode;
		
		while(!found && current != null) {
			if(anEntry.equals(current.data))
				found = true;
			else
				current = current.next;
		}
		return current;
	}

	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		int index = 0;
		Node current = firstNode;
		
		while((index < numberOfEntries) && (current != null)) {
			result[index++] = current.data;
			current = current.next;
		}
		return result;
	}
	
	private class Node {
		private T data;
		private Node next;
		
		private Node(T dataPortion) {
			this(dataPortion, null);
		}
		
		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}
	}
}
