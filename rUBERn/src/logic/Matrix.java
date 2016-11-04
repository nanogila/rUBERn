package logic;

//import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

import GUI.*;
import GUI.Error;
import exceptions.AlreadyRegisteredException;
import exceptions.EmptyFieldException;
import exceptions.InvalidRatingException;
import exceptions.InvalidTripException;
import exceptions.ItemNotFoundException;
import exceptions.NotEnoughMoneyException;

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
	public void addDefaultTags() throws InvalidRatingException, AlreadyRegisteredException, EmptyFieldException {
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
	public boolean addTag(QualityTag aTag) throws AlreadyRegisteredException, EmptyFieldException {
		return tagBase.addTag(aTag);
	}
	public void seeTags() {
		tagBase.seeTags();
	}
	public boolean addUser(User aUser) throws EmptyFieldException, AlreadyRegisteredException {

		return base.addUser(aUser);

	}
	public String[] getTagNames() {
		return tagBase.getTagNames();
	}
	public QualityTag getTag(String aTagName) throws ItemNotFoundException {
		return tagBase.getTag(aTagName);
	}
	public boolean setTagName(String aTagName, String aName) throws ItemNotFoundException {
		return tagBase.setQualityTagName(aTagName, aName);
				}
	public boolean setTagValue(String aTagName, int aValue) throws InvalidRatingException, ItemNotFoundException {
		return tagBase.setQualityTagValue(aTagName, aValue);
				}
	public double addMoney(User aUser, double amount) throws EmptyFieldException, ItemNotFoundException {
		return theAccountant.addMoney(aUser, amount);
	}
	public double addMoney (Driver aDriver, double amount) throws ItemNotFoundException, EmptyFieldException {
		return theAccountant.addMoney(aDriver, amount);
	}
	public boolean removeMoney(User aUser, double amount, String aDescription) throws NotEnoughMoneyException, ItemNotFoundException, EmptyFieldException {
		return theAccountant.removeMoney(aUser, amount, aDescription);
	}
	public boolean removeMoney (Driver aDriver, double amount) throws NotEnoughMoneyException, ItemNotFoundException, EmptyFieldException {
		return theAccountant.removeMoney(aDriver, amount);
	}
	public boolean removeUser(User aUser) throws EmptyFieldException, ItemNotFoundException {

		return base.removeUser(aUser);

	}
	public void seeUsers() {
		base.seeUsers();
	}
	public User getUser(String aName) throws ItemNotFoundException, EmptyFieldException {
		return base.getUser(aName);
	}
	
	public boolean updateUserLocation (long x, long y, String aName) throws ItemNotFoundException, EmptyFieldException {
		return base.updateUserLocation(x, y, aName);
	}
	public boolean checkPassword(String aUser , String aPassword) throws EmptyFieldException {
		return base.checkPassword(aUser , aPassword);
	}
	public boolean addDriver(Driver aDriver) throws AlreadyRegisteredException, EmptyFieldException {
		return driverBase.addDriver(aDriver);
	}
	public boolean removeDriver(Driver aDriver) throws ItemNotFoundException, EmptyFieldException {
		return driverBase.removeDriver(aDriver);
	}
	public void seeDrivers() {
		driverBase.seeDrivers();
	}
	public Driver getDriver(String aName) throws EmptyFieldException, ItemNotFoundException {
		return driverBase.getDriver(aName);
	}
	public boolean updateDriverLocation(long x, long y, String aName) throws ItemNotFoundException, EmptyFieldException {
		return driverBase.updateDriverLocation(x, y, aName);
	}
	public void addMoney(Person aPerson, double someMoney) {
		aPerson.addMoney(someMoney);
	}
	public boolean checkDriverPassword(String aDriver, String aPassword) throws EmptyFieldException {
		return driverBase.checkPassword(aDriver, aPassword);
	}
	public boolean askForCar(User aUser, long[] aDestination, int people) throws NotEnoughMoneyException, ItemNotFoundException, EmptyFieldException, InvalidTripException {
		List<Driver> blacklist = new ArrayList<>(); 
		return askForCar(aUser, aDestination, people, blacklist);
	}
	
	private boolean askForCar(User aUser, long[] aDestination, int people, List<Driver> blacklist) throws NotEnoughMoneyException, ItemNotFoundException, EmptyFieldException, InvalidTripException{
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
			boolean clientAccepted = new YesOrNoGUI().showYesNoMessage("Do you wish to accept the trip "+selectedTrip.getClient().getName()+" ? the driver has a "+selectedTrip.getDriver().getCarModel());
			if(clientAccepted) {
			aUser.startTrip();
			if(selectedTrip.getDriver().startTrip()) {
		if (removeMoney(aUser, theAccountant.tripCost(selectedTrip), Accountant.roundUp(selectedTrip.getDistance())+" long trip")) {
			theAccountant.payDriver(selectedTrip.getDriver(), theAccountant.tripCost(selectedTrip), Accountant.roundUp(selectedTrip.getDistance())+" long trip");
			aUser.endTrip();
			return true;
		}
		}
			}else {
			blacklist.add(selectedTrip.getDriver());
			return askForCar(aUser, aDestination, people, blacklist);
		}
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
