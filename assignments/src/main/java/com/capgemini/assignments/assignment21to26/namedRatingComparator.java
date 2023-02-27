package com.capgemini.assignments.assignment21to26;

import java.util.Comparator;

public class namedRatingComparator implements Comparator<Customer>{

	@Override
	public int compare(Customer customer1, Customer customer2) {
		if(customer1.getRating() <  customer2.getRating()) return -1;
	    if(customer1.getRating() == customer2.getRating()) return 0;
	    return 1;
	}

}
