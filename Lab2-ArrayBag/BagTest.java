import java.util.Arrays;

public class BagTest {
	public static void main(String[] args) {
		int items = 5;
		ArraySetBag<String> bag = new ArraySetBag<String>(items);
		
		// Test add method
		System.out.println("Adding Apple, Banana, and Orange...\n");
		bag.add("Apple");
		bag.add("Banana");
		bag.add("Orange");
		
		// Test add method with duplicates
		System.out.println("Adding Banana...");
		boolean addedItem = bag.add("Banana");
		if(addedItem)
			System.out.println("Item was successfully added!\n");
		else
			System.out.println("Unable to add item. No duplicates are allowed.\n");
		
		// Test toArray method
		System.out.println("The items in the bag are: " + Arrays.toString(bag.toArray()) + "\n");
		
		// Test getCurrentSize method
		int numItems = bag.getCurrentSize();
		System.out.println("The number of items in the bag is: " + numItems + "\n");
		
		// Test contains method
		boolean hasBananas = bag.contains("Banana");
		if(hasBananas)
			System.out.println("The bag contains a Banana!\n");
		else
			System.out.println("The bag does not contain a Banana!\n");
		
		// Test remove method (specified entry)
		System.out.println("Removing an Apple...");
		bag.remove("Apple");
		numItems = bag.getCurrentSize();
		System.out.println("The number of items in the bag is now: " + numItems + "\n");
		
		// Test remove method (last item is removed)
		System.out.println("Removing the last item that was added to the bag...");
		String item = bag.remove();
		System.out.println("The item that was removed is: " + item + "\n");
		
		// Test isEmpty method
		boolean bagIsEmpty = bag.isEmpty();
		if(bagIsEmpty)
			System.out.println("The bag is empty!\n");
		else
			System.out.println("The bag is not empty!\n");
		
		// Test clear method
		bag.add("Apple");
		bag.add("Banana");
		System.out.println("Current content of the bag: " + Arrays.toString(bag.toArray()));
		bag.clear();
		System.out.println("Bag after clearing: " + Arrays.toString(bag.toArray()));
	}
}