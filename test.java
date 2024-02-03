/**
* Computes the periodical payment necessary to re-pay a given loan.
*/
public class LoanCalc {
	
	static double epsilon = 0.001;  // The computation tolerance (estimation error)
	static int iterationCounter=0;    // Monitors the efficiency of the calculation
	
    /** 
     * Gets the loan data and computes the periodical payment.
     * Expects to get three command-line arguments: sum of the loan (double),
     * interest rate (double, as a percentage), and number of payments (int).  
     */
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		
		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}
	
	/**
	* Uses a sequential search method  ("brute force") to compute an approximation
	* of the periodical payment that will bring the ending balance of a loan close to 0.
	* Given: the sum of the loan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {  
    	// Replace the following statement with your code
		double periodical = 1.0;
		double p10 ;
        int count =0;
		while (true) {
			p10 = loan ;
			for (int i=0 ;i <n ; i++){
				p10 =( (p10 - periodical )* (1+ rate/100 ));
			}
		 if (Math.abs(p10) < epsilon ) {
			break ;
		 } else {
			periodical += epsilon ;
		    count++; }
		}
		 iterationCounter = count;
		 return periodical;
		}

		
	/* 
	* Uses bisection search to compute an approximation of the periodical payment 
	* that will bring the ending balance of a loan close to 0.
	* Given: the sum of theloan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
    	// Replace the following statement with your code
		
		double L =loan/n;
		double H =loan*(1+rate/100);
        int count = 0; 
		double	g =(L+H)/2;
		
		while (H-L> epsilon) {
		
		double p10 =loan;

		for (int i=0 ;i <n ; i++){
			p10 =( (p10 - g )* (1+ rate/100 ));
		}
          if (p10>0){
			L=g;
			count++;
		  }else {
			H=g;
			count++;
		  }
		  g =(L+H)/2;
		 }
		 iterationCounter = count;
    	 return g ;
    }
	
	/**
	* Computes the ending balance of a loan, given the sum of the loan, the periodical
	* interest rate (as a percentage), the number of periods (n), and the periodical payment.
	*/
	private static double endBalance(double loan, double rate, int n, double payment) {
		// Replace the following statement with your code
		double balance = loan ;
		for (int i=0 ;i <n ; i++){
			balance =( (balance - payment )* (1+ rate/100 ));
		}
		balance =loan - balance;
    	return balance;
	}
}