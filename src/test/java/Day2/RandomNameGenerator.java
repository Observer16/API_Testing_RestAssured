package Day2;

import java.util.Random;

public class RandomNameGenerator {
    private static final String[] NAMES = {"John", "Alice", "Michael", "Emily", "David"};
    private static final String[] SURNAMES = {"Smith", "Johnson", "Williams", "Brown", "Jones"};

    public static void main(String[] args) {
        Random random = new Random();

        String randomName = NAMES[random.nextInt(NAMES.length)];
        String randomSurname = SURNAMES[random.nextInt(SURNAMES.length)];

        System.out.println("Random Name: " + randomName);
        System.out.println("Random Surname: " + randomSurname);
    }
}
