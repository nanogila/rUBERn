package rUBERn;

import java.util.*;

public class ClientBase {
private List<User> users;
public ClientBase() {
	users= new ArrayList<User>();
}
public void addUser (User aUser) {
	if (checkName(aUser)) {
		new Error(aUser.getName()+" is already registered");
	}else if(aUser.getName().equals("")){
		new Error("name is empty");
	} else if (checkCard(aUser)) {
		new Error("credit card number "+aUser.getCard()+" is already registered");
	}
	else {
		users.add(aUser);
		new Error("User successfully added");
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
public boolean checkCard(User aUser) {
	User[] arrayUsers = new User[users.size()];
	 users.toArray(arrayUsers);
	for (int i=0; i<arrayUsers.length; i++) {
	if (aUser.getCard().equals(arrayUsers[i].getCard())) {
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
}