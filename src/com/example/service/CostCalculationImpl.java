package com.example.service;

import java.util.Map;
import java.util.Set;

public class CostCalculationImpl implements CostCalculation{
	
	/**
	 * Calculate the total price of items in basket
	 */
	@Override
	public double totalCost(Map<String, Integer> basket, Map<String, Double> price){
		double totalCost =0.0;
		if(basket != null && price != null){
			Set<String> set = basket.keySet();
			t
			for(String key: set){
				if(null != key){
					try{
						if(!(basket.get(key) <= 0) && null != (basket.get(key)) && null != price.get(key) && !(price.get(key) <=0)){
							totalCost = totalCost + basket.get(key)*price.get(key);
						}
					}
					catch(NullPointerException e){
						//e.printStackTrace();
					}
				}
			}
		}
		
		return totalCost;
	}

}
