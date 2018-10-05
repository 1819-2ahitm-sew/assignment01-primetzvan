import java.util.Scanner;

public class Taschenrechner {

    public static void main(String[] args) {

        String inputall;
        Scanner sc = new Scanner(System.in);
        double number1, number2, result = 0;
        char[] operatorarr;
        char operator;

        boolean loop;
        String[] inputarr;
        String[] allcalculations = new String[50];
        int count = 0;
        int i = 0;

        System.out.print("Eingabe: ");
        inputall = sc.nextLine();

        while (!inputall.equalsIgnoreCase("quite")) {

            if (inputall.equals("p") || inputall.equals("n")) {
                if (inputall.equals("p")) {
                    i -= 1;
                    if (i >= 0) {
                        System.out.printf("%d. Rechnug: %s \n", i + 1, allcalculations[i]);
                    } else {
                        System.out.println(" Anfang ");
                    }
                } else if (inputall.equals("n")) {
                    i += 1;
                    if (i <= count) {
                        System.out.printf("%d. Rechnug: %s \n", i + 1, allcalculations[i]);
                    } else {
                        System.out.println(" Ende ");
                    }
                }
            } else {

                loop = false;

                inputarr = inputall.split(" ");
                number1 = Double.parseDouble(inputarr[0]);
                operatorarr = inputarr[1].toCharArray();
                operator = operatorarr[0];
                number2 = Double.parseDouble(inputarr[2]);

                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    if (operator == '+') {
                        result = number1 + number2;
                    } else if (operator == '-') {
                        result = number1 - number2;
                    } else if (operator == '*') {
                        result = number1 * number2;
                    } else if (operator == '/') {
                        if (number2 != 0) {
                            result = number1 / number2;
                        } else {
                            loop = true;
                        }
                    }


                    if (!loop) {
                        System.out.printf("Ausgabe: %.2f %c %.2f = %.2f \n", number1, operator, number2, result);
                        allcalculations[count] = inputall + " = " + Double.toString(result);
                    } else {
                        System.out.println("Keine Division durch 0 möglich!");
                        count--;
                    }


                } else {
                    System.out.println("Falsche Eingabe! Vewenden sie einen dieser Operatoren: +, - , *, /.");
                    count--;
                }


            }

            System.out.print("Eingabe: ");
            inputall = sc.nextLine();

            if (!inputall.equals("p") && !inputall.equals("n")) {
                count++;
                i = count;
            }

        }

        System.out.printf("Es gab %d Berechnungen \n", count);

        for (int j = 0; j < count; j++) {
            System.out.printf("%d. Rechnug: %s \n", j + 1, allcalculations[j]);
        }


    }
}
