import java.util.ArrayList;

/**	The class Model represents an object carrying data.	*/
public class Model {
	
	/**	This constructor initializes the ArrayList.	*/
	public Model() {
		citizenList = new ArrayList<Citizen>();
		officialList = new ArrayList<Official>();
		tracerList = new ArrayList<Tracer>();
		caseList = new ArrayList<Case>();
	}
	
	/**	This methods checks the sign in username and password entered.
	 * 
	 * 	@param username entered
	 * 	@param password entered
	 * 	@return true if user exist, otherwise false	*/
	public boolean signIn(String username, String password) {
		Checking check = new Checking();
		if (check.LogIn_User(citizenList, username, password) != null) {
			loggedInUser = username;
			currentUser_Citizen = check.CurrentUser_Citizen(citizenList, username);
			currentUser_Official = check.CurrentUser_Official(officialList, username);
			currentUser_Tracer = check.CurrentUser_Tracer(tracerList, username);
			return true;
		}
		
		return false;
	}
	
	/**	This methods returns the username of the logged in user.
	 * 
	 * 	@return username of the logged in user	*/
	public String getLoggedInUser() {
		return loggedInUser;
	}
	
	/**	This method gets the current citizen object.	
	 * 
	 * 	@return current citizen object	*/
	public Citizen getCurretCitizen() {
		return currentUser_Citizen;
	}
	
	/**	This method gets the current official object.	
	 * 
	 * 	@return current official object	*/
	public Official getCurretOfficial() {
		return currentUser_Official;
	}
	
	/**	This method gets the current tracer object.	
	 * 
	 * 	@return current tracer object.	*/
	public Tracer getCurretTracer() {
		return currentUser_Tracer;
	}
	
	/**	This methods returns the ArrayList of citizen.
	 * 
	 * 	@return list of citizens	*/
	public ArrayList<Citizen> getCitizens() {
		return citizenList;
	}

	/**	This methods returns the ArrayList of official.
	 * 
	 * 	@return list of officials	*/
	public ArrayList<Official> getOfficials() {
		return officialList;
	}

	/**	This methods returns the ArrayList of tracer.
	 * 
	 * 	@return list of tracers	*/
	public ArrayList<Tracer> getTracers() {
		return tracerList;
	}

	/**	This methods returns the ArrayList of case.
	 * 
	 * 	@return list of cases	*/
	public ArrayList<Case> getCases() {
		return caseList;
	}
	
	/** This method returns the array of visit records that overlap with the visit record of the parameter
	 * 
	 * @param caseTraced The visit record of the user in the case being handled
	 * @return exposed The array of visit records that overlap with the caseTraced visit record	*/
	public ArrayList<VisitRecord> getOverlap(ArrayList<VisitRecord> caseTraced){
		ArrayList<VisitRecord> exposed = new ArrayList<VisitRecord>();
		int i, j;
		
		for(j = 0; j < caseTraced.size(); j++) {
			for(Citizen c : citizenList) {
				for(i = 0; i < c.visitRecord.size(); i++) {
					if(!caseTraced.get(j).getUsername().equals(c.visitRecord.get(i).getUsername()))
						if(caseTraced.get(j).getCode().equalsIgnoreCase(c.visitRecord.get(i).getCode()))
							if(caseTraced.get(j).getDate().getYear() == c.visitRecord.get(i).getDate().getYear())
								if(caseTraced.get(j).getDate().getMonth() == c.visitRecord.get(i).getDate().getMonth())
									if(caseTraced.get(j).getDate().getDay() == c.visitRecord.get(i).getDate().getDay())
										if(caseTraced.size() > 1) {
											if(caseTraced.get(j).getTime() <= c.visitRecord.get(i).getTime() && caseTraced.get(j+1).getTime() >= c.visitRecord.get(i).getTime())
											exposed.add(c.visitRecord.get(i));
										} else if (caseTraced.get(j).getTime() <= c.visitRecord.get(i).getTime())
											exposed.add(c.visitRecord.get(i));
				}
			}
		}
		
		return exposed;
	}
	
	/**	Username of the logged in user	*/
	private String loggedInUser;
	/**	List of citizens	*/
	private ArrayList<Citizen> citizenList;
	/**	List of officials	*/
	private ArrayList<Official> officialList;
	/**	List of tracers	*/
	private ArrayList<Tracer> tracerList;
	/**	List of cases	*/
	private ArrayList<Case> caseList;
	/**	Current user if citizen	object */
	private Citizen currentUser_Citizen;
	/**	Current user if official object */
	private Official currentUser_Official;
	/**	Current user if tracer object */
	private Tracer currentUser_Tracer;
}