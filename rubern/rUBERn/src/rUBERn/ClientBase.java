package rUBERn;

import java.util.*;

public class ClientBase {
private List<User> users;
public ClientBase() {
	users= new ArrayList<User>();
}
public void addUser (User aUser) {
	if (checkName(aUser)) {
		Error dialog = new Error(aUser.getName()+" ya esta registrado");
	}else users.add(aUser);
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
}
