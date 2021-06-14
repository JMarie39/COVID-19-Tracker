import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
/** The class LoggedIn_Citizen_Controller represents the controller that manipulates the citizenView and the model.	*/
public class LoggedIn_Citizen_Controller {

	/** This constructor initializes the model and citizenView, based on the parameters.
	 * 
	 * @param model The data being passed between controllers
	 * @param citizenView The interactive visual aspect of the citizen menu	*/
	public LoggedIn_Citizen_Controller(Model model, LoggedIn_Citizen_View citizenView) {
		this.model = model;
		this.citizenView = citizenView;
		
		this.citizenView.showUsername(model.getCurretCitizen().getUser().getUsername());
		
		if(this.model.getCurretCitizen().getNotice())
			this.citizenView.notice(this.model.getCurretCitizen().getNoticeInfo().getExposedEstablishment(), this.model.getCurretCitizen().getNoticeInfo().getExposedDate());
		
		this.citizenView.addCheckInListener(new CheckInListener());
		this.citizenView.addProfileListener(new ProfileListener());
		this.citizenView.addReportListener(new ReportListener());
		this.citizenView.addVisitRecordListener(new VisitRecordListener());
		this.citizenView.addLogOutListener(new LogOutListener());
		
		this.citizenView.getPanelCitizen_CheckIn().addConfirmListener(new CheckIn_ConfirmListener());
		this.citizenView.getPanelCitizen_Report().addConfirmListener(new Report_ConfirmListener());
		this.citizenView.getPanelCitizen_Profile().addConfirmListener(new Update_ConfirmListener());
		
		this.citizenView.getPanelCitizen_Profile().fNameListener(new Profile_fNameListener());
		this.citizenView.getPanelCitizen_Profile().mNameListener(new Profile_mNameListener());
		this.citizenView.getPanelCitizen_Profile().sNameListener(new Profile_sNameListener());
		this.citizenView.getPanelCitizen_Profile().dMonthListener(new Profile_dMonthListener());
		this.citizenView.getPanelCitizen_Profile().dDayListener(new Profile_dDayListener());
		this.citizenView.getPanelCitizen_Profile().dYearListener(new Profile_dYearListener());
		this.citizenView.getPanelCitizen_Profile().homeListener(new Profile_homeListener());
		this.citizenView.getPanelCitizen_Profile().officeListener(new Profile_officeListener());
		this.citizenView.getPanelCitizen_Profile().phoneListener(new Profile_phoneListener());
		this.citizenView.getPanelCitizen_Profile().emailListener(new Profile_emailListener());
		this.citizenView.getPanelCitizen_Profile().passwordListener(new Profile_passwordListener());
		
		this.citizenView.getPanelCitizen_Profile().showUsername(model.getCurretCitizen().getUser().getUsername());
		this.citizenView.getPanelCitizen_Profile().getTxtPassword().setText(model.getCurretCitizen().getUser().getPassword());
		this.citizenView.getPanelCitizen_Profile().getTxtFirst().setText(model.getCurretCitizen().getPersonal().getName().getFirstName());
		this.citizenView.getPanelCitizen_Profile().getTxtMiddle().setText(model.getCurretCitizen().getPersonal().getName().getMiddleName());
		this.citizenView.getPanelCitizen_Profile().getTxtSurname().setText(model.getCurretCitizen().getPersonal().getName().getSurName());
		this.citizenView.getPanelCitizen_Profile().getTxtMonth().setText(Integer.toString(model.getCurretCitizen().getPersonal().getDate().getMonth()));
		this.citizenView.getPanelCitizen_Profile().getTxtDay().setText(Integer.toString(model.getCurretCitizen().getPersonal().getDate().getDay()));
		this.citizenView.getPanelCitizen_Profile().getTxtYear().setText(Integer.toString(model.getCurretCitizen().getPersonal().getDate().getYear()));
		this.citizenView.getPanelCitizen_Profile().getTxtHome().setText(model.getCurretCitizen().getPersonal().getContact().getHome());
		this.citizenView.getPanelCitizen_Profile().getTxtOffice().setText(model.getCurretCitizen().getPersonal().getContact().getOffice());
		this.citizenView.getPanelCitizen_Profile().getTxtPhone().setText(model.getCurretCitizen().getPersonal().getContact().getPhone());
		this.citizenView.getPanelCitizen_Profile().getTxtEmail().setText(model.getCurretCitizen().getPersonal().getContact().getEmail());	
	}
	
	/** The class CheckInListener extends MouseAdapter in order to listen for mouse interactions with the Check-in panel */
	class CheckInListener extends MouseAdapter {
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			citizenView.getPanelCitizen_CheckIn().setVisible(true);
			citizenView.getPanelCitizen_Report().setVisible(false);
			citizenView.getPanelCitizen_VisitRecord().setVisible(false);
			citizenView.getPanelCitizen_Profile().setVisible(false);
			checkIn = false;
			citizenView.getPanelCitizen_CheckIn().remove();		// Clears the textfields
		}
	}
	
	/** The class CheckIn_ConfirmListener extends MouseAdapter in order to listen for mouse interactions with the Check-in confirm button */
	class CheckIn_ConfirmListener extends MouseAdapter {
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			Checking check = new Checking();

			LocalTime now = LocalTime.now();
			int time = now.getHour() * 100 + now.getMinute();
			Date date = check.enterDate(citizenView.getPanelCitizen_CheckIn().getTxtMonth().getText(), citizenView.getPanelCitizen_CheckIn().getTxtDay().getText(), citizenView.getPanelCitizen_CheckIn().getTxtYear().getText());
			
			if (citizenView.getPanelCitizen_CheckIn().getTxtEstCode().getText().equals("") || citizenView.getPanelCitizen_CheckIn().getTxtMonth().getText().equals("") ||
					citizenView.getPanelCitizen_CheckIn().getTxtMonth().getText().equals("") || citizenView.getPanelCitizen_CheckIn().getTxtYear().getText().equals("")) {			
				citizenView.getPanelCitizen_CheckIn().Error1();
			} else if (date == null) {
				citizenView.getPanelCitizen_CheckIn().Error2();
			} else if (!citizenView.getPanelCitizen_CheckIn().getTxtEstCode().getText().equals("") && date != null) {
				citizenView.getPanelCitizen_CheckIn().Success();
				citizenView.getPanelCitizen_CheckIn().timePopup(time);
				checkIn = true;
				model.getCurretCitizen().checkIn(citizenView.getPanelCitizen_CheckIn().getTxtEstCode().getText(), date, time);
				new TextFiles().CreateEVR(model.getCitizens());				// Updates the EstablishmentVisitRecord.txt file
				System.out.println("Checked in at " + citizenView.getPanelCitizen_CheckIn().getTxtEstCode().getText() + ", " + time);		
			}
		}
	}
	
	/** The class ProfileListener extends MouseAdapter in order to listen for mouse interactions with the Profile panel */
	class ProfileListener extends MouseAdapter {
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			citizenView.getPanelCitizen_CheckIn().setVisible(false);
			citizenView.getPanelCitizen_Report().setVisible(false);
			citizenView.getPanelCitizen_VisitRecord().setVisible(false);
			citizenView.getPanelCitizen_Profile().setVisible(true);
		}
	}
	
	/** The class ReportListener extends MouseAdapter in order to listen for mouse interactions with the Report positive panel */
	class ReportListener extends MouseAdapter {
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			citizenView.getPanelCitizen_CheckIn().setVisible(false);
			citizenView.getPanelCitizen_Report().setVisible(true);
			citizenView.getPanelCitizen_VisitRecord().setVisible(false);
			citizenView.getPanelCitizen_Profile().setVisible(false);
			citizenView.getPanelCitizen_Report().remove();		// Clears the textfields
		}
	}
	
	/** The class Report_ConfirmListener extends MouseAdapter in order to listen for mouse interactions with the Report positive confirm button */
	class Report_ConfirmListener extends MouseAdapter {
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			Checking check = new Checking();
			
			Date reportDate = check.enterDate(citizenView.getPanelCitizen_Report().getTxtMonth().getText(), citizenView.getPanelCitizen_Report().getTxtDay().getText(), citizenView.getPanelCitizen_Report().getTxtYear().getText());
			
			if (citizenView.getPanelCitizen_Report().getTxtMonth().getText().equals("") || citizenView.getPanelCitizen_Report().getTxtDay().getText().equals("") || 
					citizenView.getPanelCitizen_Report().getTxtYear().getText().equals("")) {
				citizenView.getPanelCitizen_Report().Error1();
			} else if (reportDate == null) {
				citizenView.getPanelCitizen_Report().Error2();
			} else if (reportDate != null) {
				citizenView.getPanelCitizen_Report().Success();
				model.getCurretCitizen().reportPositive(model.getCases(), reportDate);
				new TextFiles().CreateCase(model.getCases());				// Updates the PositiveCases.txt file
				System.out.println("Reported positive.");			
			}
		}
	}
	
	/** The class VisitRecordListener extends MouseAdapter in order to listen for mouse interactions with the Visit record panel */
	class VisitRecordListener extends MouseAdapter {
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			citizenView.getPanelCitizen_CheckIn().setVisible(false);
			citizenView.getPanelCitizen_Report().setVisible(false);
			citizenView.getPanelCitizen_VisitRecord().setVisible(true);
			citizenView.getPanelCitizen_Profile().setVisible(false);
			citizenView.getPanelCitizen_VisitRecord().displayTable(model.getCurretCitizen().visitRecord);
		}
	}
	
	/** The class Profile_passwordListener extends FocusAdapter to do certain actions when the password text field is interacted */
	class Profile_passwordListener extends FocusAdapter{		// Password focus listener 
		/** This method checks if the text field is being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusGained(FocusEvent e) {
			if(citizenView.getPanelCitizen_Profile().getTxtPassword().getText().equals(model.getCurretCitizen().getUser().getPassword())) {
				citizenView.getPanelCitizen_Profile().getTxtPassword().setText("");
			} else {
				citizenView.getPanelCitizen_Profile().getTxtPassword().selectAll();
			}
		}
		/** This method checks if the text field is no longer being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusLost(FocusEvent e) {
			if(citizenView.getPanelCitizen_Profile().getTxtPassword().getText().equals(""))
				citizenView.getPanelCitizen_Profile().getTxtPassword().setText(model.getCurretCitizen().getUser().getPassword());
		}
	}
	
	/** The class Profile_fNameListener extends FocusAdapter to do certain actions when the first name text field is interacted */
	class Profile_fNameListener extends FocusAdapter{			// First name focus listener 
		/** This method checks if the text field is being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusGained(FocusEvent e) {
			if(citizenView.getPanelCitizen_Profile().getTxtFirst().getText().equals(model.getCurretCitizen().getPersonal().getName().getFirstName())) {
				citizenView.getPanelCitizen_Profile().getTxtFirst().setText("");
			} else {
				citizenView.getPanelCitizen_Profile().getTxtFirst().selectAll();
			}
		}
		/** This method checks if the text field is no longer being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusLost(FocusEvent e) {
			if(citizenView.getPanelCitizen_Profile().getTxtFirst().getText().equals(""))
				citizenView.getPanelCitizen_Profile().getTxtFirst().setText(model.getCurretCitizen().getPersonal().getName().getFirstName());
		}
	}
	
	/** The class Profile_mNameListener extends FocusAdapter to do certain actions when the middle name text field is interacted */
	class Profile_mNameListener extends FocusAdapter {		// Middle name focus listener 
		/** This method checks if the text field is being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusGained(FocusEvent e) {
			if(citizenView.getPanelCitizen_Profile().getTxtMiddle().getText().equals(model.getCurretCitizen().getPersonal().getName().getMiddleName())) {
				citizenView.getPanelCitizen_Profile().getTxtMiddle().setText("");
			} else {
				citizenView.getPanelCitizen_Profile().getTxtMiddle().selectAll();
			}
		}
		/** This method checks if the text field is no longer being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusLost(FocusEvent e) {
			if(citizenView.getPanelCitizen_Profile().getTxtMiddle().getText().equals(""))
				citizenView.getPanelCitizen_Profile().getTxtMiddle().setText(model.getCurretCitizen().getPersonal().getName().getMiddleName());
		}
	}
	
	/** The class Profile_sNameListener extends FocusAdapter to do certain actions when the surname text field is interacted */
	class Profile_sNameListener extends FocusAdapter{		// Surname focus listener 
		/** This method checks if the text field is being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusGained(FocusEvent e) {
			if(citizenView.getPanelCitizen_Profile().getTxtSurname().getText().equals(model.getCurretCitizen().getPersonal().getName().getSurName())) {
				citizenView.getPanelCitizen_Profile().getTxtSurname().setText("");
			} else {
				citizenView.getPanelCitizen_Profile().getTxtSurname().selectAll();
			}
		}
		/** This method checks if the text field is no longer being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusLost(FocusEvent e) {
			if(citizenView.getPanelCitizen_Profile().getTxtSurname().getText().equals(""))
				citizenView.getPanelCitizen_Profile().getTxtSurname().setText(model.getCurretCitizen().getPersonal().getName().getSurName());
		}
	}
	
	/** The class Profile_dMonthListener extends FocusAdapter to do certain actions when the month text field is interacted */
	class Profile_dMonthListener extends FocusAdapter{		// Birth month focus listener 
		/** This method checks if the text field is being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusGained(FocusEvent e) {
			
			if(citizenView.getPanelCitizen_Profile().getTxtMonth().getText().equals(Integer.toString(model.getCurretCitizen().getPersonal().getDate().getMonth()))) {
				citizenView.getPanelCitizen_Profile().getTxtMonth().setText("");
			} else {
				citizenView.getPanelCitizen_Profile().getTxtMonth().selectAll();
			}
		}
		/** This method checks if the text field is no longer being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusLost(FocusEvent e) {
			if(citizenView.getPanelCitizen_Profile().getTxtMonth().getText().equals(""))
				citizenView.getPanelCitizen_Profile().getTxtMonth().setText(String.valueOf(model.getCurretCitizen().getPersonal().getDate().getMonth()));
		}
	}
	
	/** The class Profile_dDayListener extends FocusAdapter to do certain actions when the day text field is interacted */
	class Profile_dDayListener extends FocusAdapter{		// Birth day focus listener 
		/** This method checks if the text field is being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusGained(FocusEvent e) {
			if(citizenView.getPanelCitizen_Profile().getTxtDay().getText().equals(Integer.toString(model.getCurretCitizen().getPersonal().getDate().getDay()))) {
				citizenView.getPanelCitizen_Profile().getTxtDay().setText("");
			} else {
				citizenView.getPanelCitizen_Profile().getTxtDay().selectAll();
			}
		}
		/** This method checks if the text field is no longer being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusLost(FocusEvent e) {
			if(citizenView.getPanelCitizen_Profile().getTxtDay().getText().equals(""))
				citizenView.getPanelCitizen_Profile().getTxtDay().setText(String.valueOf(model.getCurretCitizen().getPersonal().getDate().getDay()));
		}
	}
	
	/** The class Profile_dYearListener extends FocusAdapter to do certain actions when the year text field is interacted */
	class Profile_dYearListener extends FocusAdapter{		// Birth year focus listener 
		/** This method checks if the text field is being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusGained(FocusEvent e) {
			if(citizenView.getPanelCitizen_Profile().getTxtYear().getText().equals(Integer.toString(model.getCurretCitizen().getPersonal().getDate().getYear()))) {
				citizenView.getPanelCitizen_Profile().getTxtYear().setText("");
			} else {
				citizenView.getPanelCitizen_Profile().getTxtYear().selectAll();
			}
		}
		/** This method checks if the text field is no longer being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusLost(FocusEvent e) {
			if(citizenView.getPanelCitizen_Profile().getTxtYear().getText().equals(""))
				citizenView.getPanelCitizen_Profile().getTxtYear().setText(Integer.toString(model.getCurretCitizen().getPersonal().getDate().getYear()));
		}
	}
	
	/** The class Profile_homeListener extends FocusAdapter to do certain actions when the home address text field is interacted */
	class Profile_homeListener extends FocusAdapter{		// Home address focus listener 
		/** This method checks if the text field is being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusGained(FocusEvent e) {
			if(citizenView.getPanelCitizen_Profile().getTxtHome().getText().equals(model.getCurretCitizen().getPersonal().getContact().getHome())) {
				citizenView.getPanelCitizen_Profile().getTxtHome().setText("");
			} else {
				citizenView.getPanelCitizen_Profile().getTxtHome().selectAll();
			}
		}
		/** This method checks if the text field is no longer being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusLost(FocusEvent e) {
			if(citizenView.getPanelCitizen_Profile().getTxtHome().getText().equals(""))
				citizenView.getPanelCitizen_Profile().getTxtHome().setText(model.getCurretCitizen().getPersonal().getContact().getHome());
		}
	}
	
	/** The class Profile_officeListener extends FocusAdapter to do certain actions when the office address text field is interacted */
	class Profile_officeListener extends FocusAdapter{		// Office address focus listener 
		/** This method checks if the text field is being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusGained(FocusEvent e) {
			if(citizenView.getPanelCitizen_Profile().getTxtOffice().getText().equals(model.getCurretCitizen().getPersonal().getContact().getOffice())) {
				citizenView.getPanelCitizen_Profile().getTxtOffice().setText("");
			} else {
				citizenView.getPanelCitizen_Profile().getTxtOffice().selectAll();
			}
		}
		/** This method checks if the text field is no longer being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusLost(FocusEvent e) {
			if(citizenView.getPanelCitizen_Profile().getTxtOffice().getText().equals(""))
				citizenView.getPanelCitizen_Profile().getTxtOffice().setText(model.getCurretCitizen().getPersonal().getContact().getOffice());
		}
	}

	/** The class Profile_phoneListener extends FocusAdapter to do certain actions when the phone number text field is interacted */
	class Profile_phoneListener extends FocusAdapter{		// Phone number focus listener 
		/** This method checks if the text field is being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusGained(FocusEvent e) {
			if(citizenView.getPanelCitizen_Profile().getTxtPhone().getText().equals(model.getCurretCitizen().getPersonal().getContact().getPhone())) {
				citizenView.getPanelCitizen_Profile().getTxtPhone().setText("");
			} else {
				citizenView.getPanelCitizen_Profile().getTxtPhone().selectAll();
			}
		}
		/** This method checks if the text field is no longer being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusLost(FocusEvent e) {
			if(citizenView.getPanelCitizen_Profile().getTxtPhone().getText().equals(""))
				citizenView.getPanelCitizen_Profile().getTxtPhone().setText(model.getCurretCitizen().getPersonal().getContact().getPhone());
		}
	}

	/** The class Profile_emailListener extends FocusAdapter to do certain actions when the email address text field is interacted */
	class Profile_emailListener extends FocusAdapter{		// Email address focus listener 
		/** This method checks if the text field is being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusGained(FocusEvent e) {
			if(citizenView.getPanelCitizen_Profile().getTxtEmail().getText().equals(model.getCurretCitizen().getPersonal().getContact().getEmail())) {
				citizenView.getPanelCitizen_Profile().getTxtEmail().setText("");
			} else {
				citizenView.getPanelCitizen_Profile().getTxtEmail().selectAll();
			}
		}
		/** This method checks if the text field is no longer being interacted.
		 * 
		 * @param e the focus event that triggers the method */ 
		@Override
		public void focusLost(FocusEvent e) {
			if(citizenView.getPanelCitizen_Profile().getTxtEmail().getText().equals(""))
				citizenView.getPanelCitizen_Profile().getTxtEmail().setText(model.getCurretCitizen().getPersonal().getContact().getEmail());
		}
	}
	
	/** The class UpdateListener extends MouseAdapter to listen for mouse interactions with the Update Profile panel button */
	class UpdateListener extends MouseAdapter {
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			citizenView.getPanelCitizen_CheckIn().setVisible(false);
			citizenView.getPanelCitizen_Report().setVisible(false);
			citizenView.getPanelCitizen_VisitRecord().setVisible(false);
			citizenView.getPanelCitizen_Profile().setVisible(true);		
		}
	}

	/** The class Update_ConfirmListener extends MouseAdapter to listen for mouse interactions with the confirm button under the update profile panel */
	class Update_ConfirmListener extends MouseAdapter {
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			update = false;
			Checking check = new Checking();
			String password = citizenView.getPanelCitizen_Profile().getTxtPassword().getText();
			String first = citizenView.getPanelCitizen_Profile().getTxtFirst().getText();
			String middle = citizenView.getPanelCitizen_Profile().getTxtMiddle().getText();
			String last = citizenView.getPanelCitizen_Profile().getTxtSurname().getText();
			String month = citizenView.getPanelCitizen_Profile().getTxtMonth().getText();
			String day = citizenView.getPanelCitizen_Profile().getTxtDay().getText();
			String year = citizenView.getPanelCitizen_Profile().getTxtYear().getText();
			String home = citizenView.getPanelCitizen_Profile().getTxtHome().getText();
			String office = citizenView.getPanelCitizen_Profile().getTxtOffice().getText();
			String phone = citizenView.getPanelCitizen_Profile().getTxtPhone().getText();
			String email = citizenView.getPanelCitizen_Profile().getTxtEmail().getText();
			
			if(!password.equals("") && !password.equals(model.getCurretCitizen().getUser().getPassword())) {					
				if(!check.isValidPassword(password)) {
					update = true;
					model.getCurretCitizen().getUser().setPassword(password);
					System.out.println("Password updated: " + model.getCurretCitizen().getUser().getPassword());
				}
			}
				
			if(!first.equals("") && !first.equals(model.getCurretCitizen().getPersonal().getName().getFirstName())) {				
				update = true;
				model.getCurretCitizen().getPersonal().getName().setFirstName(first);
				System.out.println("First name updated: " + model.getCurretCitizen().getPersonal().getName().getFirstName());
			}
			
			if(!middle.equals("") && !middle.equals(model.getCurretCitizen().getPersonal().getName().getMiddleName())) {				
				update = true;
				model.getCurretCitizen().getPersonal().getName().setMiddleName(middle);
				System.out.println("Middle name updated: " + model.getCurretCitizen().getPersonal().getName().getMiddleName());
			}
			
			if(!last.equals("") && !last.equals(model.getCurretCitizen().getPersonal().getName().getSurName())) {				
				update = true;
				model.getCurretCitizen().getPersonal().getName().setSurName(last);
				System.out.println("Surname updated: " + model.getCurretCitizen().getPersonal().getName().getSurName());
			}
			
			if(!month.equals("") && !month.equals(String.valueOf(model.getCurretCitizen().getPersonal().getDate().getMonth()))) {
				Date enteredMonth = new Date(Integer.parseInt(month), model.getCurretCitizen().getPersonal().getDate().getDay(), model.getCurretCitizen().getPersonal().getDate().getYear());
				boolean checkMonth = enteredMonth.isValidDate(Integer.parseInt(month), model.getCurretCitizen().getPersonal().getDate().getDay(), model.getCurretCitizen().getPersonal().getDate().getYear());
				if (checkMonth) {
					update = true;
					model.getCurretCitizen().getPersonal().getDate().setMonth(Integer.parseInt(month));
					System.out.println("Birth month updated: " + model.getCurretCitizen().getPersonal().getDate().getMonth());
				}
			}
			
			if(!day.equals("") && !day.equals(String.valueOf(model.getCurretCitizen().getPersonal().getDate().getDay()))) {
				Date enteredDay = new Date(model.getCurretCitizen().getPersonal().getDate().getMonth(), Integer.parseInt(day), model.getCurretCitizen().getPersonal().getDate().getYear());
				boolean checkDay = enteredDay.isValidDate(model.getCurretCitizen().getPersonal().getDate().getMonth(), Integer.parseInt(day), model.getCurretCitizen().getPersonal().getDate().getYear());
				if(checkDay) {
					update = true;
					model.getCurretCitizen().getPersonal().getDate().setDay(Integer.parseInt(day));
					System.out.println("Birth day updated: " + model.getCurretCitizen().getPersonal().getDate().getDay());
				}
			}
			
			if(!year.equals("") && !year.equals(String.valueOf(model.getCurretCitizen().getPersonal().getDate().getYear()))) {
				Date enteredYear = new Date(model.getCurretCitizen().getPersonal().getDate().getMonth(), model.getCurretCitizen().getPersonal().getDate().getDay(), Integer.parseInt(year));
				boolean checkYear = enteredYear.isValidDate(model.getCurretCitizen().getPersonal().getDate().getMonth(), model.getCurretCitizen().getPersonal().getDate().getDay(), Integer.parseInt(year));
				if(checkYear) {
					update = true;
					model.getCurretCitizen().getPersonal().getDate().setYear(Integer.parseInt(year));
					System.out.println("Birth year updated: " + model.getCurretCitizen().getPersonal().getDate().getYear());
				}
			}
			
			if(!home.equals("") && !home.equals(model.getCurretCitizen().getPersonal().getContact().getHome())) {
				update = true;
				model.getCurretCitizen().getPersonal().getContact().setHome(home);
				System.out.println("Home address updated: " + model.getCurretCitizen().getPersonal().getContact().getHome());
			}
			
			if(!office.equals("") && !office.equals(model.getCurretCitizen().getPersonal().getContact().getOffice())) {
				update = true;
				model.getCurretCitizen().getPersonal().getContact().setOffice(office);
				System.out.println("Office address updated: " + model.getCurretCitizen().getPersonal().getContact().getOffice());
			}
			
			if(!phone.equals("") && !phone.equals(model.getCurretCitizen().getPersonal().getContact().getPhone())) {
				update = true;
				model.getCurretCitizen().getPersonal().getContact().setPhone(phone);
				System.out.println("Phone number updated: " + model.getCurretCitizen().getPersonal().getContact().getPhone());
			}
			
			if(!email.equals("") && !email.equals(model.getCurretCitizen().getPersonal().getContact().getEmail())) {
				update = true;
				model.getCurretCitizen().getPersonal().getContact().setEmail(email);
				System.out.println("Email address updated: " + model.getCurretCitizen().getPersonal().getContact().getEmail());
			}		
			
			if (update) {
				citizenView.getPanelCitizen_Profile().success();
				// -- FOR CHECKING
				System.out.println("Username: " + model.getCurretCitizen().getUser().getUsername() + " Password: " +  model.getCurretCitizen().getUser().getPassword());
				System.out.println("Name: " +  model.getCurretCitizen().getPersonal().getName() + " BDAY: " +  model.getCurretCitizen().getPersonal().getDate() + " Role: " +  model.getCurretCitizen().getRole());
				System.out.println( model.getCurretCitizen().getPersonal().getContact().getHome() + " -- " +  model.getCurretCitizen().getPersonal().getContact().getOffice() + " -- " +  model.getCurretCitizen().getPersonal().getContact().getPhone() + " -- " +  model.getCurretCitizen().getPersonal().getContact().getEmail());
				// -- 
			} else citizenView.getPanelCitizen_Profile().error();
		}
		
	}

	/** The class LogOutListener extends MouseAdapter to listen for mouse interactions with the Log out button */
	class LogOutListener extends MouseAdapter {
		/** This method checks if the mouse clicked on a specific asset.
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseClicked(MouseEvent e) {
			RoleSelection_View roleSelectView = new RoleSelection_View();
			RoleSelection_Controller roleSelectControl = new RoleSelection_Controller(model, roleSelectView);
			
			if (update)
				new TextFiles().CreateAccount(model.getCurretCitizen());		// Saves the updated information
			
			if (checkIn)
				new TextFiles().CreateEVR(model.getCitizens());					// Saves the establishment record
			
			roleSelectControl.getRoleSelectView().setVisible(true);
			citizenView.dispose();
		}
	}
	
	/** This method returns the citizenView of the controller
	 * 
	 * @return citizenView the visual aspects of the citizen menu	*/
	public LoggedIn_Citizen_View getCitizenView() {
		return citizenView;
	}
	
	/** The data being passed between controllers */
	private Model model;
	/** The visual aspects of the citizen menu */
	private LoggedIn_Citizen_View citizenView;
	/** Checks if the user checked in during this login session */
	private boolean checkIn;
	/** Checks if the user updated their profile information during this login session */
	private boolean update;
}