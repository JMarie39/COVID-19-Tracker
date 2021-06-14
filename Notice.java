/** The class Notice represents the notice information.	*/
public class Notice{
	
	/**	This method sets the exposed date.
	 * 
	 * 	@param d exposed	*/
	public void setExposedDate(String d) {
		exposedDate = d;
	}
	
	/**	This method sets the establishment code.	
	 * 
	 * 	@param est establishment code*/
	public void setExposedEstablishment(String est) {
		exposedEst = est;
	}
	
	/**	This method returns the exposed date
	 * 
	 * 	@return exposed date	*/
	public String getExposedDate() {
		return exposedDate;
	}
	
	/**	This method returns the establishment code	
	 * 
	 * 	@return establishment code	*/
	public String getExposedEstablishment() {
		return exposedEst;
	}
	
	/**	Date exposed	*/
	private String exposedDate;
	/**	Establishment code exposed	*/
	private String exposedEst;
}