/** The class VisitRecord represents the establishments that the account checked-in.	*/
public class VisitRecord{
	
	/** This constructor initializes the establishment code, visit date, visit time, and the username of the user's visit record.
	 * 
	 * 	@param c establishment code that the user checked-in
	 * 	@param date check-in date of the user
	 * 	@param t check-in time of the user	
	 *  @param username the username of the user checking-in */
	public VisitRecord (String c, Date date, int t, String username) {
		establishmentCode = c;
		visitDate = date;
		visitTime = t;
		this.username = username;
	}
	
	/** This method returns the establishment code.
	 *
	 * 	@return establishhmentCode the code of the establishment that the user checked-in*/
	public String getCode() {
		return establishmentCode;
	}
	
	/**	This method return the visit date
	 * 
	 * 	@return visitDate the date of the check-in	*/
	public Date getDate() {
		return visitDate;
	}
	
	/**	This method returns the visit time
	 * 
	 * 	@return visitTime the time of the check-in	*/
	public int getTime() {
		return visitTime;
	}
	
	/**	This method returns the username of this record
	 * 	
	 * 	@return username of the record */
	public String getUsername() {
		return username;
	}
	
	/**	Establishment code	*/
	private String establishmentCode;
	/**	Date visited	*/
	private Date visitDate;
	/**	Time visited	*/
	private int visitTime;
	/**	Username of this visit record	*/
	private String username;
}