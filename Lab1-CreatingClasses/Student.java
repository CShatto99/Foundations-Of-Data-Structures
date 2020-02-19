// ----------------------------------------------------------
//                    Student.java
// ----------------------------------------------------------

public class Student implements Comparable
{
	private Name fullName;
	private String id;
	
	public static final int LESS_THAN = -1;
	public static final int EQUALS = 0;
	public static final int GREATER_THAN = 1;

	public Student()
	{
		this ( new Name ( ), "" );
	}

	public Student(Name studentName, String studentId)
	{
		fullName = studentName;
		id = studentId;
	}

	public Student(Student obj) throws NullPointerException	{	// Copy Constructor
		if(obj == null) throw new NullPointerException();
		
		fullName = obj.fullName;
		id = obj.id;
		
		System.out.println("Student - copy constructor");
	}

	public Object clone() {
		return new Student (this);
	}

	public void setStudent(Name studentName, String studentId)
	{
		fullName = studentName;
		id       = studentId;
	}

	public void   setName(Name studentName) {	fullName = studentName;	}
	public Name   getName()                 {   return fullName;        }
	public void   setId(String studentId)   {	id = studentId;         }
	public String getId()                   {	return id;              }


	public String toString()
	{
		return id + " " + fullName.toString ( );
	}

	public boolean equals ( Object obj ) {
		if(this == obj) return true;
		
		if((obj != null) && (getClass() == obj.getClass())) {
			Student s = (Student) obj;
			
			if(fullName.equals(s.fullName) && id.equals(s.id) )
				return true;
			else
				return false;
		}
		else
			return false;
	}

	public void finalize() { System.out.println("Student - finalize method"); }

	public void dispose() { System.out.println("Student = dispose method"); }

	public int hashCode() {
		int result = 17;
		
		result = 37 * result + fullName.getFirst().hashCode();
		result = 37 * result + fullName.getLast().hashCode();
		result = 37 * result + id.hashCode();
		
		return result;
	}

	public int compareTo (Object obj) {
		int fullNames, ids;
		
		if(this == obj) return 0;
		if(obj == null) throw new NullPointerException();
		if(getClass() != obj.getClass()) throw new ClassCastException();
		
		Student s = (Student) obj;
		
		fullNames = fullName.compareTo(s);
		ids = id.compareTo(s.id);
		
		if(fullNames > 0) fullNames = 1;
		if(fullNames < 0) fullNames = -1;
		if(ids > 0) ids = 1;
		if(ids < 0) ids = -1;
		
		switch(fullNames) {
			case LESS_THAN:
				return LESS_THAN;
			case EQUALS: {
				switch(ids) {
					case LESS_THAN:
						return LESS_THAN;
					case EQUALS:
						return EQUALS;
					case GREATER_THAN:
						return GREATER_THAN;
				}
			}
			case GREATER_THAN:
				return GREATER_THAN;
			default:
				System.out.println("Shouldn't get here!");
				return 0;
		}
		
	}

}  // end Student
