// ------------------------------------------------------------
//                Name.java
// ------------------------------------------------------------

public class Name implements Comparable
{
	private String first;  // first name
	private String last;   // last name
	
	public static final int LESS_THAN = -1;
	public static final int EQUALS = 0;
	public static final int GREATER_THAN = 1;

	public Name()
	{
		this ( "", "" );
	}

	public Name(String firstName, String lastName)
	{
		first = firstName;
		last  = lastName;
	}

	public void setName(String firstName, String lastName)
	{
		first = firstName;
		last  = lastName;
	}

	public Name(Name obj) throws NullPointerException {	// Copy Constructor
		if(obj == null) throw new NullPointerException();
		
		first = obj.first;
		last = obj.last;
		
		System.out.println("Name - copy constructor");
	}  

	public void   setFirst(String firstName) { first = firstName;  }
	public void   setLast (String lastName ) { last = lastName;    }
	public String getFirst()                 { return first;	   }
	public String getLast ()	             { return last;   	   }
	public String getName ()                 { return toString();  }
	public void   giveLastNameTo ( Name aName )
	{
		aName.setLast ( last );
	}

	public boolean equals ( Object obj ) {	// Equals method
		if(this == obj) return true;
		
		if((obj != null) && (getClass() == obj.getClass())) {
			Name n = (Name) obj;
			
			if(first.equals(n.first) && last.equals(n.last))
				return true;
			else
				return false;
		}
		else
			return false;
	}			   

	public String toString( )
	{
		return first + " " + last;
	}

	public void finalize ( ) {  System.out.println("Name - finalize method"); }	// finalize method

	public void dispose ( )  { System.out.println("Name - dispose method"); }	// dispose method

	public int hashCode ( )  {
		int result = 17;
		
		result = 37 * result + first.hashCode();
		result = 37 * result + last.hashCode();
		
		return result;
	}						   

	public int compareTo (Object obj) {	// compareTo Method
		int firstNames, lastNames;
		
		if(this == obj) return 0;
		if(obj == null) throw new NullPointerException();
		if(getClass() != obj.getClass()) throw new ClassCastException();
		
		Name n = (Name) obj;
		
		firstNames = first.compareTo(n.first);
		lastNames = last.compareTo(n.last);
		
		if(firstNames > 0) firstNames = 1;
		if(firstNames < 0) firstNames = -1;
		if(lastNames > 0) lastNames = 1;
		if(lastNames < 0) lastNames = -1;
		
		if(firstNames == lastNames) return firstNames;
		
		switch(lastNames) {
			case LESS_THAN:
				return LESS_THAN;
			case EQUALS:
				switch(firstNames) {
					case LESS_THAN:
						return LESS_THAN;
					case EQUALS:
						return EQUALS;
					case GREATER_THAN:
						return GREATER_THAN;
				}
			case GREATER_THAN:
				return GREATER_THAN;
			default:
				System.out.println("Shouldn't get here!");
				return 0;
			
		}
	}						   


} // end Name
