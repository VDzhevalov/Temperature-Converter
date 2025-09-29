package app;

import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Temperature Conversion App: °F → °C and °C → °F");

        var temperature = inputSelectedTemperature("Enter Fahrenheit temperature:");

        System.out.printf("%.2f °F is: %.2f °C", temperature, convertFahrenheitToCelsius(temperature));
    }

    private static double inputSelectedTemperature(String title) {
        System.out.println(title);
        return SCANNER.nextDouble();
    }

    private static double convertFahrenheitToCelsius(double temperature) {
        return (temperature - 32) / 1.8;
    }

}
