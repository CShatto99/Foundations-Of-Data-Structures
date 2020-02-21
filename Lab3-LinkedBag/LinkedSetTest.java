import java.util.Arrays;

public class LinkedSetTest {
	public static void main(String[] args) {
		
		// Test add method - add 10 random integers
		LinkedSet<Integer> s = new LinkedSet<Integer>();
		s.add(31);
		s.add(8);
		s.add(13);
		s.add(67);
		s.add(95);
		s.add(34);
		s.add(78);
		s.add(20);
		s.add(50);
		s.add(22);
		
		// Test toArray method
		System.out.println("Bag contents: " + Arrays.toString(s.toArray()) + "\n");
		
		// Test getCurrentSize method
		System.out.println("Size of the list " + s.getCurrentSize() + "\n");
		
		// Test isEmpty method
		if(s.isEmpty())
			System.out.println("The bag is empty!\n");
		else
			System.out.println("The bag is not empty!\n");
		
		// Test remove method (specified entry);
		int entry = 95;
		boolean removed = s.remove(entry);
		if(removed)
			System.out.println(entry + " was removed!\n");
		else
			System.out.println(entry + " was not in the list!\n");
		
		// Test remove method
		for(int i = 0; i < 3; i++) {
			Integer deleted = s.remove();
			System.out.println("Removed: " + deleted);
		}
		System.out.println();
		
		// Print list after removal
		System.out.println("Bag contents after removal: " + Arrays.toString(s.toArray()) + "\n");
		
		// Test contains and getReferenceTo methods
		int anEntry = 67;
		boolean entryFound = s.contains(anEntry);
		if(entryFound)
			System.out.println("The bag contains " + anEntry + "!\n");
		else
			System.out.println("The bag does not contain " + anEntry + "!\n");
		
		// Test clear method
		s.clear();
		System.out.println("Bag contents after clear method: " + Arrays.toString(s.toArray()));
	}
}