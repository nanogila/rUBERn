package logic;

import java.util.*;

import GUI.Error;
import GUI.UserListGUI;

public class ClientBase {
private List<User> users;
public ClientBase() {
	users= new ArrayList<User>();
}
public boolean addUser (User aUser) {
	if (checkName(aUser)) {
		new Error(aUser.getName()+" is already registered");
		return false;
	}else if(aUser.getName().equals("")){
		new Error("name is empty");
		return false;
	}else {
		users.add(aUser);
		new Error("User successfully added");
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
public boolean removeUser(User aUser) {
	if(aUser.getName().equals("")){
		new Error("name is empty");
		
		return false;
	}else if (!checkName(aUser)) {
		new Error(aUser.getName()+" is not registered");
		return false;
	}else {
		users.remove(aUser);
		new Error("User successfully removed");
		return true;
	}
}
public User getUser(String aName) {
	User[] arrayUsers = new User[users.size()];
	 users.toArray(arrayUsers);
	for (int i=0; i<arrayUsers.length; i++) {
	if (aName.toLowerCase().equals(arrayUsers[i].getName().toLowerCase())) {
		return arrayUsers[i];
	}
	}
	return null;
}
public boolean updateUserLocation (long X, long Y, String aName){
	if(aName.equals("")){
		new Error("name is empty");
		
		return false;
	}else if (getUser(aName)==null) {
		new Error(aName+" is not registered");
		return false;
	}
	else {
		User aUser = getUser(aName);
		aUser.updateLocation(X, Y);
		new Error("Location successfully updated");
		return true;
	}
}
public boolean checkPassword(String aUser , String aPassword){
	if(aUser.equals("")){
		new Error("Name can't be empty");
		return false;
	}
	User theUser = getUser(aUser);
	if(theUser== null){
		return false;
	}
	if(aPassword.equals("")){
		new Error("Password can't be empty");
		return false;
	}
	else if(aPassword.equals(theUser.getPassword())){
		return true;
	}

	return false;
}

}
