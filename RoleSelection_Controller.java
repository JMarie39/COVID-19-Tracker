import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/** The class RoleSelection_Controller represents the controller that manipulates the roleSelectView and the model.	*/
public class RoleSelection_Controller {
	
	/**	This constructor initializes the model and roleSelectView, based on the parameters.
	 * 
	 * @param model The data being passed between controllers
	 * @param roleSelectView The interactive visual aspect of the role menu */
	public RoleSelection_Controller(Model model, RoleSelection_View roleSelectView) {
		this.roleSelectView = roleSelectView;
		this.model = model;
		
		this.roleSelectView.addOfficialListener(new OfficialListener());
		this.roleSelectView.addTracerListener(new TracerListener());
		this.roleSelectView.addCitizenListener(new CitizenListener());
		this.roleSelectView.addExitListener(new ExitListener());
	}
	
	/** The class OfficialListener extends MouseAdapter in order to listen for mouse interactions with the official button */
	class OfficialListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			if (model.getCurretOfficial() instanceof Official) {
				LoggedIn_Official_View officialView = new LoggedIn_Official_View();
				officialControl = new LoggedIn_Official_Controller(model, officialView);
				officialControl.getOfficialView().setVisible(true);
				roleSelectView.dispose();
			}  else roleSelectView.Error();
		}
	}
	
	/** The class TracerListener extends MouseAdapter in order to listen for mouse interactions with the tracer button */
	class TracerListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			if (model.getCurretTracer() instanceof Tracer) {
				LoggedIn_Tracer_View tracerView = new LoggedIn_Tracer_View();
				tracerControl = new LoggedIn_Tracer_Controller(model, tracerView);
				tracerControl.getTracerView().setVisible(true);
				roleSelectView.dispose();
			} else roleSelectView.Error();
		}
	}

	/** The class CitizenListener extends MouseAdapter in order to listen for mouse interactions with the citizen button */
	class CitizenListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			if (model.getCurretCitizen() instanceof Citizen) {
				LoggedIn_Citizen_View citizenView = new LoggedIn_Citizen_View();
				citizenControl = new LoggedIn_Citizen_Controller(model, citizenView);
				citizenControl.getCitizenView().setVisible(true);
				roleSelectView.dispose();
			} else roleSelectView.Error();
		}
	}

	/** The class ExitListener extends MouseAdapter in order to listen for mouse interactions with the exit button */
	class ExitListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			SignIn_View signInView = new SignIn_View();
			SignIn_Controller controller = new SignIn_Controller(model, signInView);
			signInView.setVisible(true);
			roleSelectView.dispose();
		}
	}
	
	/** This method returns the roleSelectView of the controller
	 * 
	 * @return roleSelectView the visual aspect of the role selection menu*/
	public RoleSelection_View getRoleSelectView() {
		return roleSelectView;
	}
	
	/** The data being passed between controllers */
	private Model model;
	/** The visual aspect of the role selection menu */
	private RoleSelection_View roleSelectView;
	/** The controller of the citizen menu */
	private LoggedIn_Citizen_Controller citizenControl;
	/** The contoller of the tracer menu */
	private LoggedIn_Tracer_Controller tracerControl;
	/** The controller of the official menu */
	private LoggedIn_Official_Controller officialControl;
}
