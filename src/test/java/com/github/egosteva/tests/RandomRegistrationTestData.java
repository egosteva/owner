package com.github.egosteva.tests;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class RandomRegistrationTestData {
    public static Faker faker = new Faker(new Locale("en"));
    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            subject = faker.options().option("Maths", "Computer Science", "History", "English", "Arts", "Biology", "Hindi"),
            hobby = faker.options().option("Sports", "Reading", "Music"),
            imageName = "profile.png",
            currentAddress = faker.address().fullAddress();

    static String phoneNumberWithSymbols = new Faker(new Locale("ru")).phoneNumber().phoneNumber();
    public static String phone = phoneNumberWithSymbols.replaceAll("[^\\d]", "").substring(1);

    static Date randomDateOfBirth = new Faker().date().birthday();
    public static String dayOfBirth = new SimpleDateFormat("d").format(randomDateOfBirth),
            monthOfBirth = new SimpleDateFormat("MMMM", Locale.ENGLISH).format(randomDateOfBirth),
            yearOfBirth = new SimpleDateFormat("yyyy").format(randomDateOfBirth);

    static Map<String, String[]> mapStateAndCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    public static String state = faker.options().option(mapStateAndCity.keySet().toArray()).toString(),
            city = faker.options().option(mapStateAndCity.get(state));
}
