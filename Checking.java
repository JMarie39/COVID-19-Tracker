import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**	The Checking class is for doing unnecessary checking, display and generating informations	*/
public class Checking {
	
	/**	The method is for user log in
	 * 
	 * 	@param citizenList the list of citizens
	 *  @param username the username of the user
	 *  @param password the password of the user
	 * 	@return logged in username of the current user	*/
	public String LogIn_User(ArrayList<Citizen> citizenList, String username, String password) {
		for(Citizen citizen : citizenList)
			if(citizen.getUser().getUsername().equalsIgnoreCase(username) && citizen.getUser().getPassword().equals(password))
				return username;	
			
		return null;
	}
	
	/**	The method checks whether the username is unique or not
	 * 
	 * 	@param citizenList the list of citizens	
	 * 	@param username is the entered username	of the current user registering	
	 * 	@return true if name is not unique, otherwise false	*/
	public boolean isValidCUsername(ArrayList<Citizen> citizenList, String username) {
		
		if (!username.contains(" ") && !username.equals("")) 
			for(Citizen citizen : citizenList)
				if(citizen.getUser().getUsername().equalsIgnoreCase(username)) 	
						return true;	// If username is not unique
		
		if (username.contains(" "))
			System.out.println("Xx INVALID USERNAME (SHOULD HAVE NO SPACES) xX");
		
		return false;
	}
	
	/**	The method checks whether the password contains a special character(s)/number(s)
	 * 
	 * 	@param password is the entered password of the current user registering	
	 * 	@return false if password contains special characters/numbers and is at least 6 characters, otherwise true	*/
	public boolean isValidPassword(String password) {
		/* source: https://www.javamadesoeasy.com/2015/12/how-to-check-string-contains-special.html	*/
		boolean checkPassword = false;
		Pattern pattern = Pattern.compile("[a-zA-Z]*");
        Matcher matcher = pattern.matcher(password);
        checkPassword = matcher.matches();	// False if password contains special characters/numbers, otherwise true

        if(password.length() < 6)
			System.out.println("Xx INVALID PASSWORD (MUST BE MORE THAN 6 CHARACTERS) xX");
        else if(checkPassword)
			System.out.println("Xx INVALID PASSWORD (MUST CONTAIN A DIGIT OR A SPECIAL CHARACTER xX)");
        else if (password.contains(" "))
        System.out.println("Xx INVALID PASSWORD (MUST NOT CONTAIN SPACE) xX");
		
		return password.length() < 6 || checkPassword || password.contains(" ");	
	}
	
	/**	The methods generates a random password
	 * 
	 * 	@return password generated	*/
	public String generatePassword() {
		String password;
		/*	sources: 	https://howtodoinjava.com/java8/intstream-examples/#:~:text=Java%20IntStream%20class%20is%20an,implements%20AutoCloseable%20and%20BaseStream%20interfaces.
						https://www.geeksforgeeks.org/stream-flatmap-java-examples/#:~:text=Stream%20flatMap(Function%20mapper)%20returns,mapping%20function%20to%20each%20element.	*/
		
		/* The code is equivalent of having written new int[] { '_', 'a', 'b', 'c', ..., 'x', 'y', 'z', 'A', ... , 'Z' }	*/
		int[] charsAsInt = Stream.of(IntStream.of('!', '@', '#', '$', '^', '&', '*', ')', '(', '+', '=', '<', '>', '?', '_'), 
		IntStream.rangeClosed('a', 'z'), IntStream.rangeClosed('A', 'Z'), IntStream.rangeClosed('0', '9'))
		.flatMap(IntStream::boxed) 	// Convert IntStream to Stream<Integer> for using flatMap, to flatten the structure
		.mapToInt((Integer x) -> (int) x).toArray();	// Unbox integers == integer to int
		
		do {
			Random random = new Random();
			StringBuilder builder = new StringBuilder();
			int passLength = (int) (Math.random() * (10 - 6 + 1) + 6); 
			
			while(0 < passLength--)
			builder.append((char) charsAsInt[random.nextInt(charsAsInt.length)] /* Conversion is safe by construction */);
			
			password = builder.toString();
		} while(isValidPassword(password));	// If password is less that 6 characters & password does not contain special characters/ numbers
		
		return password;
	}
	
	/**	The method gets the citizen account of the current user logged in
	 * 
	 * 	@param citizenList the list of citizens
	 * 	@param username of the current logged in user
	 * 	@return the (citizen) object if found, otherwise null	*/
	public Citizen CurrentUser_Citizen(ArrayList<Citizen> citizenList, String username) {
		for(Citizen citizen : citizenList)
			if(citizen.getUser().getUsername().equalsIgnoreCase(username))
				return citizen;
		return null;
	}
	
	/**	The method gets the official account of the current user logged in
	 * 
	 * 	@param officialList the list of officials
	 * 	@param username of the current logged in user
	 * 	@return official object if found, otherwise null	*/
	public Official CurrentUser_Official(ArrayList<Official> officialList, String username) {
		for(Official official : officialList)
			if(official.getUser().getUsername().equalsIgnoreCase(username))
				return official;
		return null;
	}
	
	/**	The method gets the tracer account of the current user logged in
	 * 
	 * 	@param tracerList the list of tracers
	 * 	@param username of the current logged in user
	 * 	@return tracer object if found, otherwise null	*/
	public Tracer CurrentUser_Tracer(ArrayList<Tracer> tracerList, String username) {
		for(Tracer tracer : tracerList)
			if(tracer.getUser().getUsername().equalsIgnoreCase(username))
				return tracer;
		return null;
	}
	
	/**	The method registers a default government official account
	 * 
	 * 	@param citizenList the list of citizens
	 *  @param officialList the list of officials	*/
	public void defaultUser(ArrayList<Citizen> citizenList, ArrayList<Official> officialList) {
		User defaultUser = new User("Admin2020", "@Dm1n0202");
		Personal defaultInfo = new Personal();
		Name name = new Name("Admin", "_", "2020");
		defaultInfo.setName(name);
		defaultInfo.setBDay(new Date(9, 28, 2020));		// Default date

		Contact defaultContact = new Contact("none", "none", "none", "none");
		defaultInfo.setContact(defaultContact);
		Citizen defaultCUser = new Citizen(defaultUser, defaultInfo, 2);	// Creates the default citizen account of admin
		new TextFiles().CreateMasterList(citizenList);	// Updates the MasterList.txt file
		new TextFiles().CreateAccount(defaultCUser);	// Creates an .act file for the admin
		citizenList.add(defaultCUser);					// Adds the default user into the citizenList
		officialList.add(new Official(defaultCUser));	// Adds the default user into the officialList
	}
	
	/**	The method is used to enter the date information
	 * 
	 *  @param month the month of the date
	 *  @param day the day of the date
	 *  @param year the year of the date
	 * 	@return date entered by the user	*/
	public Date enterDate(String month, String day, String year) {
		
		if (!month.equals("") && !day.equals("") && !year.equals("")) {
			int m = Integer.parseInt(month);
			int d = Integer.parseInt(day);
			int y = Integer.parseInt(year);
			Date enteredDate = new Date(m, d, y);
			
			if(enteredDate.isValidDate(m, d, y)) {
				return enteredDate;
			} else 
				System.out.println("\n\tXx INVALID DATE xX\n");
		}
		
		return null;
	}
	
	/**	The method prints all the citizens
	 * 
	 * 	@param	citizenList	list of citizens	*/
	public void printCitizenList(ArrayList<Citizen> citizenList) {
		System.out.println("\nCitizen ArrayList Size: " + citizenList.size());	
		int i = 1;
		for(Citizen citizen : citizenList) {
			System.out.println(i++ + ".) " + citizen.getUser().getUsername() + ", " + citizen.getUser().getPassword() + " -- BDAY --> " + citizen.getPersonal().getDate());
			System.out.println(citizen.getPersonal().getName() + " -- " + citizen.getPersonal().getDate() + " --> " + citizen.getRole());
			System.out.println(citizen.getPersonal().getContact().getHome() + " -- " + citizen.getPersonal().getContact().getOffice() + " -- " + citizen.getPersonal().getContact().getPhone() + " -- " + citizen.getPersonal().getContact().getEmail());
			if (!citizen.visitRecord.isEmpty())
				for(VisitRecord visit : citizen.visitRecord)
					System.out.println("[VISIT RECORD] XXXX " + visit.getCode() + " " + visit.getDate() + " " + visit.getTime());
		}
	}
		
	/**	The method prints all the officials
	 * 
	 * 	@param	officialList list of officials	*/
	public void printOfficialList(ArrayList<Official> officialList) {
		System.out.println("\nOfficial ArrayList Size: " + officialList.size());	
		int i = 1;
		for(Citizen official : officialList) {
			System.out.println(i++ + ".) " + official.getUser().getUsername() + ", " + official.getUser().getPassword());		
			System.out.println(official.getPersonal().getName() + " -- " + official.getPersonal().getDate() + " --> " + official.getRole());
			System.out.println(official.getPersonal().getContact().getHome() + " -- " + official.getPersonal().getContact().getOffice() + " -- " + official.getPersonal().getContact().getPhone() + " -- " + official.getPersonal().getContact().getEmail());
		}
	}
	
	/**	The method prints all the tracers
	 * 
	 * 	@param	tracerList list of tracers	*/
	public void printTracerList(ArrayList<Tracer> tracerList) {	
		System.out.println("\nTracer ArrayList Size: " + tracerList.size());	
		int i = 1;
		for(Citizen tracer : tracerList) {
			System.out.println(i++ + ".) " + tracer.getUser().getUsername() + ", " + tracer.getUser().getPassword());		
			System.out.println(tracer.getPersonal().getName() + " -- " + tracer.getPersonal().getDate() + " --> " + tracer.getRole());
			System.out.println(tracer.getPersonal().getContact().getHome() + " -- " + tracer.getPersonal().getContact().getOffice() + " -- " + tracer.getPersonal().getContact().getPhone() + " -- " + tracer.getPersonal().getContact().getEmail());			
		}
	}
	
	/**	The method prints all the cases
	 * 
	 * 	@param	caseList list of cases	*/
		public void printCaseList(ArrayList<Case> caseList) {	
			System.out.println("\nCase ArrayList Size: " + caseList.size());	
			for(Case cases : caseList) {
				System.out.println(cases.getCaseNum() + " " + cases.getUser() + " " + cases.getDate() + " " + cases.getTracer() + " " + cases.getStatus());			
			}
		}
}	