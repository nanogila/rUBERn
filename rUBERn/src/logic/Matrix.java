package logic;

//import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
	ClientBase base;
	DriverBase driverBase;
	Accountant theAccountant;
	public Matrix (ClientBase database, DriverBase aDriverBase) {
		driverBase = aDriverBase;
		base = database;
		theAccountant = new Accountant();

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
	public boolean askForCar(User aUser, long[] aDestination){
		List<Trip> possibleTrips = new ArrayList<>();
	for(Driver aDriver : driverBase.getDriverList()){
		if(aDriver.isAvailable()){
			possibleTrips.add(new Trip(aDriver, aUser , aDestination));
		}
	}

	Trip selectedTrip = possibleTrips.get(0);
	for(Trip aTrip : possibleTrips){
		if(theAccountant.imageCost(aTrip)< theAccountant.imageCost(selectedTrip)){
			selectedTrip = aTrip;
		}

	}
	if(selectedTrip.getDriver().decideTrip()){
		return true;
	}
	else return false;


	}
}
