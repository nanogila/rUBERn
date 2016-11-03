package logic;

import java.util.ArrayList;
import java.util.List;

import GUI.*;
import GUI.Error;

public class DriverBase {
	private List<Driver> drivers;
	public DriverBase() {
		drivers= new ArrayList<Driver>();
	}
	public boolean addDriver (Driver aDriver) {
		if (checkName(aDriver)) {
			new Error(aDriver.getName()+" is already registered");
			return false;
		}else if(aDriver.getName().equals("")){
			new Error("name is empty");
			return false;
		}else {
			drivers.add(aDriver);
			new Error("Driver successfully added");
			return true;
		}
		
	}
	public boolean checkName(Driver aDriver) {
		Driver[] arrayDrivers = new Driver[drivers.size()];
		 drivers.toArray(arrayDrivers);
		for (int i=0; i<arrayDrivers.length; i++) {
		if (aDriver.getName().toLowerCase().equals(arrayDrivers[i].getName().toLowerCase())) {
	return true;
		}
		}
		return false;
	}
	public void seeDrivers() {
		Driver[] arrayDrivers = new Driver[drivers.size()];
		 drivers.toArray(arrayDrivers);
		 String[] columns = {"Driver name", "Credit card number", "Location", "Car", "status", "money"};
		 Object[][] data = new Object[drivers.size()][columns.length];
		 for (int i=0; i<arrayDrivers.length; i++) {
			 for (int j=0; j<columns.length; j++) {
				 if(j==0) {
		 data[i][j] = arrayDrivers[i].getName();
				 }else if (j==1){
					 data[i][j] = arrayDrivers[i].getCardNumber();
				 }else if (j==2){
					 data[i][j] = arrayDrivers[i].getLocationToString();
				 }else if (j==3){
					 data[i][j] = arrayDrivers[i].getCarModel();
				 }else if (j==4){
					 data[i][j] = arrayDrivers[i].getStatus();
				 }else {
					 data[i][j] = arrayDrivers[i].getBalance();
				 }
		 }
			 }
		 new UserListGUI(columns, data);
	}
	public boolean removeDriver(Driver aDriver) {
		if(aDriver.getName().equals("")){
			new Error("name is empty");
			
			return false;
		}else if (!checkName(aDriver)) {
			new Error(aDriver.getName()+" is not registered");
			return false;
		}else {
			drivers.remove(aDriver);
			new Error("Driver successfully removed");
			return true;
		}
	}
	public double addMoney(String aName, double amount) {
		if(aName.equals("")){
			new Error("name is empty");
			
			return 0;
		}else if (getDriver(aName)==null) {
			new Error(aName+" is not registered");
			return 0;
		}
		else {
			Driver aDriver = getDriver(aName);
			double addedAmount = aDriver.addMoney(amount);
			new Error ("Added $"+addedAmount+" to "+aName+" successfully");
			return addedAmount;
		}
	}
	public boolean removeMoney(String aName, double amount) {
		if(aName.equals("")){
			new Error("name is empty");
			
			return false;
		}else if (getDriver(aName)==null) {
			new Error(aName+" is not registered");
			return false;
		}
		else {
			Driver aDriver = getDriver(aName);
			if(aDriver.removeMoney(amount)) {
			new Error ("$"+amount+" debited from "+aName+" successfully");
			return true;
			}else return false;
		}
	}
	public Driver getDriver(String aName) {
		Driver[] arrayDrivers = new Driver[drivers.size()];
		 drivers.toArray(arrayDrivers);
		for (int i=0; i<arrayDrivers.length; i++) {
		if (aName.toLowerCase().equals(arrayDrivers[i].getName().toLowerCase())) {
			return arrayDrivers[i];
		}
		}
		return null;
	}
	public boolean updateDriverLocation (long X, long Y, String aName){
		if(aName.equals("")){
			new Error("name is empty");
			
			return false;
		}else if (getDriver(aName)==null) {
			new Error(aName+" is not registered");
			return false;
		}
		else {
			Driver aDriver = getDriver(aName);
			aDriver.updateLocation(X, Y);
			new Error("Location successfully updated");
			return true;
		}
	}
	public boolean checkPassword(String aDriver , String aPassword){
		if(aDriver.equals("")){
			new Error("Name can't be empty");
			return false;
		}
		Driver theDriver = getDriver(aDriver);
		if(theDriver== null){
			return false;
		}
		if(aPassword.equals("")){
			new Error("Password can't be empty");
			return false;
		}
		else if(aPassword.equals(theDriver.getPassword())){
			return true;
		}

		return false;
	}
	public List<Driver> getDriverList(){
		return drivers;
	}
}
