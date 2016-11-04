package logic;

import java.util.*;

import GUI.Error;
import GUI.UserListGUI;
import exceptions.*;

public class ClientBase {
private List<User> users;
public ClientBase() {
	users= new ArrayList<User>();
}
public boolean addUser (User aUser) throws AlreadyRegisteredException, EmptyFieldException {
	if (checkName(aUser)) {
		throw new AlreadyRegisteredException(aUser.getName());
	}else if(aUser.getName().equals("")){
		throw new EmptyFieldException("name");
	}
	else {
		users.add(aUser);
		return true;
	}
	
}
public boolean checkName(User aUser) {
	User[] arrayUsers = new User[users.size()];
	 users.toArray(arrayUsers);
	for (int i=0; i<arrayUsers.length; i++) {
	if (aUser.getName().toLowerCase().equals(arrayUsers[i].getName().toLowerCase())) {
return true;
	}
	}
	return false;
}
public void seeUsers() {
	User[] arrayUsers = new User[users.size()];
	 users.toArray(arrayUsers);
	 String[] columns = {"Username", "Credit card number", "Location", "money"};
	 Object[][] data = new Object[users.size()][columns.length];
	 for (int i=0; i<arrayUsers.length; i++) {
		 for (int j=0; j<columns.length; j++) {
			 if(j==0) {
	 data[i][j] = arrayUsers[i].getName();
			 }else if (j==1){
				 data[i][j] = arrayUsers[i].getCardNumber();
			 }else if (j==2){
				 data[i][j] = arrayUsers[i].getLocationToString();
			 }else {
				 data[i][j] = arrayUsers[i].getBalance();
			 }
	 }
		 }
	 new UserListGUI(columns, data);
}
public boolean removeUser(User aUser) throws EmptyFieldException, ItemNotFoundException{
	if(aUser.getName().equals("")){
		throw new EmptyFieldException("name");
	}else if (!checkName(aUser)) {
		throw new ItemNotFoundException(aUser.getName());
	}else {
		users.remove(aUser);
		return true;
	}
}
public User getUser(String aName)  throws ItemNotFoundException, EmptyFieldException{
	if (aName.equals("")) throw new EmptyFieldException("name");
	User[] arrayUsers = new User[users.size()];
	 users.toArray(arrayUsers);
	for (int i=0; i<arrayUsers.length; i++) {
	if (aName.toLowerCase().equals(arrayUsers[i].getName().toLowerCase())) {
		return arrayUsers[i];
	}
	}
	throw new ItemNotFoundException(aName);
}
public double addMoney(String aName, double amount) throws EmptyFieldException, ItemNotFoundException{
		User aUser = getUser(aName);
		return aUser.addMoney(amount);
}
public boolean removeMoney(String aName, double amount) throws NotEnoughMoneyException, ItemNotFoundException, EmptyFieldException {
		User aUser = getUser(aName);
		if(aUser.removeMoney(amount)) {
			new Error (aName+" now has $"+aUser.getBalance()+" in his bank account");
		return true;
		}else return false;
}
public boolean updateUserLocation (long X, long Y, String aName) throws ItemNotFoundException, EmptyFieldException{
		User aUser = getUser(aName);
		aUser.updateLocation(X, Y);
		new Error("Location successfully updated");
		return true;
}
public boolean checkPassword(String aUser , String aPassword) throws EmptyFieldException{
	User theUser;
	try {
		theUser = getUser(aUser);
	} catch (EmptyFieldException | ItemNotFoundException e) {
		return false;
	}
	if(aPassword.equals("")){
		throw new EmptyFieldException("password");
	}
	else if(aPassword.equals(theUser.getPassword())){
		return true;
	}

	return false;
}

}
