public final class ArraySetBag<T> implements SetInterface<T> {
	
	private ResizableArrayBag<T> bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	
	public ArraySetBag() {
		this(DEFAULT_CAPACITY);
	}

	public ArraySetBag(int capacity) {
		checkCapacity(capacity);
		
		bag = new ResizableArrayBag<T>(capacity);
		numberOfEntries = 0;
	}
	
	public ArraySetBag(T[] contents) {
		checkCapacity(contents.length);
		
		bag = new ResizableArrayBag<T>(contents);
		numberOfEntries = 0;
	}
	
	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " +
                    "allowed maximum of " + MAX_CAPACITY);
	}
	
	public int getCurrentSize() {
		return numberOfEntries;
	}

	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	public boolean add(T newEntry) {
		if(bag.contains(newEntry))
			return false;
		
		numberOfEntries++;
		return bag.add(newEntry);
	}

	public boolean remove(T anEntry) {
		numberOfEntries--;
		return bag.remove(anEntry);
	}

	public T remove() {
		return bag.remove();
	}

	public void clear() {
		bag.clear();
	}

	public boolean contains(T anEntry) {
		return bag.contains(anEntry);
	}

	public T[] toArray() {
		return bag.toArray();
	}
}
