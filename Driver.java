import java.util.ArrayList;

/**	The Driver class is for running the program	
 * 
 * 	@author Juliana Agulto
 * 	@author Fritz Duriman	*/
public class Driver {
	
	public static void main(String[] args) {
		SignIn_View signInView = new SignIn_View();
		Model model = new Model();
		initGui(model.getCitizens(), model.getOfficials(), model.getTracers(), model.getCases());
		SignIn_Controller controller = new SignIn_Controller(model, signInView);
		
		//	-- For checking
		Checking check = new Checking();	
		check.printCitizenList(model.getCitizens());	
		check.printOfficialList(model.getOfficials());
		check.printTracerList(model.getTracers());
		check.printCaseList(model.getCases());
		// --
		
		signInView.setVisible(true);
	}
	
	/**	This method is used to load the text files once it runs
	 * 
	 * 	@param citizenList list of citizens
	 * 	@param officialList list of officials
	 * 	@param tracerList list of tracers
	 * 	@param caseList list of cases	*/
	public static void initGui (ArrayList<Citizen> citizenList, ArrayList<Official> officialList, ArrayList<Tracer> tracerList,  ArrayList<Case> caseList) {
		new TextFiles().ReadAccounts(citizenList, officialList, tracerList);		// Reads the MasterList.txt file
		new TextFiles().ReadCase(caseList);				// Reads the PositiveCase.txt file
		
		if (!new Checking().isValidCUsername(citizenList, "Admin2020"))		// To check whether user Admin2020 exist in the text file
			new Checking().defaultUser(citizenList, officialList);
		
		String user;
		ArrayList<VisitRecord> traced;
		Model model = new Model();
		int i, j;
		for(Citizen citizens1 : citizenList)
			model.getCitizens().add(citizens1);
		for(Case cases : caseList)
			if(cases.getStatus() == 'T') {
				traced = new ArrayList<VisitRecord>();
				user = cases.getUser();
				for(Citizen citizens : citizenList)
					if(citizens.getUser().getUsername().equals(user))
						traced = model.getOverlap(citizens.visitRecord);
				for(i = 0; i < traced.size(); i++) {
					for(j = 0; j < model.getCitizens().size(); j++)
						if(model.getCitizens().get(j).getUser().getUsername().equals(traced.get(i).getUsername())) {
							model.getCitizens().get(j).isInformed();
							model.getCitizens().get(j).getNoticeInfo().setExposedDate(traced.get(i).getDate().toString());
							model.getCitizens().get(j).getNoticeInfo().setExposedEstablishment(traced.get(i).getCode());
						}
				}
			}
	}
}