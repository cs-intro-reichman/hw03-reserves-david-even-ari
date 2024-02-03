public class test1 {
    static int iterationCounter = 0;

    public static void main(String[] args) {
        double loan = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);
        double epsilon = Double.parseDouble(args[3]); // Corrected to double
        System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);

        // Computes the periodical payment using brute force search
        System.out.print("Periodical payment, using brute force: ");
        System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
        System.out.println();
        System.out.println("number of iterations: " + iterationCounter);
    }

    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
        double periodical = 1.0;
        double p10;
        int count = 0;
        while (true) {
            p10 = loan;
            for (int i = 0; i < n; i++) { // Corrected loop condition
                p10 = ((p10 - periodical) * (1 + rate / 100));
            }
            if (Math.abs(p10) < epsilon) {
                break;
            } else {
                periodical += epsilon;
                count++;
            }
        }
        iterationCounter = count; // Update global iterationCounter
        return periodical;
    }
}

