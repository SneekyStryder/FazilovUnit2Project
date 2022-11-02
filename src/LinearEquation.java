import java.math.BigDecimal;
import java.math.MathContext;

public class LinearEquation {
    /* Instance Variables */
    private int x1;
    private int y1;
    private int x2;
    private int y2;


    /* Creates a LinearEquation object */
/* PRECONDITION: x1 and x2 are NOT equal (client programs are responsible for ensuring
   this precondition is not violated) */
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }


/* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
   the nearest hundredth */
    public double distance() {
        return roundedToHundredth(Math.sqrt((Math.pow(x2 - x1, 2)) + (Math.pow(y2 - y1, 2))));
    }



    /* Calculates and returns the y-intercept of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double yIntercept() {
        return roundedToHundredth((y1 - slope() * x1));
    }



    /* Calculates and returns the slope of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double slope() {
        return roundedToHundredth(((double) (y2 - y1) / (double) (x2 - x1)));
    }



    /* Returns a String that represents the linear equation of the line through points
       (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5".

        When generating the m value (slope), here are examples of "printable" slopes:
           5, -5, 1/2, 6/8 (reducing not required), 8/5, -2/3, -18/7

        Here are non-examples of "printable" slopes:
     1/-2 (should be -1/2), -4/-3 (should be 4/3), 8/4 (should be reduced to 2),
           -12/3 (should be -4), 3/3 (should be 1), -6/6 (should be -1)

        HINT: Be sure to check if the line is horizontal and return an appropriate string,
        e.g. y = 6
        HINT: Absolute value might be helpful for ensuring proper placement of negative sign!


        When generating the b value, here are some examples of "printable" y-intercepts:
           + 1.0 	- 2.35	      + 12.5		- 8.0		+ 17.19

        Here are non-examples of "printable" y-intercepts:
           - -1.0 	+ -2.35	- -12.5	+ -8.0	     - -17.19	+ 0	- 0

        HINT: Absolute value might be helpful for printing negative y-intercepts as
               subtraction!
     */
    public String equation() {
        String slopeString = "";
        String interceptString = "";
        if (y1 == y2) {
            return "y = " + y1;
        }
        else {
            if (slope() == 1.0) {
                slopeString += "";
            }
            else if (slope() == -1.0) {
                slopeString += "-";
            }
            else if ((x2 - x1) < 0 && (y2 - y1) < 0) {
                if ((int) Math.abs(slope() * 10) % 10 == 0) {
                    slopeString += (int) Math.abs(slope());
                }
                else {
                    slopeString += Math.abs((y2 - y1)) + "/" + Math.abs((x2 - x1));
                }
            }
            else if ((x2 - x1) < 0 && (y2 - y1) > 0) {
                if ((int) Math.abs(slope() * 10) % 10 == 0) {
                    slopeString += "-" + (int) Math.abs(slope());
                }
                else {
                    slopeString += "-" + (y2 - y1) + "/" + Math.abs((x2 - x1));
                }
            }
            else {
                if ((int) Math.abs(slope() * 10) % 10 == 0) {
                    slopeString += (int) slope();
                }
                else {
                    slopeString += (y2 - y1) + "/" + (x2 - x1);
                }
            }
            if (yIntercept() == 0) {
                interceptString += "";
            }
            else if (yIntercept() < 0) {
                interceptString += "- " + Math.abs(yIntercept());
            }
            else {
                interceptString += "+ " + yIntercept();
            }
            return "y = " + slopeString + "x " + interceptString;

        }
    }





    /* Returns a String of the coordinate point on the line that has the given x value, with
       both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
    public String coordinateForX(double xValue) {
        double y = slope() * xValue + yIntercept();
        return "(" + xValue + ", " + y + ")";
    }





    /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
        to the nearest hundredth

        HINT:  the Math.round method can help with this!
     */
    public double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100.0) / 100.0;
    }



    /* Returns a string that includes all information about the linear equation, each on
       separate lines:
         - The original points: (x1, y1) and (x2, y2)
         - The equation of the line in y = mx + b format (using equation() method)
         - The slope of the line, as a decimal (using slope() method)
         - The y-intercept of the line (using yIntercept() method)
         - The distance between the two points (using distance() method)

      This method should call all other appropriate methods to get the info it needs:
      equation(), slope(), yIntercept(), distance().

      */
    public String lineInfo() {
        return  "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")" + "\n" +
                "The equation of the line between these points is: " + equation() + "\n" +
                "The slope of this line is: " + slope() + "\n" +
                "The y-intercept of the line is: " + yIntercept() + "\n" +
                "The distance between the two points is: " + distance();
    }

}
