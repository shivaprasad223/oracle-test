package com.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerUtilTest {
	
	private CustomerUtil util;
	
	@BeforeEach
	public void before() {
		util = new CustomerUtil();
	}

	@Test
	public void prepareDataEmptyTest() {
		assertEquals(0,util.prepareCustomerData("").size());
	}
	
	@Test
	public void prepareDataTest() {
		String rawData = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\n" +
				"1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n";
		assertEquals(2,util.prepareCustomerData(rawData).size());
	}
	
	@Test
	public void calculateUniqCustomersByContractorTest() {
		String rawData = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\n" + 
				"1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n" + 
				"3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n" + 
				"1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n" +
				"1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n" +
				"3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s";
		List<Customer> customers = util.prepareCustomerData(rawData);
		Map<Long, List<Customer>> contractMap = util.formatCustomersByContractor(customers);
		Map<Long, Long> contractCountMap = util.calculateUniqCustomersByContractor(contractMap);
		assertEquals(3,contractCountMap.get(2345L));
	}
	
	@Test
	public void calculateUniqCustomersByZoneTest() {
		String rawData = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\n" + 
				"1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n" + 
				"3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n" + 
				"1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n" +
				"1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n" +
				"3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s";
		List<Customer> customers = util.prepareCustomerData(rawData);
		Map<String, List<Customer>> zonemap = util.formatCustomersByZone(customers);
		Map<String, Long> zoneCountMap = util.calculateUniqCustomersByZone(zonemap);
		assertEquals(2,zoneCountMap.get("us_west"));
	}
	
	@Test
	public void calculateAvgBuildTimeByZoneTest() {
		String rawData = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\n" + 
				"1223456,2345,us_west,BlueTeam,ProjectBanana,2211s";
		List<Customer> customers = util.prepareCustomerData(rawData);
		Map<String, List<Customer>> zonemap = util.formatCustomersByZone(customers);
		Map<String, Double> zoneCountMap = util.calculateAvgBuildTimeByZone(zonemap);
		assertEquals(2211,zoneCountMap.get("us_west"));
	}
}
