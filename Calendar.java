public class Calendar {
    static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
    public static void main(String args[]) {
        int startyear = Integer.parseInt(args[0]);
        while (!(year == startyear - 1 && dayOfMonth == 31 && month == 12)) {
            advance();
        }
        while (!(year == startyear && dayOfMonth == 31 && month == 12)) {
            advance();
            System.out.print(dayOfMonth + "/" + month + "/" + year); 
			if (dayOfWeek == 1) {
				System.out.print(" Sunday");
			}		
			System.out.println();
        }
    }

    private static void advance() {
		dayOfMonth++;
		dayOfWeek++;
		if (dayOfWeek == 8) {
			dayOfWeek = 1;
		}
		if (dayOfMonth == nDaysInMonth(month, year)+1) {
			dayOfMonth = 1;
			month++;
			if (month == 13) {
				month = 1;
				year++;
			}
			nDaysInMonth = nDaysInMonth(month, year);
		}
		// Replace this comment with your code
	 } 

    private static boolean isLeapYear(int year) {
	    if (year % 100 == 0) {
			if (year % 400 == 0) {
				return true;
			}
		}else if (year % 4 == 0) {
			return true;
		}
		
		return false;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		switch (month) {
			case 4,6,9,11:
				return 30;
			case 2:
				if (isLeapYear(year)) {
					return 29;
				}
				return 28;
			default:
				return 31;
		}
	}

}

