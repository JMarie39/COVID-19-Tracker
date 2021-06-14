import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/** The SignIn_Controller is the class that manipulates the model and the signInView */
public class SignIn_Controller {
	
	/** The constructor initializes the model and the signInView, based on the given parameters
	 * 
	 * @param model the data being passed between controllers
	 * @param signInView the GUI for the sign in menu */
	public SignIn_Controller(Model model, SignIn_View signInView) {
		this.model = model;
		this.signInView = signInView;
		
		RoleSelection_View roleSelectView = new RoleSelection_View();
		this.roleSelectControl = new RoleSelection_Controller(model, roleSelectView);
		CreateAccount_View createView = new CreateAccount_View();
		this.createControl = new CreateAccount_Controller(model, createView);
		
		this.signInView.addSignInListener(new SignInListener());
		this.signInView.addSignUpListener(new SignUpListener());
		this.signInView.addExitListener(new ExitListener());
		
		this.signInView.addUsernameListener(new UsernameFocusListener());
		this.signInView.addPasswordListener(new PasswordFocusListener());
	}
	
	/** The class UsernameFocusListener extends FocusAdapter to do certain actions when the username text field is interacted */
	class UsernameFocusListener extends FocusAdapter{
		/** This method checks if the text field is being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusGained(FocusEvent e) {
			if(signInView.getTxtUsername().getText().equals("Username")) {
				signInView.getTxtUsername().setText("");
			} else {
				signInView.getTxtUsername().selectAll();
			}
		}
		/** This method checks if the text field is no longer being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusLost(FocusEvent e) {
			if(signInView.getTxtUsername().getText().equals(""))
				signInView.getTxtUsername().setText("Username");
		}
	}
	
	/** The class PasswordFocusListener extends FocusAdapter to do certain actions when the password text field is interacted */
	class PasswordFocusListener extends FocusAdapter{
		/** This method checks if the text field is being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@SuppressWarnings("deprecation")
		@Override
		public void focusGained(FocusEvent e) {
			if(signInView.getTxtPassword().getText().equals("Password")) {
				signInView.getTxtPassword().setEchoChar('*');
				signInView.getTxtPassword().setText("");
			} else {
				signInView.getTxtPassword().selectAll();
			}
		}
		/** This method checks if the text field is no longer being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@SuppressWarnings("deprecation")
		@Override
		public void focusLost(FocusEvent e) {
			if(signInView.getTxtPassword().getText().equals("")) {
				signInView.getTxtPassword().setText("Password");
				signInView.getTxtPassword().setEchoChar((char)0);
			}				
		}
	}
	
	/** The class SignInListener extends MouseAdapter in order to listen for mouse interactions with the sign in button */
	class SignInListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			String username = signInView.getUsername();
			String password = signInView.getPassword();
			
			if(model.signIn(username, password)) {
				signInView.Success();
				roleSelectControl.getRoleSelectView().setVisible(true);			
				signInView.dispose();
				System.out.println("\nUser logged in: " + model.getLoggedInUser());		// For checking
			} else if(username.equals("") || username.equals("Username") || password.equals("") || password.equals("Password"))
				signInView.Error1();
			else
				signInView.Error2();
		}
	}
	
	/** The class ExitListener extends MouseAdapter in order to listen for mouse interactions with the exit button */
	class ExitListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			if(signInView.Confirmation()) {
				new TextFiles().CreateMasterList(model.getCitizens());		// Creates the MasterList.txt file
				new TextFiles().CreateEVR(model.getCitizens());				// Creates the EstablishmentVisitRecord.txt file
				new TextFiles().CreateCase(model.getCases());				// Create the PositiveCases.txt file
				signInView.dispose();
			}
		}
	}
	
	/** The class SignUpListener extends MouseAdapter in order to listen for mouse interactions with the sign up button */
	class SignUpListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			createControl.getCreateAccountView().setVisible(true);
			signInView.dispose();
		}
	}
	
	/** The data being passed between controllers */
	private Model model;
	/** The visual aspect of the sign in menu */
	private SignIn_View signInView;
	/** The controller for the role selection menu */
	private RoleSelection_Controller roleSelectControl;
	/** The controller for the sign up menu */
	private CreateAccount_Controller createControl;
}