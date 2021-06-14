/** The class Date represents the date information.	*/
public class Date{
	
	/**	This constructor initializes the month, date and year of a date, based on the given parameters.
	 * 
	 * 	@param m month of the given date
	 * 	@param d day of the given date
	 * 	@param y year of the given date	*/
	public Date(int m, int d, int y) {
		month = m;
		day = d;
		year = y;
	}
	
	/**	This method returns the month of the date.
	  * 		
	  * @return month of the date	*/
	public int getMonth() {
		return month;
	}
	
	/**	This method sets the month of the date.
	  * 		
	  * @param m month	*/
	public void setMonth(int m) {
		month = m;
	}
	
	/**	This method returns the day of the date.
	  * 		
	  * @return day of the date	*/
	public int getDay() {
		return day;
	}
	
	/**	This method sets the day of the date.
	  * 		
	  * @param d day	*/
	public void setDay(int d) {
		day = d;
	}
	
	/**	This method returns the year of the date.
	  * 		
	  * @return year	*/
	public int getYear() {
		return year;
	}
	
	/**	This method sets the month of the date.
	  * 		
	  * @param y year	*/
	public void setYear(int y) {
		year = y;
	}
	
	/**	This method returns a concatenation of the month, day and year of the date. For example: 8 / 31 / 2020
	 * 	
	 * 	@return concatenation of the month, day and year of the date	*/
	@Override
	public String toString() {
		return month + "," + day + "," + year;
	}
	
	/**	This method checks if the given date information is valid
	 * 
	 * 	@param m month of the given date
	 * 	@param d day of the given date
	 * 	@param y year of the given date	
	 * 	@return true if the given date information are valid, otherwise false	*/
	public boolean isValidDate(int m, int d, int y) {
		return isValidMonth(m) && isValidDay(m, d, y) && isValidYear(y);
	}
	
	/**	This method checks if the given month is between 1-12.
	 * 
	 * 	@param m month of the given date	
	 * 	@return true if the given month is valid, otherwise false	*/
	private boolean isValidMonth(int m) {
	   return (m > 0 && m < 13);
	}
	
	/**	This method checks if the given day is valid in the given month.
	 * 
	 * 	@param m month of the given date
	 * 	@param d day of the given date
	 * 	@param y year of the given date		
	 * 	@return true if the given day is valid, otherwise false	*/
	private boolean isValidDay(int m, int d, int y) {
		if(isValidYear(y) && isValidMonth(m)) {
			switch(m) {		// for checking the leap year
				case 1: case 3: case 5: case 7: case 8:	case 10: case 12:	if(d <= 31) return true; break;
				case 4: case 6: case 9: case 11:  if(d <= 30) return true; break;
				case 2:
						if(y % 4 == 0) {
							if(y % 100 != 0)
								if(d <= 29) return true;
							else {
								if(y % 400 == 0)
									if(d <= 29) return true;
								else 
									if(d <= 28) return true;
							}
						} else if(d <= 28) return true;
						break;
			}
		}
		return false;
	}
	/**	This method checks if the given year is greater than 0.
	  *
	  * @param y year released
	  * @return true if valid, otherwise false	*/
	private boolean isValidYear(int y) {
		return (y > 0);
	}
	
	/**	Month of the date	*/
	private int month;
	/**	Day of the date	*/
	private int day;
	/**	Year of the date	*/
	private int year;
}