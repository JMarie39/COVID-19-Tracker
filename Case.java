/**	The class Case represents the information of a reported positive case*/
public class Case {
	
	/**	This constructor initializes the user and date, based on the given parameters.
	 * 
	 * 	@param u the username of the user who was reported positive
	 * 	@param d the date when the user was reported positive	*/
	public Case (String u, Date d) {
		user = u;
		date = d;
		tracer = "000";
		status = 'P';
		caseNum = caseCount + 1;
		Case.addCase();
	}
	
	/**	This constructor initializes the user and date, based on the given parameters.
	 * 
	 * 	@param cNum case num
	 * 	@param pu positive user
	 * 	@param d reported
	 * 	@param tu assigned
	 * 	@param stat of the case*/
	public Case (int cNum, String pu, Date d, String tu, char stat) {
		user = pu;
		date = d;
		tracer = tu;
		status = stat;
		caseNum = cNum;
		Case.addCase();
	}
	
	/**	This method increments the case count	*/
	public static void addCase () {
		caseCount++;
	}
	
	/**	This method returns the user of the positive case
	 * 
	 * 	@return user the username of the positive case	*/
	public String getUser () {
		return user;
	}
	
	/**	This method returns the date of the positive case
	 * 
	 * 	@return date the date when the case was reported	*/
	public Date getDate () {
		return date;
	}
	
	/**	This method returns the contact tracer assigned to the case
	 * 
	 * 	@return tracer the tracer assigned to the case	*/
	public String getTracer () {
		return tracer;
	}
	
	/**	This method returns the status of the case, either pending or traced.
	 * 
	 * 	@return status tells if the case is either pending or traced	*/
	public char getStatus () {
		return status;
	}
	
	/**	This method returns the case number
	 * 
	 * 	@return caseNum the number of the case	*/
	public int getCaseNum () {
		return caseNum;
	}
	
	/**	This method returns the case count
	 * 
	 * 	@return caseCount the total number of cases	*/
	public int getCaseCount () {
		return caseCount;
	}
	
	/**	This method updates the status of the case
	 * 
	 * 	@param s the new status of the case	*/
	public void setStatus(char s) {
		status = s;
	}
	
	/** This method sets the string in the parameter as the assigned tracer of the case
	 * 
	 * @param t the username of the tracer to be assigned
	 */
	public void setTracer(String t) {
		tracer = t;
	}
	
	/**	This method returns a concatenation of the case number, user, date, tracer and status.
	 * 	
	 * 	@return concatenation of the case number, user, date, tracer and status */
	@Override
	public String toString () {
		return caseNum + " " + user + " " + date.toString() + " " + tracer + " " + status + "\n";
	}
	
	/**	Username of the user	*/
	private String user;
	/**	Date positive	*/
	private Date date;
	/**	Tracer username assigned for the case	*/
	private String tracer;
	/**	Status of the case	*/
	private char status;
	/**	Case number	*/
	private int caseNum;
	/**	Case count	*/
	private static int caseCount = 0;
}