import java.util.Arrays;

public class Driver {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>(5);
		
		// Test isEmpty() method
		System.out.println("Is the stack empty? " + s.isEmpty() + "\n");
		
		// Test push() method
		System.out.println("Adding 5 items...");
		s.push(3);
		s.push(6);
		s.push(9);
		s.push(12);
		s.push(15);
		System.out.println("Stack contents (top -> bottom):" + Arrays.toString(s.toArray()) + "\n");
		
		// Test ensureCapacity() method (dynamic sizing)
		System.out.println("Adding 3 items...");
		s.push(18);
		s.push(21);
		s.push(24);
		System.out.println("Stack contents after resizing (top -> bottom):" + Arrays.toString(s.toArray()) + "\n");
		
		// Test peek() method
		System.out.println("Top of the stack: " + s.peek() + "\n");
		
		// Test pop() method
		int n = 3;
		System.out.println("Removing " + n + " items from the stack...");
		for(int i = 0; i < 3; i++)
			System.out.println("Popped: " + s.pop());
		System.out.println("Stack contents after popping (top -> bottom):" + Arrays.toString(s.toArray()) + "\n");
		
		// Test clear() method
		s.clear();
		System.out.println("Stack contents after clearing (top -> bottom):" + Arrays.toString(s.toArray()) + "\n");
	}
}
