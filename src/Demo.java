
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.*;
///User Class
abstract class User {
	private int ID;
	private String lastName;
	private String firstName;
	private String phoneNumber;
	private Long nationalID;
	private String address;
	private byte state;

	// ------------------------------------------------------------
	// constructor
	// ------------------------------------------------------------
	public User() {
		ID = 0;

		lastName = "";
		firstName = "";
		state = 0;
	}

	public User(int newID, String newLastName, String newFirstName, String newPhoneNumber) {
		setID(newID);
		setLastName(newLastName);
		setFirstName(newFirstName);
		setPhoneNumber(newPhoneNumber);
		// setAddress(newAddress);
		state = 0;
		
	}

	// ------------------------------------------------------------
	// setter
	// ------------------------------------------------------------
	protected void setID(int newID) {
		this.ID = newID;
	}

	protected void setLastName(String newLastName) {
		this.lastName = newLastName;
	}

	protected void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}

	protected void setPhoneNumber(String newPhoneNumber) {
		this.phoneNumber = newPhoneNumber;
	}

	protected void setWorkState(byte newState) {
		this.state = newState;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setNationalID(Long nationalID) {
		this.nationalID = nationalID;
	}

	// ------------------------------------------------------------
	// getter
	// ------------------------------------------------------------
	public int getID() {
		return this.ID;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getFullName() {
		String fullName = this.firstName + " " + this.lastName;
		return fullName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public byte getWorkState() {
		return this.state;
	}

	public String getAddress() {
		return address;
	}

	public Long getNationalID() {
		return nationalID;
	}
}

class Manager extends User {

	public Manager() {
		super();
	}

	public Manager(int newID, String newLastName, String newFirstName, String newPassward) {
		super(newID, newLastName, newFirstName, newPassward);

	}

}

class Customers extends User {

	public Customers() {
		super();
	}

	public Customers(int newID, String newLastName, String newFirstName, String newPassward) {
		super(newID, newLastName, newFirstName, newPassward);

	}

}

class Sellers extends Customers {

	public Sellers(int newID, String newLastName, String newFirstName) {
		// TODO Auto-generated constructor stub
	}

}

class Buyers extends Customers {

	public Buyers(int newID, String newLastName, String newFirstName, String newPassward) {
		// TODO Auto-generated constructor stub
	}

}

class Property {

	final public static int Property_CLOSED = 1;
	final public static int Property_CANCELED = 2;

	private int PropertyID;
	private int UserID;
	private String UserName;
	private int state; // 0:arrive 1:closed 2:canceled
	private String propertyName;
	private String location;
	private String owner;
	private boolean hasParking;
	private String noOfBeds;
	private String squareFeetArea;
	private String price;
	
	/**
	 * Constructor for objects of class Property
	 */
	public Property(int newUserID, String newUserName) {
		this.PropertyID = -1;
		this.state = 0;
		this.UserID = newUserID;
		this.UserName = newUserName;

	}

	/**
	 * Getter
	 */
	int getPropertyID() {
		return this.PropertyID;
	}

	int getUserID() {
		return this.UserID;
	}

	String getUserName() {
		return this.UserName;
	}

	int getState() {
		return this.state;
	}

	/**
	 * Setter
	 */
	public void setPropertyID(int newID) {
		this.PropertyID = newID;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setSquareFeetArea(String squareFeetArea) {
		this.squareFeetArea = squareFeetArea;
	}

	public void setNoOfBeds(String noOfBeds) {
		this.noOfBeds = noOfBeds;
	}

	public void setHasParking(boolean hasParking) {
		this.hasParking = hasParking;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	//// Getter

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getLocation() {
		return location;
	}

	public String getOwner() {
		return owner;
	}

	public boolean isHasParking() {
		return hasParking;
	}

	public String getNoOfBeds() {
		return noOfBeds;
	}

	public String getSquareFeetArea() {
		return squareFeetArea;
	}

	public String getPrice() {
		return price;
	}

}
///UserInterface class
class UserInterface {
	private static Scanner inputScanner;
	private String todaysDate;
	private Database crDatabase; // reference of database

	/****************************************************************************
	 * Constructor
	 ***************************************************************************/
	public UserInterface(Database rDatabase) {
		this.inputScanner = new Scanner(System.in);

		this.crDatabase = rDatabase;
	}

	public UserInterface() {
		// TODO Auto-generated constructor stub
	}

	UserInterface(Object datab) {
		// TODO Auto-generated constructor stub
	}

	/****************************************************************************
	 * Setter
	 ***************************************************************************/

	public void setTodaysDate(String today) {
		this.todaysDate = today;
	}

	/****************************************************************************
	 * Private methods
	 ***************************************************************************/
	private void displayTitle(String title) {
		String output = String.format("// %-65s//", title);
		displayMessage("//////////////////////////////////////////////////////////////////////");
		displayMessage(output);
		displayMessage("//////////////////////////////////////////////////////////////////////");
	}

	/****************************************************************************
	 * Public methods
	 ***************************************************************************/
	public void clearScreen() {
		System.out.println('\u000c');
	}

	// Normally used by controller
	public void displayMessage(String message) {
		System.out.println(message);
	}

	public void displayErrorMessage(String message) {
		System.out.println("** Error:" + message + "**");
	}

	// User input
	public String userInput() {
		String result = inputScanner.next();
		inputScanner.nextLine();// clear buffer
		return result;
	}

	public void finish() {
		clearScreen();
	}

	////////////////////////////////////////////////////////////////////////////
	// User
	////////////////////////////////////////////////////////////////////////////
	// ---------------------------------------------------------------
	// User management main menu
	// ---------------------------------------------------------------
	public void addNewUserView() {
		clearScreen();
		displayMessage("Add new User");
	}

	public void userManagementView() {
		clearScreen();
		displayMessage("Welcomen user managment ,please enter the number your choise");
		displayMessage("[1] Add new User");
		displayMessage("[2] Update User info");
		displayMessage("[3] Delete User info");
		displayMessage("[] Exist from programm");
		displayMessage("-----------------------------------------");
	}

	public void updateUserView(User rUser) {
		clearScreen();
		showUserData(rUser);
		displayMessage("\nChoose Edit number\n");
		displayMessage("[1]:Last name");
		displayMessage("[2]:First name");
		displayMessage("[3]:Forth clock out");
		displayMessage("[4]:Change start time");
		displayMessage("[5]:Change finish time");
		displayMessage("[]:Exist from programm\"");
	}

	// ---------------------------------------------------------------
	// User information
	// ---------------------------------------------------------------
	public void showUserData(User rUser) {
		displayMessage("*************** Employee Data ***************");
		displayMessage("User last name:" + rUser.getLastName());
		displayMessage("User first name:" + rUser.getFirstName());
		if (rUser.getClass().getName().equalsIgnoreCase("Manager")) {
			displayMessage("** Manager **");

		}

	}

	// show datail
	public void showUserList() {
		clearScreen();
		Iterator<User> it = crDatabase.getUserList().iterator();

		displayTitle("Employee List");
		while (it.hasNext()) {
			User re = (User) it.next();
			String fullName = re.getFirstName() + " " + re.getLastName();
			String output = String.format("User ID:%4d  Name:%-20s", re.getID(), fullName);

			if (re.getClass().getName().equalsIgnoreCase("Manager")) {
				output += " * Manager *";
			}
			displayMessage(output);

			/*
			 * displayMessage("User ID :" + re.getID()+ "  Name:" + re.getFirstName() + " "
			 * + re.getLastName());
			 */
		}
	}

	////////////////////////////////////////////////////////////////////////////
	// Property
	////////////////////////////////////////////////////////////////////////////
	// ---------------------------------------------------------------
	// Property management main menu
	// ---------------------------------------------------------------
	public void showPropertyMenu() {
		clearScreen();
		displayTitle("Property");
		displayMessage("[1] Create Property");
		displayMessage("[2] Update Property");
		displayMessage("[3] Selled Property");
		displayMessage("[4] Cancel Property");
		displayMessage("[5] Show Property list");
		displayMessage("[Q] Exsist frome program");
		displayMessage("-----------------------------------------");
	}

	// ---------------------------------------------------------------
	// Edit Property detail menu (Create Property or Update Property)
	// ---------------------------------------------------------------
	public void editPropertyView() {
		clearScreen();
		displayTitle("Edit Property");
		displayMessage("[1] Add new item");
		displayMessage("[2] Delete item");
		displayMessage("[3] Show Property detail");
		displayMessage("[Q] Quit");
		displayMessage("-----------------------------------------");
	}

	public void addPropertyItemView() {
		clearScreen();
		displayTitle("Add Property Item");

	}

	public void deletePropertyItemView() {
		clearScreen();
		displayTitle("Delete Property Item");
	}

	public void closePropertyView() {
		clearScreen();
		displayTitle("Close Property");
		showPropertyList();
	}

	public void cancelPropertyView() {
		clearScreen();
		displayTitle("Cancel Property");
		showPropertyList();
	}

	public void generateReportView() {
		clearScreen();
		displayTitle("Generate reports");
		displayMessage("[1] Sales repors");
		displayMessage("[2] Payment list");
		displayMessage("[Q] Quit");
		displayMessage("-----------------------------------------");
	}

	////////////
	// ---------------------------------------------------------------
	// Property information
	// ---------------------------------------------------------------
	public void showPropertyList() {
		Iterator<Property> it = crDatabase.getPropertyList().iterator();
		String state;
		String output;
		double totalAllProperty = 0;
		int PropertyCnt = 0;
		int cancelCnt = 0;
		double cancelTotal = 0;

		clearScreen();
		displayTitle("Property List (" + todaysDate + ")");
		while (it.hasNext()) {
			Property re = it.next();

			switch (re.getState()) {
			case Property.Property_CLOSED:
				state = "Selled";

				PropertyCnt++;
				break;
			case Property.Property_CANCELED:
				state = "Canceled";

				cancelCnt++;
				break;
			default:
				state = "-";

				PropertyCnt++;
				break;
			}

			output = String.format("Property ID:%4d  UserName:%-20s  Total:$%5.2f State:%-8s", re.getPropertyID(),
					re.getUserName(), state);
			displayMessage(output);
		}
		displayMessage("-------------------------------------------------------");
		displayMessage("Total sales:$" + totalAllProperty + "(" + PropertyCnt + ")" + "  Canceled:$" + cancelTotal + "("
				+ cancelCnt + ")\r\n");
	}

}
///Databse Class
class Database {

	private final static String User_FILE = "dataFiles/User.txt";
	private final static String MANAGER_FILE = "dataFiles/manager.txt";
	private final static String MENU_FILE = "dataFiles/menu_item.txt";
	private final static String REPORT_FILE = "dataFiles/reports/report_";
	private final static String PAYMENT_FILE = "dataFiles/reports/payment_";
	private final static String WAGE_INFO_FILE = "dataFiles/wage_info.txt";
	private final static String DIRECTORY_FILE = "dataFiles/";

	private ArrayList<User> UserList = new ArrayList<User>();
	private ArrayList<Property> PropertyList = new ArrayList<Property>();

	private Date date;
	int todaysPropertyCounts;

	/****************************************************************************
	 * Constructor
	 ***************************************************************************/
	public Database() {
		date = new Date();
		todaysPropertyCounts = 0; // Load Property file??
		File theDir = new File(DIRECTORY_FILE);
		if (!theDir.exists()) {
			theDir.mkdirs();
		}

	}

	/****************************************************************************
	 * Getter
	 ***************************************************************************/
	public ArrayList<User> getUserList() {
		return UserList;
	}

	public ArrayList<Property> getPropertyList() {
		return PropertyList;
	}

	// ----------------------------------------------------------
	// Find User from ID /
	// ----------------------------------------------------------

	public User findUserByID(int id) {
		Iterator<User> it = UserList.iterator();
		User re = null;
		boolean found = false;

		if (id < 0) {
			return null;
		}

		while (it.hasNext() && !found) {
			re = (User) it.next();
			if (re.getID() == id) {
				found = true;
			}
		}

		if (found)
			return re;
		else
			return null;
	}

	// ----------------------------------------------------------
	// Find Property from ID
	// ----------------------------------------------------------
	public Property findPropertyByID(int id) {
		Iterator<Property> it = PropertyList.iterator();
		Property re = null;
		boolean found = false;

		if (id < 0) {
			return null;
		}

		while (it.hasNext() && !found) {
			re = it.next();
			if (re.getPropertyID() == id) {
				found = true;
			}
		}

		if (found)
			return re;
		else
			return null;
	}

	/****************************************************************************
	 * Manipurate datas
	 ***************************************************************************/
	// --------------------------------------------------------------------------

	public final static int EDIT_LAST_NAME = 1;
	public final static int EDIT_FIRST_NAME = 2;
	public final static int EDIT_PASSWORD = 3;

	public void editUserData(int UserID, String newPhoneNumber, String newFirstName, String newLastName)
			throws DatabaseException {
		User rUser = findUserByID(UserID);
		rUser.setPhoneNumber(newPhoneNumber);
		rUser.setLastName(newLastName);
		rUser.setFirstName(newFirstName);

		try {
			if (rUser instanceof Manager)
				// if(rUser.getClass().getName().equalsIgnoreCase("Manager"))
				updateUserFile(true);// update manager file
			else
				updateUserFile(false);// update Customers file
		} catch (DatabaseException dbe) {
			throw dbe;
		}
	}

	public void editUserData(User rUser, int which, String newData) throws DatabaseException {
		switch (which) {
		case EDIT_LAST_NAME:
			rUser.setLastName(newData);
			break;
		case EDIT_FIRST_NAME:
			rUser.setFirstName(newData);
			break;
		case EDIT_PASSWORD:
			rUser.setPhoneNumber(newData);
			break;
		default:
			break;
		}
	}

	public void deleteUser(User rUser) throws DatabaseException {
		boolean isManager = false;
		UserList.remove(rUser);
		// if(rUser.getClass().getName().equalsIgnoreCase("Manager"))
		if (rUser instanceof Manager)
			isManager = true;
		try {
			updateUserFile(isManager);
		} catch (DatabaseException dbe) {
			throw dbe;
		}
	}

	public void addUser(int newID, String newPassward, String newFirstName, String newLastName, boolean isManager,
			int userType) throws DatabaseException {
		User newUser;
		if (isManager)
			newUser = new Manager(newID, newLastName, newFirstName, newPassward);
		else {
			if (userType == 2) {
				newUser = new Sellers(newID, newLastName, newFirstName);
			} else {
				newUser = new Buyers(newID, newLastName, newFirstName, newPassward);
			}
		}
		UserList.add(newUser);
		if (newUser instanceof Manager)
			// if(newUser.getClass().getName().equalsIgnoreCase("Manager"))
			isManager = true;
		try {
			updateUserFile(isManager);
		} catch (DatabaseException dbe) {
			throw dbe;
		}
	}

	// ---------------------------------------------------------------
	// Property
	// ---------------------------------------------------------------
	public int addProperty(int UserID, String UserName) {
		int newPropertyID = ++todaysPropertyCounts;
		Property newProperty = new Property(UserID, UserName);
		newProperty.setPropertyID(newPropertyID);
		PropertyList.add(newProperty);
		return newPropertyID;
	}

	public boolean cancelProperty(int PropertyID) {
		Property rProperty = findPropertyByID(PropertyID);
		if (rProperty == null)
			return false;
		rProperty.setState(Property.Property_CANCELED);
		return true;
	}

	// Delete Property: Property data is deleted from the database
	public boolean deleteProperty(int PropertyID) {
		Property rProperty = findPropertyByID(PropertyID);
		if (rProperty == null)
			return false;
		PropertyList.remove(rProperty);
		todaysPropertyCounts--;
		return true;
	}

	public boolean closeProperty(int PropertyID) {
		Property rProperty = findPropertyByID(PropertyID);
		if (rProperty == null)
			return false;
		rProperty.setState(Property.Property_CLOSED);
		return true;
	}

	public void closeAllProperty() {
		Iterator<Property> it = PropertyList.iterator();
		Property re = null;

		while (it.hasNext()) {
			re = it.next();
			if (re.getState() == 0)// neither closed and canceled
			{
				re.setState(Property.Property_CLOSED);
			}
		}
	}

	public int getPropertyState(int PropertyID) {
		Property re = findPropertyByID(PropertyID);
		if (re == null)
			return -1;
		return re.getState();
	}

	public boolean checkIfAllPropertyClosed() {
		Iterator<Property> it = PropertyList.iterator();
		Property re = null;

		while (it.hasNext()) {
			re = it.next();
			if (re.getState() == 0)// neither closed and canceled
			{
				return false;
			}
		}
		return true;
	}

	/****************************************************************************
	 * File Edit
	 ***************************************************************************/
	public void updateUserFile(boolean isManager) throws DatabaseException {
		Writer writer;
		String id;
		String line;
		String fileName;
		String tempFileName = "dataFiles/temp.txt";

		if (isManager)
			fileName = MANAGER_FILE;
		else
			fileName = User_FILE;

		Collections.sort(UserList, new UserComparator());
		File tempFile = new File(tempFileName);

		try {
			writer = new BufferedWriter(new FileWriter(tempFile));
			Iterator it = UserList.iterator();

			while (it.hasNext()) {
				User re = (User) it.next();

				// -------- skip writing data ----------
				if (isManager) {
					// skip Customers data
					if (re instanceof Customers)
						// if(re.getClass().getName().equalsIgnoreCase("Customers"))
						continue;
				} else {
					// skip managere data
					// if(re.getClass().getName().equalsIgnoreCase("Manager"))
					if (re instanceof Manager)
						continue;
				}

				writer.write(re.getID() + "," + re.getPhoneNumber() + "," + re.getFirstName() + "," + re.getLastName()
						+ "\r\n");
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			String message = e.getMessage() + e.getStackTrace();
			throw new DatabaseException(message);
		}

		// delete current file
		File deleteFile = new File(fileName);
		deleteFile.delete();

		// renames temporaly file to new file
		File newFile = new File(fileName);
		tempFile.renameTo(newFile);

		updateWageFile();
	}

	public void updateWageFile() throws DatabaseException {
		Writer writer;
		String id;
		String line;
		String fileName;
		String tempFileName = "dataFiles/temp.txt";

		File tempFile = new File(tempFileName);

		try {
			writer = new BufferedWriter(new FileWriter(tempFile));
			Iterator it = UserList.iterator();

			while (it.hasNext()) {
				User re = (User) it.next();
				writer.write(re.getID() + "," + "\r\n");
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			String message = e.getMessage() + e.getStackTrace();
			throw new DatabaseException(message);
		}

		// delete current file
		File deleteFile = new File(WAGE_INFO_FILE);
		deleteFile.delete();

		// renames temporaly file to new file
		File newFile = new File(WAGE_INFO_FILE);
		tempFile.renameTo(newFile);
	}

	/****************************************************************************
	 * Comparator
	 ***************************************************************************/
	private class UserComparator implements Comparator<User> {

		@Override
		public int compare(User s1, User s2) {
			return s1.getID() < s2.getID() ? -1 : 1;
		}
	}

}
////Conteoller 
class Controller {

	// define scene
	public final static int SCENE_MAIN_MENU = 0; // main menu
	public final static int SCENE_LOGIN = 1; // login
	public final static int SCENE_LOGOUT = 2;
	public final static int SCENE_MENU_LIST = 3;
	public final static int SCENE_Property = 4;
	public final static int SCENE_EMPLOYEE_LIST = 5;
	public final static int SCENE_EDIT_EMPLOYEE = 6;
	public final static int SCENE_EDIT_MENU_ITEM = 7;
	public final static int SCENE_GENERATE_REPORTS = 8;

	// define user type
	public final static int USER_ANONYMOUS = 0;
	public final static int USER_EMPLOYEE = 1;
	public final static int USER_MANAGER = 2;

	private UserInterface cView; // Reference of userinterface
	private Database cDatabase;

	// parameter
	private int scene;
	private int state; // normally "0", if something happen (ex. quit program) this have some value.
	private int userType;
	private int currentUserID;
	private String currentUserName;
	private String todaysDate;

	public Controller() {
		this.cDatabase = new Database();
		this.cView = new UserInterface(this.cDatabase);
		this.scene = SCENE_MAIN_MENU;
		this.userType = USER_ANONYMOUS;
		this.currentUserID = 0;
		this.currentUserName = "";

		// get todays date
		Date date = new Date();
		SimpleDateFormat stf = new SimpleDateFormat("yyyy/MM/dd");
		todaysDate = stf.format(date);
		cView.setTodaysDate(todaysDate);

	}

	// ----------------------------------------------------------
	// Choose edit mode (1:Add 2:Update 3:Delete)
	// ----------------------------------------------------------
	public void chooseEditUserMode() {
		String key;
		int inputNumber = 0;

		cView.userManagementView();
		printMessageToView("Choose number:");
		key = cView.userInput();

		if (key.equalsIgnoreCase("Q")) // Back to main menu
		{
			scene = SCENE_MAIN_MENU;
			return;
		}

		while (inputNumber == 0) {
			try {
				Controller controller = new Controller();
						inputNumber = Integer.parseInt(key);
				switch (inputNumber) {
				case 1: // add new user
					addNewUser();
					break;
				case 2:
					updateUser();
					break;
				case 3:
					deleteUser();
					break;
				default:
					printMessageToView("Choose 1 to 3:");
					key = cView.userInput();
					break;
				}
			} catch (Exception e) {
				printMessageToView("Choose 1 to 3:");
				key = cView.userInput();
			}
		}
	}

	// ----------------------------------------------------------
	// Add new User
	// ----------------------------------------------------------
	@SuppressWarnings("static-access")
	private void addNewUser() {
		int newID = 0;
		String newFirstName;
		String newLastName;
		String newPassword;
		String key;

		boolean done = false;
		// -------------------- loop until new User is added or enter "Q" ----------
		while (!done) {
			cView.addNewUserView();
			newID = generateID();
			if (newID == 0) {
				// back to mein menu
				scene = SCENE_MAIN_MENU;
				return;
			}

			printMessageToView("Enter first name:");
			newFirstName = cView.userInput();
			printMessageToView("Enter last name:");
			newLastName = cView.userInput();
			printMessageToView("Enter password:");
			newPassword = cView.userInput();

			printMessageToView("Is the User manager?(Y/N)");
			key = cView.userInput();
			int userType = 0; // 1:manager 2:buyer 3:Seller

			while (userType == 0) {
				if (key.equalsIgnoreCase("Y")) {
					userType = 1;
					break;
				} else if (key.equalsIgnoreCase("N")) {
					
					printMessageToView("Ok The User is  as Seller?:");
					key = cView.userInput();
					if (key.equalsIgnoreCase("Y")) {
						userType = 2;
						break;
					} else if (key.equalsIgnoreCase("N")) {
						userType = 3;
						break;
					}

					break;
				} else {
					printMessageToView("Please enter 'Y' or 'N'");
					key = cView.userInput();
				}
			}
			// Check all input
			printMessageToView("--------------------------------------");
			printMessageToView("NewID:" + newID);
			printMessageToView("New User name:" + newFirstName + " " + newLastName);
			printMessageToView("Password:" + newPassword);
			switch (userType) {
			case 1:
				printMessageToView("The User will be added as manager.");
				break;
			case 2:
				printMessageToView("The User will be added as Seller.");
				break;
			case 3:
				printMessageToView("The User will be added as buyer");
				break;
			}

			printMessageToView("\nOK? (Y:yes)");
			key = cView.userInput();

			if (key.equalsIgnoreCase("Y")) {
				boolean isManager = false;
				if (userType == 1)
					isManager = true;
				try {
					cDatabase.addUser(newID, newLastName, newFirstName, newPassword, isManager,userType);
					printMessageToView("New User information is added.");
					done = true;
				} catch (DatabaseException dbe) {
					printErrorMessageToView(dbe.getErrMessage());
					// pause(2);
				}
			}
		}
		// ---------------- User is added (loop end)-----------------------------

		printMessageToView("Please enter something to exit");
		key = cView.userInput();
		scene = SCENE_MAIN_MENU;
	}

	// ----------------------------------------------------------
	// Make and check new ID (used by addEmployee method only)
	// ----------------------------------------------------------
	private int generateID() {
		int newID = 0;
		String key;

		printMessageToView("Choose user ID for new User:");
		key = cView.userInput();

		while (newID == 0) {
			// Back to main menu
			if (key.equalsIgnoreCase("Q"))
				return 0;
			try {
				newID = Integer.parseInt(key);
				if (newID > 9999) {
					printMessageToView("Please enter less than 10000");
					key = cView.userInput();
					newID = 0;
				} else {
					// Check if there is same ID
					User rUser = cDatabase.findUserByID(newID);
					// if(found)
					if (rUser != null) {
						printMessageToView("ID:" + newID + "is already used by " + rUser.getFirstName() + " "
								+ rUser.getLastName() + ".");
						printMessageToView("Please try another number:");
						key = cView.userInput();
						newID = 0;
					}
				}
			} catch (Exception e) {
				printMessageToView("Please enter valid integer.");
				key = cView.userInput();
			}

		}
		return newID;
	}

	// ----------------------------------------------------------
	// Update User info
	// ----------------------------------------------------------
	private void updateUser() {
		String key;
		int inputNumber = 0;
		User rUser = null;
		boolean done = false;

		cView.showUserList();

		// ------------- Input ID check ----------------
		while (inputNumber == 0) {
			printMessageToView("Choose user ID to edit:");
			key = cView.userInput();

			if (key.equalsIgnoreCase("Q")) {
				// scene = SCENE_MAIN_MENU;
				printMessageToView("Transaction is canceled.");
				pause(2);
				return;
			}

			try {
				// findUser
				inputNumber = Integer.parseInt(key);
				rUser = cDatabase.findUserByID(inputNumber);

				if (rUser == null) {
					inputNumber = 0;
					printErrorMessageToView("ID is not found.");
				}
			} catch (Exception e) {
				printErrorMessageToView("ID must be valid number.");
			}
		}
		// ------------- Input ID check end ----------------

		// ------------- Choose update User menu ----------------
		cView.updateUserView(rUser);
		inputNumber = 0;

		while (inputNumber == 0) {
			key = cView.userInput();

			if (key.equalsIgnoreCase("Q")) {
				printMessageToView("Transaction is canceled.");
				pause(2);
				return;
			}

			try {
				inputNumber = Integer.parseInt(key);
				if (inputNumber < 1 || 5 < inputNumber) {
					inputNumber = 0;
					printMessageToView("Input 1 to 5");
				}
			} catch (Exception e) {
				printMessageToView("Input valid integer:");
			}
		}
	}

	// ----------------------------------------------------------
	// Delete User
	// ----------------------------------------------------------
	private void deleteUser() {
		String key;
		int inputNumber = 0;
		User rUser = null;

		cView.showUserList();

		printMessageToView("Choose user ID to delete:");
		key = cView.userInput();

		if (key.equalsIgnoreCase("Q")) // Back to main menu
		{
			scene = SCENE_MAIN_MENU;
			return;
		}

		while (inputNumber == 0) {
			try {
				// findUser
				inputNumber = Integer.parseInt(key);
				rUser = cDatabase.findUserByID(inputNumber);

				if (rUser == null) {
					printMessageToView("ID is not found.");
					pause(2);
					// back to main menu
					scene = SCENE_MAIN_MENU;
					return;
				}

				printMessageToView("User ID:" + rUser.getID() + " Name:" + rUser.getFirstName() + " "
						+ rUser.getLastName() + "will be deleted. OK? (YES:y)");

				key = cView.userInput();
				if (!key.equalsIgnoreCase("Y")) {
					printMessageToView("The transaction is canceled.");
					pause(2);
					scene = SCENE_MAIN_MENU;
					return;
				}

				cDatabase.deleteUser(rUser);
				/*
				 * if(rUser.getClass().getName().equalsIgnoreCase("Manager"))
				 * cDatabase.updateUserFile(true);//update manager file else
				 * cDatabase.updateUserFile(false);//update employee file
				 */

				printMessageToView("Deleted.");
				pause(2);
			} catch (Exception e) {
				printErrorMessageToView("ID must be valid number. Input again:");
				key = cView.userInput();
			}
		}
	}

	private void printMessageToView(String message) {
		cView.displayMessage(message);
	}

	private void printErrorMessageToView(String message) {
		cView.displayErrorMessage(message);
	}

	/***********************************************************
	 * Property mode
	 **********************************************************/
	// ----------------------------------------------------------
	// Choose Property mode (1:Create Property 2:Selled Property 3:Cancel Property)
	// ----------------------------------------------------------
	public void selectPropertyMenu() {
		String key;
		int inputNumber = 0;

		User rUser = cDatabase.findUserByID(currentUserID);

		while (inputNumber == 0) {
			cView.showPropertyMenu();
			printMessageToView("Choose number:");
			key = cView.userInput();

			if (key.equalsIgnoreCase("Q")) // Back to main menu
			{
				scene = SCENE_MAIN_MENU;
				return;
			}

			try {
				inputNumber = Integer.parseInt(key);
				if (inputNumber < 1 || 5 < inputNumber) {
					inputNumber = 0;
					printErrorMessageToView("Choose 1 to 5:");
					pause(2);
				}
			} catch (Exception e) {
				printErrorMessageToView("Choose 1 to 5:");
				pause(2);
			}
		}

		switch (inputNumber) {
		case 1: // Create
			createProperty();
			break;
		case 2: // Update
			updateProperty();
			break;
		case 3:// Close
			closeProperty();
			break;
		case 4:// Cancel
			cancelProperty();
			break;
		case 5:// Show Property list
			showPropertyList();
			
			break;
		default:
			printErrorMessageToView("This line must not be exexuted!! Check program of selectPropertyMenu()");
			key = cView.userInput();
			break;
		}
	}

	private void showPropertyList() {
		boolean done = false;
		String key;

		while (!done) {
			cView.showPropertyList();
			printMessageToView("Enter Property ID to display detail. (Q:quit)");
			key = cView.userInput();
			if (key.equalsIgnoreCase("Q")) // Exit
			{
				return;
			}

			try {
				int ID = Integer.parseInt(key);
				Property rProperty = cDatabase.findPropertyByID(ID);
				if (rProperty == null) {
					printErrorMessageToView("Not found.");
					pause(2);
				} else {
					cView.clearScreen();
					
					printMessageToView("Please enter something to exit.");
					key = cView.userInput();
					done = true;
				}
			} catch (Exception e) {
				printErrorMessageToView("Enter valid integer.");
				pause(2);
			}
		}
	}

	private void createProperty() {
		int newPropertyID = cDatabase.addProperty(currentUserID, currentUserName);
		editPropertyItem(newPropertyID);
	}

	private void updateProperty() {
		cView.showPropertyList();
		int updatePropertyID = findProperty();
		if (updatePropertyID == -1)
			return;

		Property rProperty = cDatabase.findPropertyByID(updatePropertyID);
		if (currentUserID != rProperty.getUserID()) {
			printErrorMessageToView("You are not eligible to update the Property.");
			printMessageToView("(The Property belonges to " + rProperty.getUserName() + ")");
			pause(2);
			return;
		}

		int PropertyState = rProperty.getState();
		switch (PropertyState) {
		case Property.Property_CLOSED:
			printMessageToView("The Property is already selled.");
			pause(2);
			break;
		case Property.Property_CANCELED:
			printMessageToView("The Property was canceled.");
			pause(2);
			break;
		default:
			editPropertyItem(updatePropertyID);
			break;
		}

	}

	private void editPropertyItem(int editPropertyID) {
		boolean done = false;
		String key;
		int inputNumber = 0;

		while (!done) {
			cView.editPropertyView();
			printMessageToView("Choose number:");
			key = cView.userInput();

			if (key.equalsIgnoreCase("Q")) // Exit
			{
				done = true;
			} else {
				try {
					inputNumber = Integer.parseInt(key);
					switch (inputNumber) {
					case 1: // add new item
						addNewPropertyItem(editPropertyID);
						break;
					case 2:
						deletePropertyItem(editPropertyID);
						break;
					case 3: // showPropertyDetail
						cView.clearScreen();
						
						printMessageToView("Please enter something to exit.");
						key = cView.userInput();
						break;
					default:
						printMessageToView("Choose 1 to 4.");
						pause(2);
						break;
					}
				} catch (Exception e) {
					printMessageToView("Choose 1 to 4.");
					pause(2);
				}
			}
		}
	}

	public void addNewPropertyItem(int PropertyID) {
		boolean done = false;
		int addItemID = 0;
		byte addItemQuantity = 0;
		// MenuItem rNewItem = null;
		String key;

		while (!done) {
			cView.addPropertyItemView();
			// input menu id
			while (addItemID == 0) {
				try {
					printMessageToView("Choose MenuID:");
					key = cView.userInput();
					if (key.equalsIgnoreCase("Q")) // Exit
					{
						printMessageToView("Transaction canceled.");
						pause(2);
						return;
					}
					addItemID = Integer.parseInt(key);
//                    rNewItem = cDatabase.findMenuItemByID(addItemID);
//                    if(rNewItem == null)
//                    {
//                        printErrorMessageToView("MenuID[" + addItemID + "]is not found.");
//                        addItemID = 0;
//                    }
				} catch (Exception e) {
					printErrorMessageToView("Enter valid id number.");
				}
			}

			// input quantity
			while (addItemQuantity == 0) {
				try {
					printMessageToView("Enter quantity:");
					key = cView.userInput();
					if (key.equalsIgnoreCase("Q")) // Exit
					{
						printMessageToView("Transaction canceled.");
						pause(2);
						return;
					}
					addItemQuantity = Byte.parseByte(key);
					if (addItemQuantity <= 0) {
						printErrorMessageToView("Enter positive number.");
						addItemQuantity = 0;
					}
				} catch (NumberFormatException nfe) {
					printErrorMessageToView("Quantity is too large!!");
				} catch (Exception e) {
					printErrorMessageToView("Enter valid id number.");
				}
			}

			// Check all input
			printMessageToView("MenuID:" + addItemID + " Quantity:" + addItemQuantity);

			printMessageToView("OK?(yes:y)");
			key = cView.userInput();
			if (!key.equalsIgnoreCase("Y")) {
				printMessageToView("canceled.");
				addItemID = 0;
				addItemQuantity = 0;
				// rNewItem = null;
				continue; // back to beginning the loop
			}

			////////// ADD!!!(database)/////////////
			//cDatabase.addPropertyItem(PropertyID, addItemQuantity);

			printMessageToView("Add another item?(yes:y)");
			key = cView.userInput();
			if (!key.equalsIgnoreCase("Y"))// finish adding item
			{
				done = true;
			} else// continue adding item
			{
				// initialize
				addItemID = 0;
				addItemQuantity = 0;
				// rNewItem = null;
			}
		}
	}

	public void deletePropertyItem(int PropertyID) {
		String key;
		boolean done = false;
		int deleteNo = 0;

		Property rProperty = cDatabase.findPropertyByID(PropertyID);
		if (currentUserID != rProperty.getUserID()) {
			printErrorMessageToView("You are not eligible to delete the Property.");
			printMessageToView("(The Property belonges to " + rProperty.getUserName() + ")");
			pause(2);
			return;
		}

		while (!done) {
			try {
				// show Property detail///////
				cView.deletePropertyItemView();
				//cView.showPropertyDetail(PropertyID);
				printMessageToView("Choose number to delete or type Q to exit):");
				key = cView.userInput();
				if (key.equalsIgnoreCase("Q")) // Exit
				{
					return;
				}
				deleteNo = Integer.parseInt(key) - 1; // index actually starts from zero
//				if (!cDatabase.deletePropertyItem(PropertyID, deleteNo)) {
//					printErrorMessageToView("Not found.");
//					pause(2);
//					continue; // delete error
//				}
				cView.deletePropertyItemView();
				//cView.showPropertyDetail(PropertyID);
				printMessageToView("Deleted.");
				printMessageToView("Delete another item?(yes:y)");
				key = cView.userInput();
				if (!key.equalsIgnoreCase("Y"))
					done = true;
			} catch (Exception e) {
				printErrorMessageToView("Enter valid integer.");
				pause(2);
			}
		}
	}

	private void closeProperty() {
		cView.closePropertyView();

		int closePropertyID = findProperty();
		if (closePropertyID == -1)
			return;

		Property rProperty = cDatabase.findPropertyByID(closePropertyID);
		if (currentUserID != rProperty.getUserID()) {
			printErrorMessageToView("You are not eligible to delete the Property.");
			printMessageToView("(The Property belonges to " + rProperty.getUserName() + ")");
			pause(3);
			return;
		}

		if (rProperty.getState() != 0) {
			printMessageToView("The Property is already closed or canceled.");
			pause(2);
			return;
		}

		printMessageToView("Are you sure to close this Property?(YES:y)");
		String key = cView.userInput();

		if (key.equalsIgnoreCase("Y"))// back to previous menu
		{
			cDatabase.closeProperty(closePropertyID);
			printMessageToView("The Property have been closed.");
			pause(2);
		}
	}

	private void cancelProperty() {
		cView.cancelPropertyView();

		int cancelPropertyID = findProperty();
		if (cancelPropertyID == -1)
			return;

		Property rProperty = cDatabase.findPropertyByID(cancelPropertyID);
		if (currentUserID != rProperty.getUserID()) {
			printErrorMessageToView("You are not eligible to delete the Property.");
			printMessageToView("(The Property belonges to " + rProperty.getUserName() + ")");
			pause(3);
			return;
		}

		if (rProperty.getState() != 0) {
			printMessageToView("The Property is already closed or canceled.");
			pause(2);
			return;
		}

		printMessageToView("Are you sure to cancel this Property?(YES:y)");
		String key = cView.userInput();

		if (key.equalsIgnoreCase("Y"))// back to previous menu
		{
			cDatabase.cancelProperty(cancelPropertyID);
			printMessageToView("The Property have been canceled.");
			pause(2);
		}
	}

	private int findProperty() {
		String key;
		int imputID = -1;

		while (imputID == -1) {
			printMessageToView("Choose PropertyID:");
			key = cView.userInput();

			if (key.equalsIgnoreCase("Q"))// back to previous menu
			{
				break;
			}

			try {
				imputID = Integer.parseInt(key);
				if (imputID < 0) {
					printErrorMessageToView("ID must be positive integer.");
					imputID = -1;// initiarise
					continue; // back to begining of loop
				}

				Property rProperty = cDatabase.findPropertyByID(imputID);
				if (rProperty == null)// Property not found
				{
					printErrorMessageToView("PropertyID[" + imputID + "]is not found.");
					imputID = -1;// initiarise
					continue; // back to begining of loop
				}
			} catch (Exception e) {
				printMessageToView("Enter valid Integer.");
			}
		}
		return imputID;
	}

	/***********************************************************
	 * Display database data
	 **********************************************************/

	private void showUserList() {
		cView.showUserList();
		printMessageToView("Please enter something to exit.");
		cView.userInput();
		// back to main menu
		scene = SCENE_MAIN_MENU;
	}

	// create pause for some seconds
	private void pause(long secs) {
		try {
			Thread.currentThread().sleep(secs * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

 class DatabaseException extends Exception {
	  public String errMsg;
	    public DatabaseException(String msg)
	    { 
	        errMsg = msg;
	    }
	    
	    public String getErrMessage()
	    {
	        return errMsg;
	    }
}


public class Demo {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		Controller controller = new Controller();

		printWelcome();
		System.out.println(
				"Please enter the UserType :\n\n"+ "1:Manager\n" + "2:Seller\n" + "3:Buyer ");
		int choise = input.nextInt();

		switch (choise) {

		case 1:
			System.out.println("You are as a Manager.Please enter your choise\n\n " + "1:UserManagement:\n" 
					+ "2:PropertyManagement:\n");
			int choiseOfManager = input.nextInt();
			switch (choiseOfManager) {
			case 1:
				controller.chooseEditUserMode();
				break;
			case 2:
				controller.selectPropertyMenu();
				break;
			default:
				System.out.println("ERROR: Invalid Selection");
				exitApplication();

			}

			break;
		case 2:
			System.out.println("You are as Seller :");
			break;
		case 3:
			System.out.println("You are as Buyer  :");
			break;

		default:
			System.out.println("ERROR: Invalid Selection");
			exitApplication();

		}

	}

	public static void printWelcome() {

		System.out.println(
				"****************** Hello! Welcome to RealEstateManager from University Shahrekord! ******************");
	}

	/**
	 * Displays the exiting message.
	 */
	public static void exitApplication() {

		System.out.println("Backing up data before exiting...");

		System.out.println("********* Bye! Thank you for using  *********");

	}

}

