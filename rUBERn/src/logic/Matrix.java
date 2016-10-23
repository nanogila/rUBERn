package logic;

//import java.util.Scanner;

public class Matrix {
	ClientBase base;
	DriverBase driverBase;
	public Matrix (ClientBase database, DriverBase aDriverBase) {
		driverBase = aDriverBase;
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
	public boolean checkPassword(String aUser , String aPassword){
		return base.checkPassword(aUser , aPassword);
	}
	public boolean addDriver(Driver aDriver) {
		return driverBase.addDriver(aDriver);
	}
	public boolean removeDriver(Driver aDriver) {
		return driverBase.removeDriver(aDriver);
	}
	public void seeDrivers() {
		driverBase.seeDrivers();
	}
	public Driver getDriver(String aName) {
		return driverBase.getDriver(aName);
	}
	public boolean updateDriverLocation(long x, long y, String aName) {
		return driverBase.updateDriverLocation(x, y, aName);
	}
	public boolean checkDriverPassword(String aDriver, String aPassword) {
		return driverBase.checkPassword(aDriver, aPassword);
	}
}
