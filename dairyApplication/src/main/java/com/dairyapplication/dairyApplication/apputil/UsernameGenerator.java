package com.dairyapplication.dairyApplication.apputil;

import java.util.Random;

public class UsernameGenerator {

    public static String generateUsername(String name) {
        Random random = new Random();
        int randomNumber = 1000 + random.nextInt(9000); // Generate a 4-digit random number
        String baseName = name.replaceAll("\\s+", "").toLowerCase(); // Remove spaces and make lowercase

        return baseName + randomNumber;
    }
}
