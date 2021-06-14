import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/** The class CreateAccount_Controller represents the controller that manipulates the createView and the model.	*/
public class CreateAccount_Controller {

	/** This constructor initializes the model and the createView, based on the given parameters.
	 * 
	 * @param model the essential data that is passed from controller to controller.
	 * @param createView the interactive visual aspect for creating an account. */
	public CreateAccount_Controller(Model model, CreateAccount_View createView) {
		this.model = model;
		this.createView = createView;
		
		this.createView.addBackListener(new BackListener());
		this.createView.addConfirmListener(new ConfirmListener());
	}
	
	/** The class BackListener extends the MouseAdapter in order to listen for mouse interactions with the back button in the createView */
	class BackListener extends MouseAdapter {
		
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			SignIn_View signInView = new SignIn_View();
			SignIn_Controller controller = new SignIn_Controller(model, signInView);
			signInView.setVisible(true);
			createView.dispose();
		}
	}
	
	/** The class ConfirmListener extends the MouseAdapter in order to listen for mouse interactions with the confirm button in the createView */
	class ConfirmListener extends MouseAdapter {
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * 	@param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			SignIn_View signInView = new SignIn_View();
			SignIn_Controller controller = new SignIn_Controller(model, signInView);		
		
			Checking check = new Checking();
			boolean checkUsername = check.isValidCUsername(model.getCitizens(), createView.getTxtUsername().getText());
			boolean checkPass = check.isValidPassword(createView.getTxtPassword().getText());
			
			Personal info = new Personal();	// Personal information
			User user = new User(createView.getTxtUsername().getText(), createView.getTxtPassword().getText());
			Name name = new Name(createView.getTxtFirst().getText(), createView.getTxtMiddle().getText(), createView.getTxtLast().getText());
			Contact contact = new Contact(createView.getTxtHome().getText(), createView.getTxtOffice().getText(), createView.getTxtPhone().getText(), createView.getTxtEmail().getText());	// contact information
			Date BDate = check.enterDate(createView.getTxtMonth().getText(), createView.getTxtDay().getText(), createView.getTxtYear().getText());
			
			info.setName(name);
			info.setBDay(BDate);
			info.setContact(contact);

			Citizen citizen = new Citizen(user, info); 
			
			if (createView.getTxtUsername().getText().equals("") || createView.getTxtPassword().getText().equals("") || 
					createView.getTxtFirst().getText().equals("") || createView.getTxtMiddle().getText().equals("") || createView.getTxtLast().getText().equals("") ||
					createView.getTxtHome().getText().equals("") || createView.getTxtOffice().getText().equals("") || createView.getTxtPhone().getText().equals("") || createView.getTxtEmail().getText().equals("") ||
					createView.getTxtMonth().getText().equals("") || createView.getTxtDay().getText().equals("") || createView.getTxtYear().getText().equals("")) {
						createView.Error1();
			} else if (checkUsername) {
				createView.ErrorUsername();
			} else if (checkPass) {
				createView.ErrorPassword();
			} else if (BDate == null) {
				createView.Error2();
			} else if (!checkUsername &&  !checkPass && BDate != null) {
				model.getCitizens().add(citizen);
				new TextFiles().CreateMasterList(model.getCitizens());		// Updates the MasterList.txt file
				new TextFiles().CreateAccount(citizen);						// Creates the .act file of the user
				signInView.setVisible(true);
				createView.dispose();
			}
		}
	}
	
	/** This method returns the createView of the controller
	 * 
	 * @return createView the visual aspects for creating an account */
	public CreateAccount_View getCreateAccountView() {
		return createView;
	}
	
	/** The data being passed between controllers */
	private Model model;
	/** The visual aspects for creating an account */
	private CreateAccount_View createView;
}
