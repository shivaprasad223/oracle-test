package com.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerUtil {

	public List<Customer> prepareCustomerData(String rawData) {
		List<Customer> customers = new ArrayList<>();
		if(null == rawData || rawData.length() == 0)
			return customers;
		try {
			String[] rows = rawData.split("\n");
			for (String row : rows) {
				String[] cols = row.split(",");
				Customer customer = new Customer(Long.parseLong(cols[0]), Long.parseLong(cols[1]), cols[2], cols[3],
						cols[4], Long.parseLong(cols[5].split("s")[0]));
				customers.add(customer);
			}
		} catch (IndexOutOfBoundsException iex) {
			throw new IndexOutOfBoundsException();
		} catch (NumberFormatException nfx) {
			throw new NumberFormatException();
		}
		return customers;
	}
	
	public Map<Long, List<Customer>> formatCustomersByContractor(List<Customer> customers){
		return customers.stream().collect(Collectors.groupingBy(customer -> customer.getContractId()));
	}
	
	public Map<Long,Long> calculateUniqCustomersByContractor(Map<Long, List<Customer>> contractMap){
		Map<Long, Long> contractCountMap = new HashMap<>();
		
		for(Long key:contractMap.keySet()) {
			contractCountMap.put(key,contractMap.get(key).stream().mapToLong(Customer::getCustomerId).distinct().count());
		}
		return contractCountMap;
	}
	
	public Map<String, List<Customer>> formatCustomersByZone(List<Customer> customers){
		return customers.stream().collect(Collectors.groupingBy(customer -> customer.getGeoZone()));
	}
	
	public Map<String,Long> calculateUniqCustomersByZone(Map<String, List<Customer>> zonemap){
		Map<String, Long> zoneCountMap = new HashMap<>();
		
		for(String key:zonemap.keySet()) {
			zoneCountMap.put(key,zonemap.get(key).stream().mapToLong(Customer::getCustomerId).distinct().count());
		}
		return zoneCountMap;
	}
	
	public Map<String, Double> calculateAvgBuildTimeByZone(Map<String, List<Customer>> zonemap){
		Map<String, Double> buildTimemap = new HashMap<>();
		
		for(String key:zonemap.keySet()) {
			buildTimemap.put(key,zonemap.get(key).stream().mapToLong(Customer::getBuildduration).average().getAsDouble());
		}
		return buildTimemap;
	}
}
