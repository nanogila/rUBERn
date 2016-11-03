package logic;

//import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

import GUI.*;
import GUI.Error;

public class Matrix {
	private ClientBase base;
	private DriverBase driverBase;
	private TagBase tagBase;
	private Accountant theAccountant;
	private long maximumDistance;
	public Matrix (ClientBase database, DriverBase aDriverBase) {
		driverBase = aDriverBase;
		base = database;
		theAccountant = new Accountant(base, driverBase);
		tagBase = new TagBase();
		maximumDistance=5000;
	}
	public void addDefaultTags() {
tagBase.addTag(new QualityTag("VIP", 8));
tagBase.addTag(new QualityTag("High", 6));
tagBase.addTag(new QualityTag("Medium", 4));
tagBase.addTag(new QualityTag("Low", 2));
	}
	public void changeMaximumDriverDistance(long aDistance) {
		aDistance = Math.abs(aDistance);
		maximumDistance=aDistance;
	}
	public long getMaximumDriverDistance() {
		return maximumDistance;
	}
	public boolean addTag(QualityTag aTag) {
		return tagBase.addTag(aTag);
	}
	public void seeTags() {
		tagBase.seeTags();
	}
	public boolean addUser(User aUser) {

		return base.addUser(aUser);

	}
	public String[] getTagNames() {
		return tagBase.getTagNames();
	}
	public QualityTag getTag(String aTagName) {
		return tagBase.getTag(aTagName);
	}
	public boolean setTagName(String aTagName, String aName) {
		return tagBase.setQualityTagName(aTagName, aName);
				}
	public boolean setTagValue(String aTagName, int aValue) {
		return tagBase.setQualityTagValue(aTagName, aValue);
				}
	public double addMoney(User aUser, double amount) {
		return theAccountant.addMoney(aUser, amount);
	}
	public double addMoney (Driver aDriver, double amount) {
		return theAccountant.addMoney(aDriver, amount);
	}
	public boolean removeMoney(User aUser, double amount, String aDescription) {
		return theAccountant.removeMoney(aUser, amount, aDescription);
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
	public boolean askForCar(User aUser, long[] aDestination, int people) {
		List<Driver> blacklist = new ArrayList<>(); 
		return askForCar(aUser, aDestination, people, blacklist);
	}
	
	private boolean askForCar(User aUser, long[] aDestination, int people, List<Driver> blacklist){
if(!aUser.isTravelling()) {
		List<Trip> possibleTrips = new ArrayList<>();
		for(Driver aDriver : driverBase.getDriverList()){
		if(aDriver.isAvailable() && aDriver.getCar().getCapacity()>=people && aDriver.getDistance(aUser)<maximumDistance && !(blacklist.contains(aDriver))){
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
	
	if (aUser.getBalance()>=theAccountant.tripCost(selectedTrip)) {
		boolean accepted = new YesOrNoGUI().showYesNoMessage("Do you wish to accept the trip "+selectedTrip.getDriver().getName()+" ?");
		if (accepted) {
			aUser.startTrip();
			if(selectedTrip.getDriver().startTrip()) {
		if (removeMoney(aUser, theAccountant.tripCost(selectedTrip), Accountant.roundUp(selectedTrip.getDistance())+" long trip")) {
			theAccountant.addMoney(selectedTrip.getDriver(), theAccountant.tripCost(selectedTrip), Accountant.roundUp(selectedTrip.getDistance())+" long trip");
			aUser.endTrip();
			return true;
		}
		}
			}else {
			blacklist.add(selectedTrip.getDriver());
			return askForCar(aUser, aDestination, people, blacklist);
		}
	}
	else {
		new Error ("Not enough money");
			return false;
			//aca hay que ver que hacer si el cliente no tiene biyuya
		}
		
	}else {
		new Error ("No drivers are available at this time");
	return false;
	}return false;
	}else {
		new Error("You are already on a car");
		return false;
	}
	}
	public String getLogFileLocation() {
		return theAccountant.getLogFileLocation();
	}
	
	
}
