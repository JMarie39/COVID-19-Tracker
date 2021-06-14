import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/** The class LoggedIn_Tracer_Controller represents the controller that manipulates the tracerView and the model.	*/
public class LoggedIn_Tracer_Controller {
	
	/**	This constructor initializes the model and tracerView, based on the parameters.
	 * 
	 * @param model The data being passed between controllers
	 * @param tracerView The interactive visual aspect of the tracer menu */
	public LoggedIn_Tracer_Controller(Model model, LoggedIn_Tracer_View tracerView) {
		this.model = model;
		this.tracerView = tracerView;
		
		this.tracerView.showUsername(model.getCurretTracer().getUser().getUsername());
		this.tracerView.getPanelTracer_ShowCase().displayTable(model.getCurretTracer().showCases(model.getCurretTracer().getUser().getUsername(), model.getCases()));
		
		this.tracerView.addShowCaseListener(new ShowCaseListener());
		this.tracerView.addTraceCaseListener(new TraceCaseListener());
		this.tracerView.addInformListener(new InformListener());
		this.tracerView.addLogOutListener(new LogOutListener());
		
		this.tracerView.getPanelTracer_TraceCase().addConfirmListener(new TraceCase_ConfirmListener());
		this.tracerView.getPanelTracer_Inform().addConfirmListener(new Inform_ConfirmListener());
	}
	
	/** The class ShowCaseListener extends MouseAdapter in order to listen for mouse interactions with the show assigned case panel button */
	class ShowCaseListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			tracerView.getPanelTracer_Inform().setVisible(false);
			tracerView.getPanelTracer_ShowCase().setVisible(true);
			tracerView.getPanelTracer_TraceCase().setVisible(false);
			tracerView.getPanelTracer_ShowCase().displayTable(model.getCurretTracer().showCases(model.getCurretTracer().getUser().getUsername(), model.getCases()));
		}
	}
	
	/** The class TraceCaseListener extends MouseAdapter in order to listen for mouse interactions with the trace specific case panel button */
	class TraceCaseListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			tracerView.getPanelTracer_Inform().setVisible(false);
			tracerView.getPanelTracer_ShowCase().setVisible(false);
			tracerView.getPanelTracer_TraceCase().setVisible(true);
			tracerView.getPanelTracer_TraceCase().remove();		// Clears the textfields
		}
	}
	
	/** The class TraceCase_ConfirmListener extends MouseAdapter in order to listen for mouse interactions with the confirm button under trace specific case panel */
	class TraceCase_ConfirmListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			ArrayList<Case> cases = new ArrayList<Case>();
			String user;
			boolean check = false;
			int i;
			overlap = new ArrayList<VisitRecord>();		
			
			if(!tracerView.getPanelTracer_TraceCase().getTxtCaseNum().getText().equals("")) {
				cases = model.getCurretTracer().showCases(model.getCurretTracer().getUser().getUsername(), model.getCases());
				for(Case c : cases)
					if(Integer.parseInt(tracerView.getPanelTracer_TraceCase().getTxtCaseNum().getText()) == c.getCaseNum())
						check = true;
				if(check) {
					user = model.getCases().get(Integer.parseInt(tracerView.getPanelTracer_TraceCase().getTxtCaseNum().getText())-1).getUser();
				for(i = 0; i < model.getCitizens().size(); i++)
					if(model.getCitizens().get(i).getUser().getUsername().equals(user)) {
						traced = true;
						overlap = model.getOverlap(model.getCitizens().get(i).visitRecord);
						tracerView.getPanelTracer_TraceCase().displayTable(model.getOverlap(model.getCitizens().get(i).visitRecord));
					}
				}
				else
					tracerView.getPanelTracer_TraceCase().Error2();
			}
			else
				tracerView.getPanelTracer_TraceCase().Error();
		}
	}
	
	/** The class InformListener extends MouseAdapter in order to listen for mouse interactions with the inform citizens panel button */
	class InformListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			tracerView.getPanelTracer_Inform().setVisible(true);
			tracerView.getPanelTracer_ShowCase().setVisible(false);
			tracerView.getPanelTracer_TraceCase().setVisible(false);
		}
	}
	
	/** The class Inform_ConfirmListener extends MouseAdapter in order to listen for mouse interactions with the confirm button under inform citizens panel */
	class Inform_ConfirmListener extends MouseAdapter{
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			int i, j;
			if(traced)
				for(i = 0; i < overlap.size(); i++) {
					for(j = 0; j < model.getCitizens().size(); j++)
						if(model.getCitizens().get(j).getUser().getUsername().equals(overlap.get(i).getUsername())) {
							model.getCitizens().get(j).isInformed();
							model.getCitizens().get(j).getNoticeInfo().setExposedDate(overlap.get(i).getDate().toString());
							model.getCitizens().get(j).getNoticeInfo().setExposedEstablishment(overlap.get(i).getCode());
							for(Case c : model.getCases())
								if(c.getUser().equals(model.getCitizens().get(j).getUser().getUsername())) {
									c.setStatus('T');
								}
							tracerView.getPanelTracer_Inform().inform(); //displays a popup message that says that the users have been informed
							traced = false;
							new TextFiles().CreateCase(model.getCases());				// Updates the PositiveCases.txt file
						}
				}
			else
				tracerView.getPanelTracer_Inform().notTraced();
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
			tracerView.dispose();		
		}
	}
	
	/** This method returns the tracerView of the controller
	 * 
	 * @return tracerView the visual aspects of the tracer menu */
	public LoggedIn_Tracer_View getTracerView() {
		return tracerView;
	}
	
	/** The data being passed between controllers */
	private Model model;
	/** The visual aspects of the tracer menu */
	private LoggedIn_Tracer_View tracerView;
	/** The array list of visit records that overlap with the case being handled */
	private ArrayList<VisitRecord> overlap;
	/** The boolean variable that checks whether or not a case has been traced */
	private boolean traced = false;
}