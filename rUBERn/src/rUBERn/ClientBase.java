package rUBERn;

import java.util.*;

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
	 String[] columns = {"name", "credit card number"};
	 Object[][] data = new Object[users.size()][2];
	 for (int i=0; i<arrayUsers.length; i++) {
		 for (int j=0; j<2; j++) {
			 if(j==0) {
	 data[i][j] = arrayUsers[i].getName();
			 }else {
				 data[i][j] = arrayUsers[i].getCard();
			 }
	 }
		 }
	 new UserList(columns, data);
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

}
