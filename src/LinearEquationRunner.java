import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Welcome\nEnter coordinate 1: ");
        String cord1String = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        String cord2String = scan.nextLine();

        int cord1x = Integer.parseInt(cord1String.substring(1, cord1String.indexOf(",")));
        int cord1y = Integer.parseInt(cord1String.substring(cord1String.indexOf(" ") + 1, cord1String.indexOf(")")));
        int cord2x = Integer.parseInt(cord2String.substring(1, cord2String.indexOf(",")));
        int cord2y = Integer.parseInt(cord2String.substring(cord2String.indexOf(" ") + 1, cord2String.indexOf(")")));

        System.out.println(cord1x);
        System.out.println(cord1y);
        System.out.println(cord2x);
        System.out.println(cord2y);

    }
}
