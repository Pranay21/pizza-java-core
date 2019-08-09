package com.example.pizzaStore.util;

import java.util.Comparator;

import com.example.pizzaStore.modal.PizzaOrders;

public class SortByDate implements Comparator<PizzaOrders> {
	
	@Override
	public int compare(PizzaOrders o1, PizzaOrders o2){
			
		if(o1.getDate() != o2.getDate()){
			return (int) (o1.getDate().compareTo(o2.getDate()));
		}
		return o1.getItem().compareTo(o2.getItem());
	}

}
