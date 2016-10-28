package logic;

//import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

import GUI.*;
import GUI.Error;

public class Matrix {
	ClientBase base;
	DriverBase driverBase;
	Accountant theAccountant;
	public Matrix (ClientBase database, DriverBase aDriverBase) {
		driverBase = aDriverBase;
		base = database;
		theAccountant = new Accountant(base, driverBase);

	}
	public boolean addUser(User aUser) {

		return base.addUser(aUser);

	}
	public boolean addMoney(User aUser, double amount) {
		return theAccountant.addMoney(aUser, amount);
	}
	public boolean addMoney (Driver aDriver, double amount) {
		return theAccountant.addMoney(aDriver, amount);
	}
	public boolean removeMoney(User aUser, double amount) {
		return theAccountant.removeMoney(aUser, amount);
	}
	public boolean removeMoney (Driver aDriver, double amount) {
		return theAccountant.removeMoney(aDriver, amount);
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
	public void addMoney(Person aPerson, double someMoney) {
		aPerson.addMoney(someMoney);
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
	Trip selectedTrip;
	if (possibleTrips.size()>0) {
		selectedTrip = possibleTrips.get(0);	
	for(Trip aTrip : possibleTrips){
		if(theAccountant.imageCost(aTrip)< theAccountant.imageCost(selectedTrip)){
			selectedTrip = aTrip;
		}
	}
	boolean accepted = new YesOrNoGUI().showYesNoMessage("Driver accept the trip", "Do you wish to accept the trip?");
	if (accepted) {
		if (aUser.removeMoney(theAccountant.tripCost(selectedTrip))) {
			selectedTrip.getDriver().addMoney(theAccountant.tripCost(selectedTrip));
			return true;
		}else {
			new Error ("You ain't got enough money pal");
			return false;
			//aca hay que ver que hacer si el cliente no tiene biyuya
		}
		
	}else {
		new Error ("The driver didn't accept");
		//aca deberiamos eliminar a ese driver y correr de vuelta el metodo para que otro driver se gane el viaje
		return false;
	}
	}else {
		new Error ("No drivers are available at this time");
	return false;
	}
	}
}
