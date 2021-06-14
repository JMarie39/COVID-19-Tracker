import java.util.ArrayList;

/** The class Citizen represents the citizen information needed.	*/
public class Citizen {
	
	/**	This constructor initializes the user information and personal information of the citizen. This sets the default role of the user to "citizen".
	 * 	
	 * 	@param user is the username and password of the user
	 * 	@param personal is the name, birth date and contact information of the user */
	public Citizen(User user, Personal personal) {
		this.user = user;
		this.personal = personal;
		this.role = "citizen";
	}
	
	/**	This constructor initializes the user information and personal information of the citizen.
	 * 	
	 * 	@param user is the username and password of the user
	 * 	@param personal is the name, birth date and contact information of the user 
	 * 	@param role is the role of the user (2 for government official and 3 for contact tracer)	*/
	public Citizen(User user, Personal personal, int role) {
		this.user = user;
		this.personal = personal;
		
		if(role == 2)
			this.role = "official";
		else if(role == 3)
			this.role = "tracer";
	}
	
	/**	This method returns the user information (username and password) of the user.
	 * 	
	 * 	@return user information needed to log in	*/
	public User getUser() {
		return user;
	}
	
	/**	This method returns the personal information (name, birth date and contact information) of the user.
	 * 	
	 * 	@return personal information of the user	*/
	public Personal getPersonal () {
		return personal;
	}
	
	/**	This method sets the role of the user.
	 * 	
	 * 	@param role of the citizen	*/
	public void setRole(String role) {
		this.role = role.toLowerCase();
	}
	
	/**	This method returns the role of the user.	
	 * 	
	 * 	@return role of the user	*/
	public String getRole() {
		return role;
	}
	
	/**	This method sets the role of the user into a "citizen".	*/
	public void removeRole() {
		role = "citizen";
	}
	
	/**	This method sets the notice to true if the user received a notice from a contact tracer.	*/
	public void isInformed() {
		notice = true;
	}
	
	/** This method returns the notice of the citizen
	 * 
	 * @return notice either true or false */
	public boolean getNotice() {
		return notice;
	}
	
	/**	This method adds the establishment visited by the citizen.
	 * 
	 * 	@param estCode is the establishment code	
	 * 	@param date of the visited establishment
	 * 	@param time visited the establishment code	*/
	public void checkIn(String estCode, Date date, int time) {
		VisitRecord visit = new VisitRecord(estCode, date, time, user.getUsername());
		visitRecord.add(visit);
	}
	
	/**	This method reports the positive cases.
	 * 
	 * 	@param cases list of cases	
	 * 	@param reportDate date reported	*/
	public void reportPositive(ArrayList<Case> cases, Date reportDate) {
		Case tempcase = new Case(this.getUser().getUsername(), reportDate);
		cases.add(tempcase);
		notice = false;
	}
	
	/**	This method returns the notice information
	 * 
	 * 	@return notice	*/
	public Notice getNoticeInfo() {
		return noticeInfo;
	}
	
	/**	User information needed to log in	*/
	private User user;
	/**	Personal information of the citizen	*/
	private Personal personal;
	/**	Role of the citizen	*/
	private String role;
	/** Notice information of the citizen */
	private Notice noticeInfo = new Notice();
	/**	Notice from a contact tracer	*/
	private boolean notice = false;
	/**	Establishment visit record of the person	*/
	public ArrayList<VisitRecord> visitRecord = new ArrayList<VisitRecord>();
}