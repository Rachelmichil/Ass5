import java.util.Scanner;

public class MetricConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to metric converter!");
        System.out.println("Please input your query. For example, 1 km = mile.");
        System.out.println("Enter 'exit' or '-1' to exit the program");

        while (true) {
            System.out.print("Enter your query: ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("exit") || userInput.equals("-1")) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            String result = convert(userInput);
            System.out.println(result);
        }

        scanner.close();
    }

    private static String convert(String query) {
        String[] parts = query.split("\\s+");

        if (parts.length != 4 || !parts[2].equals("=")) {
            return "Invalid input format. Please input in the format: 1 unit1 = unit2";
        }

        try {
            double value = Double.parseDouble(parts[0]);
            String fromUnit = parts[1].toLowerCase();
            String toUnit = parts[3].toLowerCase();

            if (fromUnit.equals(toUnit)) {
                return "Same units, no conversion needed.";
            }

            switch (fromUnit) {
                case "kg":
                    return performConversion(value, "kg", toUnit, value * 2.20462);
                case "gram":
                    return performConversion(value, "gram", toUnit, value * 0.03527396);
                case "km":
                    return performConversion(value, "km", toUnit, value * 0.621371);
                case "mm":
                    return performConversion(value, "mm", toUnit, value * 0.0393701);
                default:
                    return "Conversion not supported. Please check your units.";
            }
        } catch (NumberFormatException e) {
            return "Invalid numeric value. Please input a valid number.";
        }
    }

    private static String performConversion(double value, String fromUnit, String toUnit, double result) {
        return String.format("%.4f %s is equal to %.4f %s.", value, fromUnit, result, toUnit);
    }
}
