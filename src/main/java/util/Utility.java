package util;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Utility {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int NAME_LENGTH = 10;
    private static final String SAUDI_MOBILE_PREFIXES[] = {"050", "053", "054", "055", "056", "057", "058", "059"};
    private static final int PHONE_NUMBER_LENGTH = 9;
    private static final String CHARACTERS1 = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final String[] DOMAINS = {"gmail.com", "yahoo.com", "outlook.com"}; //added more domains
    private static final int MAX_USERNAME_LENGTH = 15;
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+={}[]|;:'\",.<>/?";
    private static final String[] STREET_NAMES = {"Main", "Oak", "Pine", "Maple", "Cedar", "Park", "Hill", "Lake", "River", "Sunset"};
    private static final String[] STREET_TYPES = {"St", "Ave", "Blvd", "Dr", "Ct", "Ln", "Rd", "Pl", "Way", "Terrace"};
    private static final String[] CITIES = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose"};
    private static final String[] STATES = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
    private static final String[] ZIP_CODES_PREFIXES = {"90", "10", "60", "77", "85", "19", "78", "92", "75", "95"}; // Just some sample prefixes


    private static final SecureRandom random = new SecureRandom();// Excluding the prefix

    //generate Random name
    public static String generateRandomName(int n) {
        if (n <= 0 || n > NAME_LENGTH) {
            throw new IllegalArgumentException("n must be between 1 and " + NAME_LENGTH);
        }

        Random random = new Random();
        StringBuilder sb = new StringBuilder(NAME_LENGTH);

        // Generate the first 'n' random letters
        for (int i = 0; i < n; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }

        // Fill the rest with random letters as well (instead of digits)
        for (int i = n; i < NAME_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }

        return sb.toString();
    }

    // generate Random Saudi Number
    public static String generateRandomSaudiNumber() {
        Random random = new Random();

        // Choose a random prefix
        String prefix = SAUDI_MOBILE_PREFIXES[random.nextInt(SAUDI_MOBILE_PREFIXES.length)];

        // Generate the remaining 9 digits
        StringBuilder sb = new StringBuilder(PHONE_NUMBER_LENGTH);
        for (int i = 0; i < PHONE_NUMBER_LENGTH; i++) {
            sb.append(random.nextInt(10)); // Append a random digit (0-9)
        }

        return prefix + sb.toString();
    }

    public static String generateRandomSaudiNumberWithCountryCode() {
        return "+966" + generateRandomSaudiNumber().substring(1); //remove the leading zero after adding country code
    }

    // genetate random Email
    public static String generateRandomEmail() {
        Random random = new Random();

        // Generate random username
        int usernameLength = random.nextInt(MAX_USERNAME_LENGTH) + 5; // Username length between 5 and 19 (inclusive)
        StringBuilder username = new StringBuilder(usernameLength);
        for (int i = 0; i < usernameLength; i++) {
            username.append(CHARACTERS1.charAt(random.nextInt(CHARACTERS1.length())));
        }
        String domain = DOMAINS[random.nextInt(DOMAINS.length)];

        return username.toString() + "@" + domain;
    }


    public static String generateComplexPassword(int length) {
        if (length < 8) {
            throw new IllegalArgumentException("Password length must be at least 8 characters.");
        }

        // Ensure at least one character from each set
        StringBuilder password = new StringBuilder();
        password.append(getRandomCharacter(LOWERCASE));
        password.append(getRandomCharacter(UPPERCASE));
        password.append(getRandomCharacter(NUMBERS));
        password.append(getRandomCharacter(SPECIAL_CHARACTERS));

        // Fill the rest with random characters from all sets
        String allCharacters = LOWERCASE + UPPERCASE + NUMBERS + SPECIAL_CHARACTERS;
        for (int i = password.length(); i < length; i++) {
            password.append(getRandomCharacter(allCharacters));
        }

        // Shuffle the password to further randomize the character positions
        List<Character> passwordList = password.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Collections.shuffle(passwordList, random);

        return passwordList.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    private static char getRandomCharacter(String characterSet) {
        return characterSet.charAt(random.nextInt(characterSet.length()));
    }

//    public static int generateRandomNumberBetween1And3() {
//        // nextInt(3) generates numbers from 0 to 2 (inclusive).
//        // Adding 1 shifts the range to 1 to 3 (inclusive).
//        return random.nextInt(3) + 1;
//    }

    //generate dynamic
    public static int generateRandomNumber(int max) {
        Random rand = new Random();
        return rand.nextInt(max) + 1; // Generate a random number between 1 and 8 (inclusive)
    }
//    public static int generateRandomNumberBetween1And8() {
//        // nextInt(3) generates numbers from 0 to 2 (inclusive).
//        // Adding 1 shifts the range to 1 to 3 (inclusive).
//        return random.nextInt(8) + 1;
//    }

//    public static int generateRandomNumberBetween1And2() {
//        // nextInt(3) generates numbers from 0 to 2 (inclusive).
//        // Adding 1 shifts the range to 1 to 3 (inclusive).
//        return random.nextInt(2) + 1;
//    }

//    public static int generateRandomNumberBetween1And5() {
//        // nextInt(3) generates numbers from 0 to 2 (inclusive).
//        // Adding 1 shifts the range to 1 to 3 (inclusive).
//        return random.nextInt(5) + 1;
//    }


    public static String generateRandomAddress() {
        int streetNumber = random.nextInt(1000) + 1; // 1-1000
        String streetName = STREET_NAMES[random.nextInt(STREET_NAMES.length)];
        String streetType = STREET_TYPES[random.nextInt(STREET_TYPES.length)];
        String city = CITIES[random.nextInt(CITIES.length)];
        String state = STATES[random.nextInt(STATES.length)];
        String zipCode = ZIP_CODES_PREFIXES[random.nextInt(ZIP_CODES_PREFIXES.length)] + String.format("%03d", random.nextInt(1000));

        return streetNumber + " " + streetName + " " + streetType + ", " + city + ", " + state + " " + zipCode;
    }

    public static String getRandomZipCodePrefix() {
        Random random = new Random();
        int index = random.nextInt(ZIP_CODES_PREFIXES.length);  // Random index in the array
        return ZIP_CODES_PREFIXES[index];  // Return the random ZIP code prefix
    }

}






