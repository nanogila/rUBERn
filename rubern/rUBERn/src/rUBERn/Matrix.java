package rUBERn;

//import java.util.Scanner;

public class Matrix {
	ClientBase base;
	public Matrix (ClientBase database) {
		base = database;
	}
	public void addUser(User aUser) {
		base.addUser(aUser);
	}
	public void seeUsers() {
		base.seeUsers();
	}
}
