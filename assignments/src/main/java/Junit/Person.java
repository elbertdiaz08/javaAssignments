package Junit;

public class Person {



	private String firstName;
	private String lastName;



	public Person(String firstName, String lastName) throws IllegalArgumentException
	{
		if(firstName==null||lastName==null)
		{
			throw new IllegalArgumentException();
		}else
		{
			this.firstName = firstName;
			this.lastName = lastName;
		}
	}
	public String getFullName()
	{
		String first=(this.firstName!=null)?this.firstName:"?";
		String last=(this.lastName!=null)?this.lastName:"?";
		return first+" "+last;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}

}
