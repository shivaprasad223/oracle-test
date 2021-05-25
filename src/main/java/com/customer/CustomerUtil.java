package com.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The Class CustomerUtil.
 *  @author shiva prasad
 */
public class CustomerUtil {

	/**
	 * Prepare customer data.
	 *
	 * @param rawData the raw data
	 * @return the list
	 */
	public List<Customer> prepareCustomerData(Optional<String> rawData) {
		List<Customer> customers = new ArrayList<>();
		if (rawData.isPresent()) { 
			try {
				String[] rows = rawData.get().split("\n");
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
		}
		return customers;
	}

	/**
	 * Format customers by contractor.
	 *
	 * @param customers the customers
	 * @return the map
	 */
	public Map<Long, List<Customer>> formatCustomersByContractor(List<Customer> customers) {
		return customers.stream().collect(Collectors.groupingBy(customer -> customer.getContractId())); 
	}

	/**
	 * Calculate uniq customers by contractor.
	 *
	 * @param contractMap the contract map
	 * @return the map
	 */
	public Map<Long, Long> calculateUniqCustomersByContractor(Map<Long, List<Customer>> contractMap) {
		Map<Long, Long> contractCountMap = new HashMap<>();

		for (Long key : contractMap.keySet()) {
			contractCountMap.put(key,
					contractMap.get(key).stream().mapToLong(Customer::getCustomerId).distinct().count());
		}
		return contractCountMap;
	}

	/**
	 * Format customers by zone.
	 *
	 * @param customers the customers
	 * @return the map
	 */
	public Map<String, List<Customer>> formatCustomersByZone(List<Customer> customers) {
		return customers.stream().collect(Collectors.groupingBy(customer -> customer.getGeoZone()));
	}

	/**
	 * Calculate uniq customers by zone.
	 *
	 * @param zonemap the zonemap
	 * @return the map
	 */
	public Map<String, Long> calculateUniqCustomersByZone(Map<String, List<Customer>> zonemap) {
		Map<String, Long> zoneCountMap = new HashMap<>();

		for (String key : zonemap.keySet()) {
			zoneCountMap.put(key, zonemap.get(key).stream().mapToLong(Customer::getCustomerId).distinct().count());
		}
		return zoneCountMap;
	}

	/**
	 * Calculate avg build time by zone.
	 *
	 * @param zonemap the zonemap
	 * @return the map
	 */
	public Map<String, Double> calculateAvgBuildTimeByZone(Map<String, List<Customer>> zonemap) {
		Map<String, Double> buildTimemap = new HashMap<>();

		for (String key : zonemap.keySet()) {
			buildTimemap.put(key,
					zonemap.get(key).stream().mapToLong(Customer::getBuildduration).average().getAsDouble());
		}
		return buildTimemap;
	}
}
