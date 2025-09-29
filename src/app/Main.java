package app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final double FACTOR1 = 1.8;
    private static final int FACTOR2 = 32;
    private static final String TITLE = "Choose the type of conversion: \n1) °F → °C \n2) °C → °F";

    public static void main(String[] args) {
        System.out.println("Temperature Conversion App: °F → °C and °C → °F");

        var option = selectConvertOptionMenu(TITLE);

        switch (option) {
            case 1 -> {
                var temperature = inputSelectedTemperature("Enter Fahrenheit temperature:");
                System.out.printf("%.1f°F is: %.1f°C", temperature, convertFahrenheitToCelsius(temperature));
            }
            case 2 -> {
                var temperature = inputSelectedTemperature("Enter Celsius temperature:");
                System.out.printf("%.1f°C is: %.1f°F", temperature, convertCelsiusToFahrenheit(temperature));
            }
        }
        SCANNER.close();
    }

    private static byte selectConvertOptionMenu(String title){
        byte type;
        do {
            System.out.println(title);
            try {
                type = SCANNER.nextByte();
            } catch (InputMismatchException e) {
                type = 0;
                SCANNER.nextLine();
            }
            if (type < 1 || type > 2) {
                System.out.println("Invalid input, please try again");
            }
        } while (type < 1 || type > 2);
        return type;
    }

    private static double inputSelectedTemperature(String title) {
        System.out.println(title);
        return SCANNER.nextDouble();
    }

    private static double convertFahrenheitToCelsius(double temperature) {
        return (temperature - FACTOR2) / FACTOR1;
    }

    private static double convertCelsiusToFahrenheit(double temperature) {
        return (temperature * FACTOR1) + FACTOR2;
    }

}
