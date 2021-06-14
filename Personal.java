/** The class Personal represents the personal information of the person.	*/

public class Personal {
	
	/**	This method initializes the name, based on the given parameter.
	 * 
	 * 	@param name of the person	*/
	public void setName(Name name) {
		fullName = name;
	}
	
	/**	This method returns the name of the person
	 * 
	 * 	@return name of the person	*/
	public Name getName() {
		return fullName;
	}
	
	/**	This method initializes the birth date, based on the given parameter.
	 * 
	 * 	@param date of the birthday	*/
	public void setBDay(Date date) {
		BDay = date;
	}
	
	/**	This method returns the birth date of the person.
	 * 
	 * 	@return birth date of the person	*/
	public Date getDate() {
		return BDay;
	}
	
	/**	This method initializes the contact information, based on the given parameter.
	 * 
	 * 	@param contact information of the person	*/
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	/**	This method returns the contact information of the person.
	 * 
	 * 	@return contact information of the person	*/
	public Contact getContact() {
		return contact;
	}
	/**	Full name of a person	*/
	private Name fullName;
	/**	Birth date of a person	*/
	private Date BDay;
	/**	Contact information of a person	*/
	private Contact contact;
}