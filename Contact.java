/** The class Contact represents the contact information needed.	*/
public class Contact {
	
	/**	This constructor initializes the contact information of the user, based on the given parameters.
	 * 	
	 * 	@param homeAdd home address
	 * 	@param officeAdd office address
	 * 	@param numPhone phone number
	 * 	@param emailAdd email address	*/
	public Contact(String homeAdd, String officeAdd, String numPhone, String emailAdd) {
		this.addressHome = homeAdd;
		this.addressOffice = officeAdd;
		this.numberPhone = numPhone;
		this.addressEmail = emailAdd;
	}
	
	/**	This method sets the home address of the user.
	 * 	
	 * 	@param aHome home address	*/
	public void setHome(String aHome) {
		this.addressHome = aHome;
	}
	
	/**	This method sets the office address of the user.
	 * 	
	 * 	@param aOffice office address	*/
	public void setOffice(String aOffice) {
		this.addressOffice = aOffice;
	}
	
	/**	This method sets the phone number of the user.
	 * 	
	 * 	@param pNumber phone number	*/
	public void setPhone(String pNumber) {
		this.numberPhone = pNumber;
	}
	
	/**	This method sets the email address of the user.
	 * 	
	 * 	@param aEmail email address	*/
	public void setEmail(String aEmail) {
		this.addressEmail = aEmail;
	}
	
	/**	This method returns the home address of the user.
	 * 	
	 * 	@return home address	*/
	public String getHome() {
		return addressHome;
	}
	
	/**	This method returns the office address of the user.
	 * 	
	 * 	@return office address	*/
	public String getOffice() {
		return addressOffice;
	}
	
	/**	This method returns the phone number of the user.
	 * 	
	 * 	@return phone number	*/
	public String getPhone() {
		return numberPhone;
	}
	
	/**	This method returns the email address of the user.
	 * 	
	 * 	@return email address	*/
	public String getEmail() {
		return addressEmail;
	}
	
	/**	Home address of the user	*/
	private String addressHome;
	/**	Office address of the user	*/
	private String addressOffice;
	/**	Phone number of the user	*/
	private String numberPhone;
	/**	Email address of the user	*/
	private String addressEmail;
}