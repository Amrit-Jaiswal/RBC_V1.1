package com.example.service;

import java.util.Map;
import java.util.Set;

public class CostCalculationImpl implements CostCalculation{
	
	private double totalCost =0.0;
	
	/**
	 * Calculate the total price of items in basket
	 */
	@Override
	public double totalCost(Map<String, Integer> basket, Map<String, Double> price){
		
		if(basket != null){
			Set<String> set = basket.keySet();
			
			for(String key: set){
				if(null != key){
					if(!(basket.get(key) <= 0) && price.get(key) != null && !(price.get(key) <=0)){
						totalCost = totalCost + basket.get(key)*price.get(key);
					}
				}
			}
		}
		else{
			System.out.println("Basket is null");
		}
		return totalCost;
	}

}
