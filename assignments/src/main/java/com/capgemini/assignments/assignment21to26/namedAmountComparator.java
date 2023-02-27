package com.capgemini.assignments.assignment21to26;

import java.util.Comparator;

public class namedAmountComparator implements Comparator<Customer>{

	@Override
	public int compare(Customer customer1, Customer customer2) {
		if(customer1.getAverageSpendAmount() <  customer2.getAverageSpendAmount()) return -1;
	    if(customer1.getAverageSpendAmount() == customer2.getAverageSpendAmount()) return 0;
	    return 1;
	}

}
