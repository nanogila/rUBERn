package logic;

import java.math.BigDecimal;
import java.math.RoundingMode;

import GUI.YesOrNoGUI;

public class Driver extends Person {

    private Car theCar;
    private Status status;
    public Driver(String aName, Integer aCardNumber, String aPassword,Car aCar) {
        name = aName;
        card = new CreditCard(aName, aCardNumber);
        location = new Gps();
        password = aPassword;
        theCar = aCar;
        status=Status.OFFLINE;
    }
    public Car getCar() {
    	return theCar;
    }
    public String getCarModel() {
    	return theCar.getModel();
    }
    public boolean goOnline() {
    	if(status.equals(Status.ONLINE)) return false;
    	else {
    		status=Status.ONLINE; 
    		return true;
    	}
    }
    public boolean goOffline() {
    	if(status.equals(Status.OFFLINE)) return false;
    	else {
    		status=Status.OFFLINE; 
    		return true;
    	}
    }
    public Boolean isAvailable() {
    	if (status.equals(Status.ONLINE)) return true;
    	return false;
    }
    public String getStatus() {
    	return status.toString();
    }
    public boolean startTrip(){
    	status=Status.UNAVAILABLE;
boolean tripSuccessful = new YesOrNoGUI().showYesNoMessage("Did the trip end "+getName()+" ?");
    if (tripSuccessful) {
    	goOnline();
    	return true;
    }else return startTrip();
    }
    public int getCarQuality() {
    	return theCar.getCarQuality();
    }

}
