/**	The class User represents log in information of the account	*/
public class User {
	
	/**	This constructor initializes the username and password of the user
	 * 	@param username the username of the user
	 * 	@param password the password of the user	*/
	public User(String username, String password) {
		this.USERNAME = username.toUpperCase();
		this.password = password;
	}
	
	/** This method sets the password of the user
	 * 	@param password the password being set */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/** This method returns the username of the user
	 * 	@return USERNAME the username of the user	*/
	public String getUsername() {
		return USERNAME;
	}
	
	/** This method returns the password of the user
	 * 	@return password the password of the user	*/
	public String getPassword() {
		return password;
	}
	
	/**	Username of the user	*/
	private final String USERNAME;
	/**	Password of the user	*/
	private String password;
}