import java.util.ArrayList;

/**	The class Tracer represents the actions of the contact tracer.	*/
public class Tracer extends Citizen {
	
	/**	This constructor initializes the citizen information, based on the given parameter.
	 * 
	 * 	@param citizen information (user, personal and contact information)	*/
	public Tracer(Citizen citizen) {
		super(citizen.getUser(), citizen.getPersonal(), 3);
	}
	
	/**	This method returns the cases assigned to the current user that have not undergone contact tracing.
	 * 
	 * 	@param currentUser the current user logged in
	 * 	@param cases list of cases	
	 *  @return caseList the list of assigned cases that the tracer haven't traced yet */
	public ArrayList<Case> showCases(String currentUser, ArrayList<Case> cases){ //MODIFIED FOR GUI
		int i;
		ArrayList<Case> caseList = new ArrayList<Case>();
		
		for(i = 0; i < cases.size(); i++)
			if(currentUser.equalsIgnoreCase(cases.get(i).getTracer()) && cases.get(i).getStatus() == 'P')
				caseList.add(cases.get(i));

		return caseList;
	}
}