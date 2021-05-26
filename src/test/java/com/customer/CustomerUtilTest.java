package com.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The Class CustomerUtilTest.
 *  @author shiva prasad
 * 
 */
public class CustomerUtilTest {
	
	/** The util. */
	private CustomerUtil util;
	
	/**
	 * Before.
	 */
	@BeforeEach
	public void before() {
		util = new CustomerUtil(); 
	}

	/**
	 * Prepare data empty test.
	 */
	@Test
	public void prepareDataEmptyTest() {
		assertEquals(0,util.prepareCustomerData(Optional.empty()).size());
	}
	
	/**
	 * Prepare data test.
	 */
	@Test
	public void prepareDataTest() {
		Optional<String> rawData = Optional.of("2343225,2345,us_east,RedTeam,ProjectApple,3445s\n" +
				"1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n");
		assertEquals(2,util.prepareCustomerData(rawData).size());
	}
	
	/**
	 * Calculate uniq customers by contractor test.
	 */
	@Test
	public void calculateUniqCustomersByContractorTest() {
		Optional<String> rawData = Optional.of("2343225,2345,us_east,RedTeam,ProjectApple,3445s\n" + 
				"1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n" + 
				"3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n" + 
				"1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n" +
				"1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n" +
				"3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s");
		List<Customer> customers = util.prepareCustomerData(rawData);
		Map<Long, List<Customer>> contractMap = util.formatCustomersByContractor(customers);
		Map<Long, Long> contractCountMap = util.calculateUniqCustomersByContractor(contractMap);
		assertEquals(3,contractCountMap.get(2345L));
	}
	
	/**
	 * Calculate uniq customers by zone test.
	 */
	@Test
	public void calculateUniqCustomersByZoneTest() {
		Optional<String> rawData = Optional.of("2343225,2345,us_east,RedTeam,ProjectApple,3445s\n" + 
				"1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n" + 
				"3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n" + 
				"1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n" +
				"1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n" +
				"3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s");
		List<Customer> customers = util.prepareCustomerData(rawData);
		Map<String, List<Customer>> zonemap = util.formatCustomersByZone(customers);
		Map<String, Long> zoneCountMap = util.calculateUniqCustomersByZone(zonemap);
		assertEquals(2,zoneCountMap.get("us_west"));
	}
	
	/**
	 * Prepare uniq customers by zone test.
	 */
	@Test
	public void prepareUniqCustomersByZoneTest() {
		Optional<String> rawData = Optional.of("2343225,2345,us_east,RedTeam,ProjectApple,3445s\n" + 
				"1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n" + 
				"3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n" + 
				"1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n" +
				"1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n" +
				"3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s");
		List<Customer> customers = util.prepareCustomerData(rawData);
		Map<String, List<Customer>> zonemap = util.formatCustomersByZone(customers);
		Map<String, long[]> zoneCountMap = util.prepareUniqCustomersByZone(zonemap);
		assertEquals(2,zoneCountMap.get("us_west").length);
	}
	
	/**
	 * Calculate avg build time by zone test.
	 */
	@Test
	public void calculateAvgBuildTimeByZoneTest() {
		Optional<String> rawData = Optional.of("2343225,2345,us_east,RedTeam,ProjectApple,3445s\n" + 
				"1223456,2345,us_west,BlueTeam,ProjectBanana,2211s");
		List<Customer> customers = util.prepareCustomerData(rawData);
		Map<String, List<Customer>> zonemap = util.formatCustomersByZone(customers);
		Map<String, Double> zoneCountMap = util.calculateAvgBuildTimeByZone(zonemap);
		assertEquals(2211,zoneCountMap.get("us_west"));
	}
}
