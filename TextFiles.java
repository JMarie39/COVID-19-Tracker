import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**	The class TextFiles saves the needed informations into text files.	*/
public class TextFiles {
	
	/**	This method creates a list of users in text file .
	 * 
	 * 	@param citizenList list of users	*/
	public void CreateMasterList (ArrayList<Citizen> citizenList) {
		try(BufferedWriter myWriter = new BufferedWriter(new FileWriter("MasterList.txt"))) {
			for (Citizen citizen : citizenList)
				myWriter.write(citizen.getUser().getUsername() + " " + citizen.getRole() + "\n");
		} catch(IOException e) {
			System.out.println("Error saving MasterList.txt.");
		}
	}
	
	/**	This method creates a contact information of the user.
	 * 
	 * 	@param user account	*/
	public void CreateAccount (Citizen user) {
		try (BufferedWriter myWriter = new BufferedWriter(new FileWriter(user.getUser().getUsername() + ".act"))) {			
			myWriter.write(user.getUser().getPassword() + "\n");
			if (user.getPersonal().getName() != null) {
				myWriter.write(user.getPersonal().getName().getFirstName() + "," + user.getPersonal().getName().getMiddleName() + "," + user.getPersonal().getName().getSurName() + "\n");
				myWriter.write("HOME:" + user.getPersonal().getContact().getHome() + "\n");
				myWriter.write("OFFICE:" + user.getPersonal().getContact().getOffice() + "\n");
				myWriter.write("PHONE:" + user.getPersonal().getContact().getPhone() + "\n");
				myWriter.write("EMAIL:" + user.getPersonal().getContact().getEmail());
			}
		} catch(IOException e) {
			System.out.println("Error saving user information.");
		}
	}
	
	/**	This method reads users in the Master List and retrieves the contact informations.
	 * 
	 * 	@param citizenList list of citizens
	 *  @param officialList list of officials
	 *  @param tracerList list of tracers	*/
	public void ReadAccounts (ArrayList<Citizen> citizenList, ArrayList<Official> officialList, ArrayList<Tracer> tracerList) {
		try (BufferedReader myObj1 = new BufferedReader(new FileReader("MasterList.txt")); 
				Scanner myReader1 = new Scanner(myObj1)) {   
			String username = null, role = null;

			while (myReader1.hasNextLine()) {			// This reads the MasterList.txt
				String[] arrData1 = myReader1.nextLine().split(" ");	
		        
				username = arrData1[0];
				role = arrData1[arrData1.length - 1];
		       
				try (FileReader myObj2 = new FileReader(username + ".act"); 	// Gets the corresponding .act file of the user
						Scanner myReader2 = new Scanner(myObj2)) {
					Personal info = new Personal();	// Personal information
		    		
					String password = myReader2.nextLine();
					String[] arrName = myReader2.nextLine().split(",");
					String fName = arrName[0];
					String mName = arrName[1];
					String sName = arrName[2];
					Name name = new Name(fName, mName, sName);
					
					String[] home = myReader2.nextLine().split(":");
					String aHome = home[1];

		    		String[] office = myReader2.nextLine().split(":");
		    		String aOffice = office[1];

		    		String[] phone = myReader2.nextLine().split(":");
		    		String pNumber = phone[1];

		    		String[] email = myReader2.nextLine().split(":");
		    		String aEmail = email[1];
				    
		    		info.setName(name);
		    		info.setBDay(new Date(9, 28, 2020));		// Default date
		    		Contact contact = new Contact(aHome, aOffice, pNumber, aEmail);
		    		info.setContact(contact);
				    
		    		User user = new User(username, password);
		    		Citizen citizen = new Citizen(user, info);
		    		citizen.setRole(role);
		    		citizenList.add(citizen);
		    		new TextFiles().ReadEVR(citizen);		// Reads the EstablishmentVisitRecord.txt and gets the corresponding info of the user
		    		
		    		switch(role) {
		    			case "official" :	// If official
											officialList.add(new Official(citizen));
											break;
		    		  	case "tracer" :		// If tracer
											tracerList.add(new Tracer(citizen));
											break;
		    		  }			    
		        } catch (FileNotFoundException e) {
		        	
				}
		      }     
		} catch (FileNotFoundException e) {
			System.out.println("MasterList.txt not found.");
		} catch (IOException e) {
			
		}
	}
	
	/**	This method creates an establishment record of visited by the user	
	 * 	
	 * 	@param citizenList list of citizens	*/
	public void CreateEVR (ArrayList<Citizen> citizenList) {
		try (BufferedWriter myWriter = new BufferedWriter(new FileWriter("EstablishmentVisitRecord.txt"))) {
			for (Citizen citizen : citizenList) {
				if (!citizen.visitRecord.isEmpty()) {
					myWriter.write(citizen.getUser().getUsername() + "\n");
					for (VisitRecord visit :  citizen.visitRecord) {
						myWriter.write(visit.getCode() + " " + visit.getDate() + " " + visit.getTime() + "\n");			
					}	
					myWriter.write("\n");
				}
			}
			myWriter.close();
		} catch(IOException e) {
			System.out.println("Error saving EstablishmentVisitRecord.txt");
		}
	}
	
	/**	This method reads the establishment visit record text file	
	 * 	
	 * 	@param citizen object	*/
	public void ReadEVR (Citizen citizen) {
		try (BufferedReader myObj = new BufferedReader(new FileReader("EstablishmentVisitRecord.txt"));
				Scanner myReader = new Scanner(myObj)){
			
			while(myReader.hasNextLine()) {
				String findUser = myReader.nextLine();			// Find the username
				
				if (citizen.getUser().getUsername().equalsIgnoreCase(findUser)) {
					while(myReader.hasNextLine()) {	
						String[] evr = myReader.nextLine().split(" ");
						if(evr.length != 1) {
							String[] strDate = evr[1].split(",");
							Date date = new Date(Integer.parseInt(strDate[0]), Integer.parseInt(strDate[1]), Integer.parseInt(strDate[2]));
							citizen.checkIn(evr[0], date, Integer.parseInt(evr[2]));
						} else break;
					}
				}	
			}
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
	}
	
	/**	This method creates the list of positive cases.
	 * 	
	 * 	@param caseList list of cases	*/
	public void CreateCase (ArrayList<Case> caseList) {
		try(BufferedWriter myWriter = new BufferedWriter(new FileWriter("PositiveCases.txt"))) {
			for (Case cases : caseList) 
				myWriter.write("casenum" + cases.getCaseNum() + " " + cases.getUser() + " " + cases.getDate() + " " + cases.getTracer() + " " + cases.getStatus() + "\n");
		} catch(IOException e) {
			System.out.println("Error saving PositivesCases.txt.");
		}
	}
	
	/**	This method reads the list of positive cases.
	 * 	
	 * 	@param caseList list of cases	*/
	public void ReadCase(ArrayList<Case> caseList) {
		try (BufferedReader myObj = new BufferedReader(new FileReader("PositiveCases.txt"));
				Scanner myReader = new Scanner(myObj)){
			
			while (myReader.hasNextLine()) {
				String[] data = myReader.nextLine().split(" ");			
				String[] strCaseNum = data[0].split("casenum");			
				int nCase = Integer.parseInt(strCaseNum[1]);			
				String positiveName = data[1];			
				String[] strDate = data[2].split(",");
				Date date = new Date(Integer.parseInt(strDate[0]), Integer.parseInt(strDate[1]), Integer.parseInt(strDate[2]));			
				String tracerName = data[3];				
				char status = data[4].charAt(0);				
				caseList.add(new Case(nCase, positiveName, date, tracerName, status));	
			}		
		} catch (FileNotFoundException e) {
			System.out.println("PositiveCases.txt not found.");
		} catch (IOException e) {
			
		}
	}
}