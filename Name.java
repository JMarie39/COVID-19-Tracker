/** The class Name represents the given name of a person. 	*/
public class Name{
	
	/**	This constructor initializes the first name, middle name and last name of the person, based on the given parameters.
	 * 
	 * 	@param f first name of the person 
	 * 	@param m middle name of the person
	 * 	@param s surname of the person	*/
	public Name(String f, String m, String s)
	{
		this.fName = f;
		this.mName = m;
		this.sName = s;
	}
	
	/**	This method returns the first name of the person.
	  * 		
	  * @return fName first name of the person	*/
	public String getFirstName() {
		return fName;
	}
	
	/**	This method sets the first name of the person.
	  * 		
	  * @param f first name of the user	*/
	public void setFirstName(String f) {
		this.fName = f;
	}
	
	/**	This method returns the middle name of the person.
	  * 		
	  * @return mName middle name of the person	*/
	public String getMiddleName() {
		return mName;
	}
	
	/**	This method sets the middle name of the person.
	  * 		
	  * @param m middle name of the user	*/
	public void setMiddleName(String m) {
		this.mName = m;
	}
	
	/**	This method returns the surname of the person.
	  * 		
	  * @return surname of the person	*/
	public String getSurName() {
		return sName;
	}
	
	/**	This method sets the surname of the person.
	  * 		
	  * @param s surname of the user	*/
	public void setSurName(String s) {
		this.sName = s;
	}
	
	/**	This method returns a concatenation of the first name, middle name and surname of the person.
	 * 	
	 * 	@return concatenation of the first name, middle name, surname of the person	*/
	@Override
	public String toString() {
		return fName + " " + mName + " " + sName;
	}
	
	/**	First name of a person	*/
	private String fName;
	/**	Middle name of a person	*/
	private String mName;
	/**	Surname of a person	*/
	private String sName;
}