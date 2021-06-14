import java.util.ArrayList;

/**	The class Official represents the actions of a government official	*/
public class Official extends Citizen {
	
	/**	This constructor initializes the citizen information, based on the given parameter.
	 * 
	 * 	@param citizen information (user, personal and contact information)	*/
	public Official(Citizen citizen) {
		super(citizen.getUser(), citizen.getPersonal(), 2);
	}
	
	/**	This method assigns the case to a certain user
	 * 
	 * 	@param caseNum case numbers
	 * 	@param tracer name
	 *  @param casesList list of cases	*/
	public void assignCase(int caseNum, String tracer, ArrayList<Case> casesList) {
		int i;
		
		for(i = 0; i < casesList.size(); i++) {
			if(caseNum-1 == i) {
				casesList.get(i).setTracer(tracer);
			}
		}
	}
	
	/**	This method displays all the positive cases of the given dates.
	 * 
	 * 	@param cases list of cases	
	 * 	@param dateStart initial date entered
	 * 	@param dateEnd end date entered	
	 * 	@return ArrayList of cases	*/
	public ArrayList<Case> showUpdates (ArrayList<Case> cases, Date dateStart, Date dateEnd) { //MODIFIED FOR GUI, should update javadoc
		int i;
		ArrayList<Case> caseList = new ArrayList<Case>();
		
		for(i = 0; i < cases.size(); i++) {
			if(cases.get(i).getDate().getYear() >= dateStart.getYear() && cases.get(i).getDate().getYear() <= dateEnd.getYear() && cases.get(i).getDate().getMonth() >= dateStart.getMonth() && cases.get(i).getDate().getMonth() <= dateEnd.getMonth() && cases.get(i).getDate().getDay() >= dateStart.getDay() && cases.get(i).getDate().getDay() <= dateEnd.getDay()) {
				caseList.add(cases.get(i));
			}		
		}
		
		return caseList;
	}
	
	/**	This method generates and shows reports. This shows the following information 
	 * show number of positive cases of a given city (from home address of positive case) in a given duration; 
	 * 
	 * 	@param enteredCity given city
	 * 	@param dateStart initial date entered
	 * 	@param dateEnd end date entered
	 * 	@param citizens	list of citizens
	 * 	@param cases list of cases	
	 * 	@return String of analytics to be displayed */
	public String getAnalytics (String enteredCity, Date dateStart, Date dateEnd, ArrayList<Citizen> citizens, ArrayList<Case> cases) { //MODIFIED FOR GUI, should update javadoc
		int i, j = 0, k = 0, size = 0, ctr1 = 0;
		String arr[];
		
		if(dateStart.getMonth()*100 + dateStart.getDay() + dateStart.getYear()*10000 > dateEnd.getMonth()*100 + dateEnd.getDay() + dateEnd.getYear()*10000)
			return "\nXx INVALID ENTERED END DATE xX\n";
		else {
			for(i = 0; i < citizens.size(); i++) {		// This counts the number of cities that contains the word of the given city
				if(citizens.get(i).getPersonal().getContact().getHome().toLowerCase().contains(enteredCity.toLowerCase())) {
					size++;
				}
			}
			arr = new String[size];
			for(i = 0; i < citizens.size(); i++) {		// This stores the citizen information that contains the given city
				if(citizens.get(i).getPersonal().getContact().getHome().toLowerCase().contains(enteredCity.toLowerCase())) {
						arr[j] = citizens.get(i).getUser().getUsername();
						j++;
				}
			}
			
			for(i = 0; i < arr.length; i++) {			// This counts the number of positive cases in the city
				for(j = 0; j < cases.size(); j++) {
					if(cases.get(j).getUser().equals(arr[i])) {
						k++;
						if(cases.get(j).getDate().getYear() >= dateStart.getYear() && cases.get(j).getDate().getYear() <= dateEnd.getYear() && cases.get(j).getDate().getMonth() >= dateStart.getMonth() && cases.get(j).getDate().getMonth() <= dateEnd.getMonth() && cases.get(j).getDate().getDay() >= dateStart.getDay() && cases.get(j).getDate().getDay() <= dateEnd.getDay())
							ctr1++;
					}
				}
			}

			return "There are " + ctr1 + " positive case/s in " + enteredCity + "\nbetween " + dateStart + " and " + dateEnd;
		}
	}
	
	/**	This method generates and shows reports. This shows the following information 
	 * show number of positive cases of a given city (from home address of positive case). 
	 * 
	 * 	@param enteredCity given city
	 * 	@param citizens	list of citizens
	 * 	@param cases list of cases	
	 * 	@return String of analytics to be displayed	*/
	public String getAnalytics (String enteredCity, ArrayList<Citizen> citizens, ArrayList<Case> cases) { //MODIFIED FOR GUI, should update javadoc
		int i, j = 0, k = 0, size = 0;
		String arr[];

			for(i = 0; i < citizens.size(); i++) {		// This counts the number of cities that contains the word of the given city
				if(citizens.get(i).getPersonal().getContact().getHome().toLowerCase().contains(enteredCity.toLowerCase())) {
					size++;
				}
			}
			
			arr = new String[size];
			for(i = 0; i < citizens.size(); i++) {		// This stores the citizen information that contains the given city
				if(citizens.get(i).getPersonal().getContact().getHome().toLowerCase().contains(enteredCity.toLowerCase())) {
						arr[j] = citizens.get(i).getUser().getUsername();
						j++;
				}
			}	
			
			for(i = 0; i < arr.length; i++) {			// This counts the number of positive cases in the city
				for(j = 0; j < cases.size(); j++) {
					if(cases.get(j).getUser().equals(arr[i])) {
						k++;
					}
				}
			}
			
			return "There are " + k + " positive case/s in " + enteredCity;
	}
	
	/**	This method generates and shows reports. This shows the following information 
	 * show number of positive cases in a given duration
	 * 
	 * 	@param dateStart initial date entered
	 * 	@param dateEnd end date entered
	 * 	@param citizens	list of citizens
	 * 	@param cases list of cases	
	 *	@return String of analytics to be displayed	*/
	public String getAnalytics (Date dateStart, Date dateEnd, ArrayList<Citizen> citizens, ArrayList<Case> cases) { //MODIFIED FOR GUI, should update javadoc
		int i, ctr2 = 0;
		
		if(dateStart.getMonth()*100 + dateStart.getDay() + dateStart.getYear()*10000 > dateEnd.getMonth()*100 + dateEnd.getDay() + dateEnd.getYear()*10000)
			return "\nXx INVALID ENTERED END DATE xX\n";
		else {
			for(i = 0; i < cases.size(); i++) {			// This counts the number of positive case in the given duration
				if(cases.get(i).getDate().getYear() >= dateStart.getYear() && cases.get(i).getDate().getYear() <= dateEnd.getYear() && cases.get(i).getDate().getMonth() >= dateStart.getMonth() && cases.get(i).getDate().getMonth() <= dateEnd.getMonth() && cases.get(i).getDate().getDay() >= dateStart.getDay() && cases.get(i).getDate().getDay() <= dateEnd.getDay())
					ctr2++;
			}
			return "There are " + ctr2 + " positive case/s between " + dateStart + " and " + dateEnd;
		}
	}
	
	/**	This method creates a government official account. If the username entered exist the current user will promote the citizen, else the user will create/ register a new account
	 * 	
	 * 	@param citizenList list of all citizens
	 * 	@param officialList list of all officials
	 * 	@param tracerList list of all tracers
	 * 	@param currentUser username of the current user
	 * 	@param enteredUserName username the current user wish to promote	
	 * 	@return checking of action	*/
	public int createOfficial (ArrayList<Citizen> citizenList, ArrayList<Official> officialList, ArrayList<Tracer> tracerList, String currentUser, String enteredUserName) {
		int i, index = -1;
		boolean checkExist = false;
		int checking = -1;
		
		for(i = 0; i < citizenList.size(); i++)
			if(citizenList.get(i).getUser().getUsername().equalsIgnoreCase(enteredUserName)) {
				checkExist = true;	// If the entered username exist
				index = i;
			}
		
		if(checkExist) {
			if(citizenList.get(index).getUser().getUsername().equalsIgnoreCase(enteredUserName)) {
				if(currentUser.equalsIgnoreCase(enteredUserName)) {	// If user entered his own username
					System.out.println("Xx INVALID, THIS IS YOUR CURRENT ACCOUNT xX");
					checking = 1;
				} else {
					if(citizenList.get(index).getRole().equals("tracer")) {				// If entered username is contact tracer account
						System.out.println("Xx INVALID, THIS ACCOUNT IS A CONTACT TRACER ACCOUNT xX");
						checking = 2;
					} else if(citizenList.get(index).getRole().equals("official")) {	// If entered username is already a government official account
						System.out.println("Xx INVALID, THIS ACCOUNT IS ALREADY A GOVERNMENT OFFICIAL ACCOUNT xX");
						checking = 3;
					} else {
						citizenList.get(index).setRole("official");
						officialList.add(new Official (citizenList.get(index)));
						System.out.println("\t~ ACCOUNT SUCCESSFULLY CREATED ~");
						checking = 4;
					}
				}
			} 
		} 
		return checking;
	}
		
	/**	This method creates a contact tracer account. If the username entered exist the current user will promote the citizen, else the user will create/ register a new account
	 * 	
	 * 	@param citizenList list of citizens
	 * 	@param officialList list of officials
	 * 	@param tracerList list of tracers
	 * 	@param currentUser username of the current user
	 * 	@param enteredUserName username the current user wish to promote	
	 * 	@return checking of action	*/
	public int createTracer (ArrayList<Citizen> citizenList, ArrayList<Official> officialList, ArrayList<Tracer> tracerList, String currentUser, String enteredUserName) {
		int i, index = -1;
		boolean checkExist = false;
		int checking = -1;
		
		for(i = 0; i < citizenList.size(); i++)
			if(citizenList.get(i).getUser().getUsername().equalsIgnoreCase(enteredUserName)) {
				checkExist = true;	// If the entered username exist
				index = i;
			}
		
		if(checkExist) {
			if(citizenList.get(index).getUser().getUsername().equalsIgnoreCase(enteredUserName)) {
				if(currentUser.equalsIgnoreCase(enteredUserName)) {	// If user entered his own username
					System.out.println("Xx INVALID, THIS IS YOUR CURRENT ACCOUNT xX");
					checking = 1;
				} else {
					if(citizenList.get(index).getRole().equals("official")) {			// If entered username is government official account
						System.out.println("Xx INVALID, THIS ACCOUNT IS A GOVERNMENT OFFICIAL ACCOUNT xX");
						checking = 2;
					} else if(citizenList.get(index).getRole().equals("tracer")) {		// If entered username is already a contact tracer account
						System.out.println("Xx INVALID, THIS ACCOUNT IS ALREADY A CONTACT TRACER ACCOUNT xX");
						checking = 3;
					} else {
						citizenList.get(index).setRole("tracer");		// If the user is a normal citizen
						tracerList.add(new Tracer (citizenList.get(index)));
						System.out.println("\t~ ACCOUNT SUCCESSFULLY CREATED ~");
						checking = 4;	
					}
				}
			} 
		}
		return checking;
	}
	
	/**	This method terminates a government official and contact tracer account and will be made into a citizen account. A citizen account cannot be terminated.
	 * 	
	 * 	@param citizens list of all citizens
	 * 	@param officialList list of all officials
	 * 	@param tracerList list of all tracers
	 * 	@param currentUser username of the current user
	 * 	@param terminateUser username the current user wish to terminate	
	 * 	@return checking of action	*/
	public int terminateAccount (ArrayList<Citizen> citizens, ArrayList<Official> officialList, ArrayList<Tracer> tracerList, String currentUser, String terminateUser) {
		int i, index = 0;
		boolean checkExist = false;
		int checking = -1;
		
		for(i = 0; i < citizens.size(); i++)
			if(citizens.get(i).getUser().getUsername().equalsIgnoreCase(terminateUser)) {
				checkExist = true;
				index = i;
			}
				
		if(checkExist) {
			if(citizens.get(index).getUser().getUsername().equalsIgnoreCase(terminateUser)) {
				if(currentUser.equalsIgnoreCase(terminateUser)) {	// If user entered his own username
					System.out.println("Xx INVALID, CANNOT TERMINATE YOUR OWN ACCOUNT xX");
					checking = 1;	// 1 if own account
				} else {	// If found & not current user
					switch(citizens.get(index).getRole()) {
						case "official": 
										citizens.get(index).removeRole();
										for(i = 0; i < officialList.size(); i++) {	// This terminates the official account
											if(officialList.get(i).getUser().getUsername().equalsIgnoreCase(terminateUser)) {
												officialList.remove(i);
												System.out.println("\t~ ACCOUNT SUCCESSFULLY TERMINATED ~");
												checking = 2;	// account successfully terminated
											}
										}
										break;
						case "tracer": 
										citizens.get(index).removeRole();
										for(i = 0; i < tracerList.size(); i++) {	// This terminates the tracer account
											if(tracerList.get(i).getUser().getUsername().equalsIgnoreCase(terminateUser)) {
												tracerList.remove(i);
												System.out.println("\t~ ACCOUNT SUCCESSFULLY TERMINATED ~");
												checking = 2;	// account successfully terminated
											}
										}
										break;
						case "citizen":	
										System.out.println("\t~ ALREADY A CITIZEN ACCOUNT ~");
										checking = 3;	// already a citizen account
					}
				}
			}
		} else System.out.println("\tXx ENTERED USERNAME NOT FOUND xX");
		return checking;
	}
}