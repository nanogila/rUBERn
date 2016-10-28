package logic;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import GUI.Error;

public class Accountant {
private ArrayList<String> movimientos;
private ClientBase base;
private DriverBase driverBase;
public Accountant(ClientBase aBase, DriverBase aDriverBase) {
movimientos = new ArrayList<>();
base = aBase;
driverBase = aDriverBase;
}
public String getTime() {
   DateTimeFormatter formatter =
              DateTimeFormatter.ofPattern("HH:mm");
   String time = ZonedDateTime.now().format(formatter);
return time;
}
public String getDate() {
	  DateTimeFormatter formatter =
              DateTimeFormatter.ofPattern("yyyy/MM/dd");
   String date = ZonedDateTime.now().format(formatter);
   return date;
}
public boolean logAddMoney(Person aPerson, double anAmount, String aDescription) {
	double finalAmount = roundUp(anAmount*0.9);
	String log = "Added money, date: "+getDate()+", time: "+getTime()+", name: "+aPerson.getName()+", credit card number: "+aPerson.getCardNumber()+", description: "+aDescription+", amount: "+finalAmount;
	if(movimientos.add(log)) return true;
	else return false;
}
public boolean logRemoveMoney(Person aPerson, double anAmount, String aDescription) {
	String log = "Charged money, date: "+getDate()+", time: "+getTime()+", name: "+aPerson.getName()+", credit card number: "+aPerson.getCardNumber()+", description: "+aDescription+", amount: -"+anAmount;
	if(movimientos.add(log)) return true;
	else return false;
}
public double imageCost(Trip aTrip) {
	Appraiser anAppraiser = new Appraiser();
	double appraisal = anAppraiser.appraiseCar(aTrip.getDriver().getCar());
	double cost = roundUp((aTrip.getDistanceFromDriver()/500)*2/appraisal);
	return cost;
	
}
public double tripCost(Trip aTrip) {
	double cost = 0;
	cost =roundUp((aTrip.getDistance()/100)+15);
	return cost;
}
public boolean addMoney(User aUser, double amount) {
	double theAmount = Math.abs(roundUp(amount));
	return base.addMoney(aUser.getName(), theAmount);
}
public boolean addMoney(Driver aDriver, double amount) {
	double theAmount = Math.abs(roundUp(amount));
	return driverBase.addMoney(aDriver.getName(), theAmount);
}
public boolean addMoney(Driver aDriver, double amount, String aDescription) {
	double theAmount = Math.abs(roundUp(amount));
	if (logAddMoney(aDriver, theAmount, aDescription) && driverBase.addMoney(aDriver.getName(), theAmount)) return true;
	else return false;
}
public boolean removeMoney(User aUser, double amount, String aDescription) {
	double theAmount = Math.abs(roundUp(amount));
	if (logRemoveMoney(aUser, theAmount, aDescription) && base.removeMoney(aUser.getName(), theAmount)) return true;
	else return false;
	}
public boolean removeMoney(Driver aDriver, double amount) {
	double theAmount = Math.abs(roundUp(amount));
	return driverBase.removeMoney(aDriver.getName(), theAmount);
}
private double roundUp(double value) {
	BigDecimal bd = new BigDecimal(value);
    bd = bd.setScale(2, RoundingMode.HALF_UP);
    return bd.doubleValue();
}
}
