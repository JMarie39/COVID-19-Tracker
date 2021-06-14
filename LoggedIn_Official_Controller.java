import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/** The class LoggedIn_Official_Controller represents the controller that manipulates the officialView and the model.	*/
public class LoggedIn_Official_Controller {
	
	/** This constructor initializes the model and officialView, based on the parameters.
	 * 
	 * @param model The data being passed between controllers
	 * @param officialView The interactive visual aspect of the official menu */
	public LoggedIn_Official_Controller(Model model, LoggedIn_Official_View officialView) {
		this.model = model;
		this.officialView = officialView;
		
		this.officialView.showUsername(model.getCurretOfficial().getUser().getUsername());
		this.officialView.getPanelOfficial_Case().displayTable(model.getCases());
		
		this.officialView.addAnalyticsListener(new AnalyticsListener());
		this.officialView.addCaseListener(new CaseListener());
		this.officialView.addOfficialListener(new OfficialListener());
		this.officialView.addTerminateListener(new TerminateListener());
		this.officialView.addTracerListener(new TracerListener());
		this.officialView.addUpdateListener(new UpdateListener());
		this.officialView.addUsersListener(new UsersListener());
		this.officialView.addLogOutListener(new LogOutListener());
		
		this.officialView.getPanelOfficial_Analytics().addConfirmListener(new Analytics_ConfirmListener());
		this.officialView.getPanelOfficial_Case().addConfirmListener(new Case_ConfirmListener());
		this.officialView.getPanelOfficial_Official().addConfirmListener(new Official_ConfirmListener());
		this.officialView.getPanelOfficial_Terminate().addConfirmListener(new Terminate_ConfirmListener());
		this.officialView.getPanelOfficial_Tracer().addConfirmListener(new Tracer_ConfirmListener());
		this.officialView.getPanelOfficial_Update().addConfirmListener(new Update_ConfirmListener());
		
		this.officialView.getPanelOfficial_Official().addUsernameListener(new Official_FocusListener());
		this.officialView.getPanelOfficial_Terminate().addUsernameListener(new Terminate_FocusListener());
		this.officialView.getPanelOfficial_Tracer().addUsernameListener(new Tracer_FocusListener());
		
		officialView.getPanelOfficial_Official().getTxtUsername().setText("Citizen Username");
		officialView.getPanelOfficial_Terminate().getTxtUsername().setText("Official/Tracer Username");
		officialView.getPanelOfficial_Tracer().getTxtUsername().setText("Citizen Username");
	}

	/** The class AnalyticsListener extends MouseAdapter in order to listen for mouse interactions with the Analytics panel button*/
	class AnalyticsListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			officialView.getPanelOfficial_Case().setVisible(false);	
			officialView.getPanelOfficial_Update().setVisible(false);
			officialView.getPanelOfficial_Analytics().setVisible(true);
			officialView.getPanelOfficial_Official().setVisible(false);
			officialView.getPanelOfficial_Tracer().setVisible(false);
			officialView.getPanelOfficial_Terminate().setVisible(false);
			officialView.getPanelOfficial_Users().setVisible(false);
			officialView.getPanelOfficial_Analytics().remove();		// Clears the textfields
		}
	}
	
	/** The class Analytics_ConfirmListener extends MouseAdapter in order to listen for mouse interactions with the confirm button under the Analytics panel */
	class Analytics_ConfirmListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			boolean sDate = true, eDate = true, estCode = true;

			if(officialView.getPanelOfficial_Analytics().getTxtMonth().getText().equals("") || officialView.getPanelOfficial_Analytics().getTxtDay().getText().equals("") || officialView.getPanelOfficial_Analytics().getTxtYear().getText().equals(""))
				sDate = false;
			if(officialView.getPanelOfficial_Analytics().getTxtEndMonth().getText().equals("") || officialView.getPanelOfficial_Analytics().getTxtEndDay().getText().equals("") || officialView.getPanelOfficial_Analytics().getTxtEndYear().getText().equals(""))
				eDate = false;
			if(officialView.getPanelOfficial_Analytics().getTxtEstCode().getText().equals(""))
				estCode = false;
			
			if(sDate && eDate) {
				Date startDate = new Date(Integer.parseInt(officialView.getPanelOfficial_Analytics().getTxtMonth().getText()),Integer.parseInt(officialView.getPanelOfficial_Analytics().getTxtDay().getText()), Integer.parseInt(officialView.getPanelOfficial_Analytics().getTxtYear().getText()));
				Date endDate = new Date(Integer.parseInt(officialView.getPanelOfficial_Analytics().getTxtEndMonth().getText()),Integer.parseInt(officialView.getPanelOfficial_Analytics().getTxtEndDay().getText()), Integer.parseInt(officialView.getPanelOfficial_Analytics().getTxtEndYear().getText()));
				
				if(estCode)
					officialView.getPanelOfficial_Analytics().setLblCases(model.getCurretOfficial().getAnalytics(officialView.getPanelOfficial_Analytics().getTxtEstCode().getText(), startDate, endDate, model.getCitizens(), model.getCases()));
				else
					officialView.getPanelOfficial_Analytics().setLblCases(model.getCurretOfficial().getAnalytics(startDate, endDate, model.getCitizens(), model.getCases()));
			}
			
			if((!sDate || !eDate) && estCode)
				officialView.getPanelOfficial_Analytics().setLblCases(model.getCurretOfficial().getAnalytics(officialView.getPanelOfficial_Analytics().getTxtEstCode().getText(), model.getCitizens(), model.getCases()));
			if(!sDate && !eDate && !estCode)
				officialView.getPanelOfficial_Analytics().Error();
		}
	}
	
	/** The class CaseListener extends MouseAdapter in order to listen for mouse interactions with the unassigned case panel button */
	class CaseListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			officialView.getPanelOfficial_Case().setVisible(true);
			officialView.getPanelOfficial_Update().setVisible(false);
			officialView.getPanelOfficial_Analytics().setVisible(false);
			officialView.getPanelOfficial_Official().setVisible(false);
			officialView.getPanelOfficial_Tracer().setVisible(false);
			officialView.getPanelOfficial_Terminate().setVisible(false);
			officialView.getPanelOfficial_Users().setVisible(false);
			officialView.getPanelOfficial_Case().displayTable(model.getCases());
			officialView.getPanelOfficial_Case().Clear();		// Clears the textfields
		}
	}
	
	/** The class Case_ConfirmListener extends MouseAdapter in order to listen for mouse interactions with the confirm button under the unassigned case panel */
	class Case_ConfirmListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			boolean check = false;
			
			if(officialView.getPanelOfficial_Case().getTxtCaseNum().getText().equals("") && officialView.getPanelOfficial_Case().getTxtTracer().getText().equals(""))
				officialView.getPanelOfficial_Case().Error3();
			else {
				if(Integer.parseInt(officialView.getPanelOfficial_Case().getTxtCaseNum().getText()) <= model.getCases().size() && Integer.parseInt(officialView.getPanelOfficial_Case().getTxtCaseNum().getText()) > 0) {
					for(Tracer tracer: model.getTracers())
						if(officialView.getPanelOfficial_Case().getTxtTracer().getText().equalsIgnoreCase(tracer.getUser().getUsername())) {
							model.getCurretOfficial().assignCase(Integer.parseInt(officialView.getPanelOfficial_Case().getTxtCaseNum().getText()), officialView.getPanelOfficial_Case().getTxtTracer().getText(), model.getCases());
							check = true;
							new TextFiles().CreateCase(model.getCases());				// Updates the PositiveCases.txt file
						}
					if(!check)
						officialView.getPanelOfficial_Case().Error2();
				}
				else
					officialView.getPanelOfficial_Case().Error1();
				officialView.getPanelOfficial_Case().displayTable(model.getCases());
			}
			if(check)
				officialView.getPanelOfficial_Case().Clear();		// Clears the textfields
		}
	}
	
	/** The class OfficialListener extends MouseAdapter in order to listen for mouse interactions with the create official panel button */
	class OfficialListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			officialView.getPanelOfficial_Case().setVisible(false);
			officialView.getPanelOfficial_Update().setVisible(false);
			officialView.getPanelOfficial_Analytics().setVisible(false);
			officialView.getPanelOfficial_Official().setVisible(true);
			officialView.getPanelOfficial_Tracer().setVisible(false);
			officialView.getPanelOfficial_Terminate().setVisible(false);
			officialView.getPanelOfficial_Users().setVisible(false);		
			officialView.getPanelOfficial_Official().remove();		// Clears the textfields
		}
	}
	
	/** The class Official_FocusListener extends FocusAdapter to do certain actions when the official text field is interacted */
	class Official_FocusListener extends FocusAdapter{
		/** This method checks if the text field is being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusGained(FocusEvent e) {
			if(officialView.getPanelOfficial_Official().getTxtUsername().getText().equals("Username")) {
				officialView.getPanelOfficial_Official().getTxtUsername().setText("");
			} else {
				officialView.getPanelOfficial_Official().getTxtUsername().selectAll();
			}
		}
		/** This method checks if the text field is no longer being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusLost(FocusEvent e) {
			if(officialView.getPanelOfficial_Official().getTxtUsername().getText().equals(""))
				officialView.getPanelOfficial_Official().getTxtUsername().setText("Username");
		}
	}
	
	/** The class Official_ConfirmListener extends MouseAdapter in order to listen for mouse interactions with the confirm button under the create official panel */
	class Official_ConfirmListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			Checking check = new Checking();
			
			String enteredUsername = officialView.getPanelOfficial_Official().getTxtUsername().getText();
			int status = model.getCurretOfficial().createOfficial(model.getCitizens(), model.getOfficials(), model.getTracers(), model.getCurretOfficial().getUser().getUsername(), enteredUsername);			
			System.out.println("Enter username: " + enteredUsername + " Status: " + status);		// For checking			
			
			if (enteredUsername.equals("") || enteredUsername.equals("Username")) {
				officialView.getPanelOfficial_Official().Error();
			} else {
				switch (status) {
					case -1:  if (officialView.getPanelOfficial_Official().CreateNew()) {
								String password = check.generatePassword();
								officialView.getPanelOfficial_Official().passwordPopup(password);
									
								User newUser = new User(enteredUsername, password);
								Personal newInfo = new Personal();
								Name name = new Name("none", "none", "none");
								newInfo.setName(name);
								newInfo.setBDay(new Date(9, 28, 2020));		// Default date
		
								Contact newContact = new Contact("none", "none", "none", "none");
								newInfo.setContact(newContact);
								Citizen newCUser = new Citizen(newUser, newInfo, 2);	// Creates the a new official account
								new TextFiles().CreateMasterList(model.getCitizens());	// Updates the MasterList.txt file
								new TextFiles().CreateAccount(newCUser);			// Creates a .act file of the user
								model.getCitizens().add(newCUser);					// Adds the created official into the citizenList
								model.getOfficials().add(new Official(newCUser));	// Adds the created official into the officialList
								
								officialView.getPanelOfficial_Official().remove();
							}
							break;
					case 1: officialView.getPanelOfficial_Official().ErrorCannotCreateOwn(); break;
					case 2: officialView.getPanelOfficial_Official().ErrorTracer();	break;
					case 3: officialView.getPanelOfficial_Official().ErrorOfficial();	break;
					case 4: officialView.getPanelOfficial_Official().Success();	
							new TextFiles().CreateMasterList(model.getCitizens());	// Updates the MasterList.txt file
							break;
				}
			}	
		}
	}
	
	/** The class TracerListener extends MouseAdapter in order to listen for mouse interactions with the create tracer panel button */
	class TracerListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			officialView.getPanelOfficial_Case().setVisible(false);
			officialView.getPanelOfficial_Update().setVisible(false);
			officialView.getPanelOfficial_Analytics().setVisible(false);
			officialView.getPanelOfficial_Official().setVisible(false);
			officialView.getPanelOfficial_Tracer().setVisible(true);
			officialView.getPanelOfficial_Terminate().setVisible(false);
			officialView.getPanelOfficial_Users().setVisible(false);	
			officialView.getPanelOfficial_Tracer().remove();		// Clears the textfields
		}
	}
	
	/** The class Tracer_FocusListener extends FocusAdapter to do certain actions when the tracer text field is interacted */
	class Tracer_FocusListener extends FocusAdapter{
		/** This method checks if the text field is being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusGained(FocusEvent e) {
			if(officialView.getPanelOfficial_Tracer().getTxtUsername().getText().equals("Username")) {
				officialView.getPanelOfficial_Tracer().getTxtUsername().setText("");
			} else {
				officialView.getPanelOfficial_Tracer().getTxtUsername().selectAll();
			}
		}
		/** This method checks if the text field is no longer being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusLost(FocusEvent e) {
			if(officialView.getPanelOfficial_Tracer().getTxtUsername().getText().equals(""))
				officialView.getPanelOfficial_Tracer().getTxtUsername().setText("Username");
		}
	}
	
	/** The class Tracer_ConfirmListener extends MouseAdapter in order to listen for mouse interactions with the confirm button under the create tracer panel */
	class Tracer_ConfirmListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			Checking check = new Checking();
			
			String enteredUsername = officialView.getPanelOfficial_Tracer().getTxtUsername().getText();
			int status = model.getCurretOfficial().createTracer(model.getCitizens(), model.getOfficials(), model.getTracers(), model.getCurretOfficial().getUser().getUsername(), enteredUsername);			
			System.out.println("Enter username: " + enteredUsername + " Status: " + status);		// For checking			
			
			if (enteredUsername.equals("") || enteredUsername.equals("Username")) {
				officialView.getPanelOfficial_Tracer().Error();
			} else {
				switch (status) {
					case -1:  if (officialView.getPanelOfficial_Tracer().CreateNew()) {
								String password = check.generatePassword();
								officialView.getPanelOfficial_Tracer().passwordPopup(password);
									
								User newUser = new User(enteredUsername, password);
								Personal newInfo = new Personal();
								Name name = new Name("none", "none", "none");
								newInfo.setName(name);
								newInfo.setBDay(new Date(9, 28, 2020));		// Default date
		
								Contact newContact = new Contact("none", "none", "none", "none");
								newInfo.setContact(newContact);
								Citizen newCUser = new Citizen(newUser, newInfo, 3);	// Creates a new tracer account
								new TextFiles().CreateMasterList(model.getCitizens());		// Updates the MasterList.txt file
								new TextFiles().CreateAccount(newCUser);		// Creates a .act file of the user
								model.getCitizens().add(newCUser);				// Adds the created tracer into the citizenList
								model.getTracers().add(new Tracer(newCUser));	// Adds the created tracer into the tracerList		
								officialView.getPanelOfficial_Tracer().remove();
							}
							break;
					case 1: officialView.getPanelOfficial_Tracer().ErrorCannotCreateOwn(); break;
					case 2: officialView.getPanelOfficial_Tracer().ErrorOfficial();	break;
					case 3: officialView.getPanelOfficial_Tracer().ErrorTracer();	break;
					case 4: officialView.getPanelOfficial_Tracer().Success();	
							new TextFiles().CreateMasterList(model.getCitizens());	// Updates the MasterList.txt file
							break;
				}
			}	
		}
	}
	
	/** The class TerminateListener extends MouseAdapter in order to listen for mouse interactions with the terminate account panel button */
	class TerminateListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			officialView.getPanelOfficial_Case().setVisible(false);
			officialView.getPanelOfficial_Update().setVisible(false);
			officialView.getPanelOfficial_Analytics().setVisible(false);
			officialView.getPanelOfficial_Official().setVisible(false);
			officialView.getPanelOfficial_Tracer().setVisible(false);
			officialView.getPanelOfficial_Terminate().setVisible(true);
			officialView.getPanelOfficial_Users().setVisible(false);		
			officialView.getPanelOfficial_Terminate().remove();		// Clears the textfields
		}
	}
	
	/** The class Terminate_FocusListener extends FocusAdapter to do certain actions when the terminate text field is interacted */
	class Terminate_FocusListener extends FocusAdapter{
		/** This method checks if the text field is being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusGained(FocusEvent e) {
			if(officialView.getPanelOfficial_Terminate().getTxtUsername().getText().equals("Username")) {
				officialView.getPanelOfficial_Terminate().getTxtUsername().setText("");
			} else {
				officialView.getPanelOfficial_Terminate().getTxtUsername().selectAll();
			}
		}
		/** This method checks if the text field is no longer being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusLost(FocusEvent e) {
			if(officialView.getPanelOfficial_Terminate().getTxtUsername().getText().equals(""))
				officialView.getPanelOfficial_Terminate().getTxtUsername().setText("Username");
		}
	}
	
	/** The class Terminate_ConfirmListener extends MouseAdapter in order to listen for mouse interactions with the confirm button under the terminate user panel */
	class Terminate_ConfirmListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			String terminateUser = officialView.getPanelOfficial_Terminate().getTxtUsername().getText();
			int status = model.getCurretOfficial().terminateAccount(model.getCitizens(), model.getOfficials(), model.getTracers(), model.getCurretOfficial().getUser().getUsername(), terminateUser);
		
			if (terminateUser.equals("") || terminateUser.equals("Username")) {
				officialView.getPanelOfficial_Terminate().Error();
			} else if (status == -1) {
				officialView.getPanelOfficial_Terminate().ErrorNotFound();
			} else if (status == 1) {
				officialView.getPanelOfficial_Terminate().ErrorCannotTerminateOwn();
			} else if (status == 2) {
				officialView.getPanelOfficial_Terminate().Success();
				new TextFiles().CreateMasterList(model.getCitizens());		// Updates the MasterList.txt file
			} else if (status == 3)  {
				officialView.getPanelOfficial_Terminate().ErrorCannotTerminateCitizen();
			}
		}
	}
	
	/** The class UpdateListener extends MouseAdapter in order to listen for mouse interactions with the contact tracing update panel button */
	class UpdateListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			officialView.getPanelOfficial_Case().setVisible(false);
			officialView.getPanelOfficial_Update().setVisible(true);
			officialView.getPanelOfficial_Analytics().setVisible(false);
			officialView.getPanelOfficial_Official().setVisible(false);
			officialView.getPanelOfficial_Tracer().setVisible(false);
			officialView.getPanelOfficial_Terminate().setVisible(false);
			officialView.getPanelOfficial_Users().setVisible(false);
			officialView.getPanelOfficial_Update().remove();		// Clears the textfields
		}
	}
	
	/** The class Update_ConfirmListener extends MouseAdapter in order to listen for mouse interactions with the confirm button under the contact tracing update panel */
	class Update_ConfirmListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			
			boolean sDate = true, eDate = true;

			if(officialView.getPanelOfficial_Update().getTxtMonth().getText().equals("") || officialView.getPanelOfficial_Update().getTxtDay().getText().equals("") || officialView.getPanelOfficial_Update().getTxtYear().getText().equals(""))
				sDate = false;
			if(officialView.getPanelOfficial_Update().getTxtEndMonth().getText().equals("") || officialView.getPanelOfficial_Update().getTxtEndDay().getText().equals("") || officialView.getPanelOfficial_Update().getTxtEndYear().getText().equals(""))
				eDate = false;
			
			if(sDate && eDate) {
				Date startDate = new Date(Integer.parseInt(officialView.getPanelOfficial_Update().getTxtMonth().getText()),Integer.parseInt(officialView.getPanelOfficial_Update().getTxtDay().getText()), Integer.parseInt(officialView.getPanelOfficial_Update().getTxtYear().getText()));
				Date endDate = new Date(Integer.parseInt(officialView.getPanelOfficial_Update().getTxtEndMonth().getText()),Integer.parseInt(officialView.getPanelOfficial_Update().getTxtEndDay().getText()), Integer.parseInt(officialView.getPanelOfficial_Update().getTxtEndYear().getText()));
				
				officialView.getPanelOfficial_Update().displayTable(model.getCurretOfficial().showUpdates(model.getCases(), startDate, endDate));
			}
			else
				officialView.getPanelOfficial_Update().Error();
		}
	}
	
	/** The class UserListener extends MouseAdapter in order to listen for mouse interactions with the show all users panel button */
	class UsersListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			officialView.getPanelOfficial_Case().setVisible(false);
			officialView.getPanelOfficial_Update().setVisible(false);
			officialView.getPanelOfficial_Analytics().setVisible(false);
			officialView.getPanelOfficial_Official().setVisible(false);
			officialView.getPanelOfficial_Tracer().setVisible(false);
			officialView.getPanelOfficial_Terminate().setVisible(false);
			officialView.getPanelOfficial_Users().setVisible(true);		
			officialView.getPanelOfficial_Users().displayTable(model.getCitizens());
		}
	}
	
	/** The class LogOutListener extends MouseAdapter in order to listen for mouse interactions with the log out button */
	class LogOutListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			RoleSelection_View roleSelectView = new RoleSelection_View();
			RoleSelection_Controller roleSelectControl = new RoleSelection_Controller(model, roleSelectView);
			roleSelectControl.getRoleSelectView().setVisible(true);
			officialView.dispose();
		}
	}
	
	/** This method returns the officialView of the controller
	 * 
	 * @return officialView the visual aspects of the official menu */
	public LoggedIn_Official_View getOfficialView() {
		return officialView;
	}
	
	/** The data being passed between controllers */
	private Model model;
	/** The visual aspect of the official menu */
	private LoggedIn_Official_View officialView;
}
