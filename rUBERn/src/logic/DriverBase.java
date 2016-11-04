package logic;

import java.util.ArrayList;
import java.util.List;

import GUI.*;
import GUI.Error;
import exceptions.AlreadyRegisteredException;
import exceptions.EmptyFieldException;
import exceptions.ItemNotFoundException;
import exceptions.NotEnoughMoneyException;

public class DriverBase {
	private List<Driver> drivers;
	public DriverBase() {
		drivers= new ArrayList<Driver>();
	}
	public boolean addDriver (Driver aDriver) throws AlreadyRegisteredException, EmptyFieldException {
		if (checkName(aDriver)) {
			throw new AlreadyRegisteredException(aDriver.getName());
		}else if(aDriver.getName().equals("")){
			throw new EmptyFieldException("name");
		}else {
			drivers.add(aDriver);
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
	public boolean removeDriver(Driver aDriver) throws ItemNotFoundException, EmptyFieldException {
		if(aDriver.getName().equals("")){
			throw new EmptyFieldException("name");
		}else if (!checkName(aDriver)) {
			throw new ItemNotFoundException(aDriver.getName());
		}else {
			drivers.remove(aDriver);
			return true;
		}
	}
	public double addMoney(String aName, double amount) throws ItemNotFoundException, EmptyFieldException {
			Driver aDriver = getDriver(aName);
			return aDriver.addMoney(amount);
	}
	public boolean removeMoney(String aName, double amount) throws NotEnoughMoneyException, ItemNotFoundException, EmptyFieldException {
			Driver aDriver = getDriver(aName);
			if(aDriver.removeMoney(amount)) {
				return true;
			}else return false;
	}
	public Driver getDriver(String aName) throws ItemNotFoundException, EmptyFieldException {
if (aName.equals("")) throw new EmptyFieldException("name");
		Driver[] arrayDrivers = new Driver[drivers.size()];
		 drivers.toArray(arrayDrivers);
		for (int i=0; i<arrayDrivers.length; i++) {
		if (aName.toLowerCase().equals(arrayDrivers[i].getName().toLowerCase())) {
			return arrayDrivers[i];
		}
		}
		throw new ItemNotFoundException(aName);
	}
	public boolean updateDriverLocation (long X, long Y, String aName) throws ItemNotFoundException, EmptyFieldException{
			Driver aDriver = getDriver(aName);
			aDriver.updateLocation(X, Y);
			new Error("Location successfully updated");
			return true;
	}
	public boolean checkPassword(String aDriver , String aPassword) throws EmptyFieldException{
		Driver theDriver;
		try {
			theDriver = getDriver(aDriver);
		} catch (EmptyFieldException | ItemNotFoundException e) {
return false;
		}
		if(aPassword.equals("")){
			throw new EmptyFieldException("password");
		}
		else if(aPassword.equals(theDriver.getPassword())){
			return true;
		}

		return false;
	}
	public List<Driver> getDriverList(){
		return drivers;
	}
	public double collectSalary(String name, double amount) throws ItemNotFoundException, EmptyFieldException {
		return addMoney(name, amount*0.9);
	}
}
