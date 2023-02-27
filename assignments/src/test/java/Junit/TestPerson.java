package Junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPerson {



	@Test
	public void testGetFullName()
	{
		System.out.println("From TestPerson");
		Person per=new Person("Robert","King");
		assertEquals("Robert King", per.getFullName());
	}

	@Test
	public void NullisName()
	{
		System.out.println("From TestPerson");
		Person per=new Person("Robert","King");
		assertNotNull("full Name null",per.getFullName());
		assertNotNull("First Name null",per.getFirstName());
	}
	@Test
	public void getFirstName()
	{
		Person per=new Person("Robert","King");
		assertEquals(per.getFirstName(), "Robert");
	}
	@Test
	public void getLastName()
	{
		Person per=new Person("Robert","King");
		assertEquals(per.getLastName(), "King");
	}
	@Test
	(expected =IllegalArgumentException.class)
	public void testNullInName()
	{
		System.out.println("From testPerson");
		Person p=new Person(null,null);
		assertNull(null, p.getFirstName());
		assertNull(null, p.getLastName());
	}
}
