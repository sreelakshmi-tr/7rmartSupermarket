package utilities;

import com.github.javafaker.Faker;

public class RandomInputUtility {
	

	public String randomPhoneNumberGenerator() {
		Faker faker= new Faker();
		return faker.phoneNumber().cellPhone();
		
	}
	
	public String randomPasswordGenerator() {
		Faker faker= new Faker();
		return faker.code().asin();
		
	}
	
	public String randomLastNameGenerator() {
		Faker faker= new Faker();
		return faker.name().firstName();
		
	}
	
	public String randomFirstNameGenerator() {
		Faker faker= new Faker();
		return faker.name().firstName();
		
	}
	
	public String randomFullNameGenerator() {
		Faker faker= new Faker();
		return faker.name().fullName();
		
	}
	
	public String randomStreetAddressGenerator() {
		Faker faker= new Faker();
		return faker.address().streetAddress();
		
	}
	
	public String randomCityNameGenerator() {
		Faker faker= new Faker();
		return faker.address().cityName();
		
	}
	
	
	public String randomEmailGenerator() {
		Faker faker= new Faker();
		return faker.internet().emailAddress();
		
	}
	
	public String randomCountryGenerator() {
		Faker faker= new Faker();
		return faker.address().country();
		
	}
	
	
}
