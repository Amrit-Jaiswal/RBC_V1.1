package com.example.testcase;

import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;
import org.junit.Test;
import com.example.service.CostCalculationImpl;

public class CostCalculationTestCase extends TestCase {
	
	private Map<String, Integer> basket = null;
	private Map<String, Double> priceMap = null;
	private String key = null;
	private Double value=0.0;
	private Double testPrice=0.0;
	private int i=0;
	
	protected void setUp(){
		basket = new HashMap<String, Integer>();
		priceMap = new HashMap<String, Double>();
		//Filling of basket
		basket.put("Bananas", 1);
		basket.put("Oranges", 1);
		basket.put("Apples", 1);
		basket.put("Lemons", null);
		basket.put(null, 1);
		basket.put(null, 1);
		
		//Setting price
		for(Map.Entry<String,Integer> entry : basket.entrySet()){
			key = entry.getKey();
			try{
				if(null != key){
					value = (double) (++i*10);
					priceMap.put(key, value);
				}
				else{
					value = 0.0;
				}
			}
			catch(Exception e){
				System.err.println("Not a valid price");
			}
			
			if(value > 0 && null != value && null != entry.getValue()){
				testPrice=testPrice + value*entry.getValue();
			}
		}

	}
	
	
	//1. Null value testing
	@Test
	public void testNullValues(){
		assertEquals(0.0,(new CostCalculationImpl()).totalCost(null,null));
	}
	
	//2. Empty value testing
	@Test
	public void testEmptyValues(){
		assertEquals(0.0,(new CostCalculationImpl()).totalCost(new HashMap<String, Integer>(),new HashMap<String, Double>()));
	}
	
	//3. Valid values testing
	@Test
	public void testTotalCost(){
		assertEquals(testPrice,(new CostCalculationImpl()).totalCost(basket,priceMap));
	}
	
	//4. Only price is Null
	@Test
	public void testPriceNull(){
		assertEquals(0.0,(new CostCalculationImpl()).totalCost(basket,null));
	}
	
	//5. Only Basket is null
	@Test
	public void testBasketNull(){
		assertEquals(0.0,(new CostCalculationImpl()).totalCost(null,priceMap));
	}
	
}
