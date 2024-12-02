import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Bonus {

    public static void main(String[] args) {
        HashSet<Integer> secretNumber = randomNumberGenerator();
        String stringNumber = setToStringConverter(secretNumber);
        System.out.println(stringNumber);
        feedback(stringNumber);

    }

    public static HashSet<Integer> randomNumberGenerator(){
        Random random = new Random();
        HashSet<Integer> numbers = new HashSet<>();

        while (numbers.size() < 4) {
            numbers.add(random.nextInt(10));
        }

        return numbers;
    }

    public static String setToStringConverter(HashSet<Integer> secretNumber){
        StringBuilder convertedNumber = new StringBuilder();

        for (Integer number : secretNumber) {
            convertedNumber.append(number);
        }

        return convertedNumber.toString();
    }



    public static void feedback(String secretNumber) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder feedback = new StringBuilder();
        System.out.println("+ = juiste nummer op de juiste plek, O = juiste nummer verkeerde plek, X = verkeerde nummer");
        System.out.println("Doe een gok, Let op vul 4 getallen in.");
        String guess = scanner.nextLine();
        if (Objects.equals(guess, secretNumber)) {
            System.out.println("gefeliciteerd je hebt het goed");
        } else {
            for (int i = 0; i < 4; i++) {
                if (guess.substring(i, i + 1).equals(secretNumber.substring(i, i + 1))) {
                    feedback.append("+");
                } else if (secretNumber.contains(guess.substring(i, i + 1))) {
                    feedback.append("0");
                } else {
                    feedback.append("X");
                }
            }
        }
        System.out.println(feedback.toString());
    }
}
