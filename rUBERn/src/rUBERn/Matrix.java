package rUBERn;

//import java.util.Scanner;

public class Matrix {
	ClientBase base;
	public Matrix (ClientBase database) {
		base = database;
	}
	public boolean addUser(User aUser) {
		
		return base.addUser(aUser);
		
	}
	public void seeUsers() {
		base.seeUsers();
	}
}
