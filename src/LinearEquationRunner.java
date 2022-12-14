import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // User enters coordinates
        System.out.print("Welcome\nEnter coordinate 1: ");
        String cord1String = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        String cord2String = scan.nextLine();

        // Integer values of coordinates are extracted
        int cord1x = Integer.parseInt(cord1String.substring(1, cord1String.indexOf(",")));
        int cord1y = Integer.parseInt(cord1String.substring(cord1String.indexOf(" ") + 1, cord1String.indexOf(")")));
        int cord2x = Integer.parseInt(cord2String.substring(1, cord2String.indexOf(",")));
        int cord2y = Integer.parseInt(cord2String.substring(cord2String.indexOf(" ") + 1, cord2String.indexOf(")")));

        // Vertical line test
        if (cord1x == cord2x) {
            System.out.println("\nThese coordinates result in a vertical line: x = " + cord1x);
            System.exit(0);
        }

        // Main print statements
        else {
            LinearEquation equation = new LinearEquation(cord1x, cord1y, cord2x, cord2y);
            System.out.println();
            System.out.println(equation.lineInfo());
            System.out.println();
            System.out.print("Enter a value for x: ");
            double userX = scan.nextDouble();
            System.out.println();
            System.out.println("The point on the line is " + equation.coordinateForX(userX));

        }
    }
}
