package logic;

//import java.util.Scanner;

public class Matrix {
	ClientBase base;
	public Matrix (ClientBase database) {
		base = database;
	}
	public boolean addUser(User aUser) {
		
		return base.addUser(aUser);
		
	}
	public boolean removeUser(User aUser) {
		
		return base.removeUser(aUser);
		
	}
	public void seeUsers() {
		base.seeUsers();
	}
	public User getUser(String aName) {
		return base.getUser(aName);
	}
	public boolean updateUserLocation (long x, long y, String aName) {
		return base.updateUserLocation(x, y, aName);
	}

}
