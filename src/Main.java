import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        calc(userInput.nextLine());
    }

    public static String calc(String input) {
        String[] space = input.split(" ");
        if (space.length > 3) {
            throw new RuntimeException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        if (space.length < 3) {
            throw new RuntimeException("Строка не является математической операцией");
        }

        try {

            String[] roman2 = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            String[] roman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII",
                    "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI",
                    "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
                    "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII",
                    "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

            int a = 0;
            int b = 0;
            int result = 0;
            if (Arrays.asList(roman2).contains(space[0]) && Arrays.asList(roman2).contains(space[2])) {
                for (int i = 1; i < roman2.length; i++) {
                    if (roman2[i].equals(space[0])) {
                        a = i;
                    }
                    if (roman2[i].equals(space[2])) {
                        b = i;
                    }
                }

                switch (space[1]) {
                    case "+" -> result = a + b;
                    case "-" -> result = a - b;
                    case "*" -> result = a * b;
                    case "/" -> result = a / b;
                }
                if (result < 1) {
                    throw new RuntimeException("В римской системе нет отрицательных чисел");
                }
                for (int i = 0; i < roman.length; i++) {
                    if (result == i) {
                        System.out.println(roman[i]);
                    }
                }

            } else {
                String[] arabian = {"-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

                int c = Integer.parseInt(space[0]);
                int d = Integer.parseInt(space[2]);
                int result2 = 0;
                if (Arrays.asList(arabian).contains(space[0]) && Arrays.asList(arabian).contains(space[2])) {
                    if ((c >= 1 && c <= 10) && (d >= 1 && d <= 10)) {

                    }

                    switch (space[1]) {
                        case "+" -> result2 = c + d;
                        case "-" -> result2 = c - d;
                        case "*" -> result2 = c * d;
                        case "/" -> result2 = c / d;
                    }
                    System.out.println(result2);
                }
                }
            } catch(NumberFormatException e){
                System.out.println("Используются одновременно разные системы счисления");
            }
            return input;
        }
    }