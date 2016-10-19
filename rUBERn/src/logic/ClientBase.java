package logic;
//algo2
import java.util.*;

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
	if (aUser.getName().equals(arrayUsers[i].getName())) {
return true;
	}
	}
	return false;
}
public void seeUsers() {
	User[] arrayUsers = new User[users.size()];
	 users.toArray(arrayUsers);
	 String[] columns = {"Name", "Credit card number", "Location"};
	 Object[][] data = new Object[users.size()][3];
	 for (int i=0; i<arrayUsers.length; i++) {
		 for (int j=0; j<3; j++) {
			 if(j==0) {
	 data[i][j] = arrayUsers[i].getName();
			 }else if (j==1){
				 data[i][j] = arrayUsers[i].getCard();
			 }else {
				 data[i][j] = arrayUsers[i].getLocation();
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
	if (aName.equals(arrayUsers[i].getName())) {
		return arrayUsers[i];
	}
	}
	new Error(aName+" is not registered");
	return null;
}
public boolean updateUserLocation (long X, long Y, String aName){
	if(aName.equals("")){
		new Error("name is empty");
		
		return false;
	}else if (!checkName(getUser(aName))) {
		return false;
	}else {
		User aUser = getUser(aName);
		aUser.updateLocation(X, Y);
		new Error("Location successfully updated");
		return true;
	}
}
}
