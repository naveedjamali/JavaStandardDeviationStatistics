import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Statistics {
    public static void main(String[] args) {
        /**
         * Declare variables as stated in PseudoCode file.
         */
        double sum = 0;
        double sumOfSquares = 0;
        int items = 0;

        /**
         * Read prices
         */
        double price = -1;

        do {
            /**
             * Print message for entering 1st and next prices.
             */
            if (items == 0) {
                System.out.print("Enter first price, or -1 to quit: $");
            } else {
                System.out.print("Enter next price, or -1 to quit: $");
            }

            /**
             * read prices.
             */
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            price = Double.parseDouble(s);
            /**
             * check price entry, if it is -1 then exit from loop
             */
            if (price != -1) {
                /**
                 * increment sum, sumOfSquares and items count.
                 */
                sum += price;
                sumOfSquares += (price * price);
                items++;
            }

        }
        while (price != -1);


        /**
         * Now figure out how many items we have and what to do with them.
         */

        if (items == 0) {
            /**
             * It there are items print message.
             */
            System.out.println("Number of items: 0\n" +
                    "No data entered, cannot calculate statistics");
        } else {

            /**
             * If there are more than one items
             */

            /**
             * To print average and standard deviation with exactly 2 digits after decimal.
             */
            DecimalFormat df = new DecimalFormat("#.00");
            df.setRoundingMode(RoundingMode.CEILING);

            /**
             * Print total items.
             */
            System.out.println("Number of items: " + items);

            /**
             * Print average price
             */
            double averagePrice = sum / items;
            System.out.println("Average Price is : $" + df.format(averagePrice));

            /**
             * Calculate and print standard deviation.
             */

            if (items > 1) {
                /**
                 * to simplify calculation, divide the equation in separate parts.
                 */

                double sumOfPricesSquared = sum * sum;

                /**
                 * calculate final result.
                 */
                double stDev = sqrt(((items * sumOfSquares) - sumOfPricesSquared) / (items * (items - 1)));

                System.out.println("Standard Deviation of prices is $" + df.format(stDev));

            } else {
                System.out.println("Cannot calculate standard deviation for one item");
            }
        }

    }
}
