package com.example.testcase;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import junit.framework.TestCase;

import org.junit.Test;

import com.example.service.CostCalculationImpl;

public class CostCalculationTestCase extends TestCase {
	
	private Map<String, Integer> basket = null;
	private Map<String, Double> priceMap = null;
	Scanner sc = new Scanner(System.in);
	String key = null;
	Double value=0.0;
	Double testPrice=0.0;
	
	
	protected void setUp(){
		basket = new HashMap<String, Integer>();
		priceMap = new HashMap<String, Double>();
		//Filling of basket
		basket.put("Bananas", 1);
		basket.put("Oranges", 1);
		basket.put("Apples", 1);
		basket.put("Lemons", 1);
		basket.put("Peaches", 1);
		
		//Setting price
		for(Map.Entry<String,Integer> entry : basket.entrySet()){
			String key = entry.getKey();
			System.out.println("Enter price of "+key);
			try{
				value = sc.nextDouble();
				//value = Long.parseLong(input);
				if(value < 0 && value != null){
					value=0.0;
					System.out.println("-ve values will be consider as 0");
				}
				priceMap.put(key, value);
			}
			catch(Exception e){
				System.err.println("Not a valid price");
			}
			
			if(value > 0 && value != null){
				testPrice=testPrice + value*entry.getValue();
			}
		}
		System.out.println("Basket values :"+basket);
		System.out.println("Price values :"+priceMap);
		System.out.println("Initialization done\n**************\n\n\nTest Results\n");
	}
	
	
	@Test
	public void testTotalCost(){
		
		//1. Null value testing
		assertEquals(0.0,(new CostCalculationImpl()).totalCost(null,null));
		System.out.println("Testing of null values done");
		System.out.println("--------");
		
		//2. Empty value testing
		assertEquals(0.0,(new CostCalculationImpl()).totalCost(new HashMap<String, Integer>(),new HashMap<String, Double>()));
		System.out.println("Testing of empty values done");
		System.out.println("Total Price: "+(new CostCalculationImpl()).totalCost(new HashMap<String, Integer>(),new HashMap<String, Double>()));
		System.out.println("--------");
		
		//3. valid values testing
		assertEquals(testPrice,(new CostCalculationImpl()).totalCost(basket,priceMap));
		System.out.println("Testing of valid values done");
		System.out.println("Actual Total Price: "+(new CostCalculationImpl()).totalCost(basket,priceMap));
		System.out.println("--------");
		
		
	}
	
}
