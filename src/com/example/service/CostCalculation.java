package com.example.service;

import java.util.Map;

public interface CostCalculation {
	public double totalCost(Map<String, Integer> basket, Map<String, Double> price);

}
