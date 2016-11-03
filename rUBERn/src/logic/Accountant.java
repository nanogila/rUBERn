package logic;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import GUI.Error;

public class Accountant {
private ClientBase base;
private DriverBase driverBase;
private String newLine;
private File logFile;
private BufferedWriter logger;
public Accountant(ClientBase aBase, DriverBase aDriverBase) {
base = aBase;
driverBase = aDriverBase;
newLine = System.getProperty("line.separator");
logFile = new File("rUBERnLog.txt");
 logger = null;
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
	double finalAmount = roundUp(anAmount);
	String log = newLine+"Added money, date: "+getDate()+", time: "+getTime()+", name: "+aPerson.getName()+", credit card number: "+aPerson.getCardNumber()+", description: "+aDescription+", amount: "+finalAmount;
	if(writeLog(log)) return true;
	else return false;
}
public boolean logRemoveMoney(Person aPerson, double anAmount, String aDescription) {
	String log = newLine+"Charged money, date: "+getDate()+", time: "+getTime()+", name: "+aPerson.getName()+", credit card number: "+aPerson.getCardNumber()+", description: "+aDescription+", amount: -"+anAmount;
	if(writeLog(log)) return true;
	else return false;
}
public double imageCost(Trip aTrip) {
	double appraisal = ((double)aTrip.getDriver().getCarQuality())/10;
	double cost = roundUp((aTrip.getDistanceFromDriver()/500)*2/appraisal);
	return cost;
	
}
public double tripCost(Trip aTrip) {
	double cost = 0;
	cost = roundUp((aTrip.getDistance()/100)+15);
	return cost;
}
public double addMoney(User aUser, double amount) {
	double theAmount = Math.abs(roundUp(amount));
	return base.addMoney(aUser.getName(), theAmount);
}
public double addMoney(Driver aDriver, double amount) {
	double theAmount = Math.abs(roundUp(amount));
	return driverBase.addMoney(aDriver.getName(), theAmount);
}
public boolean addMoney(Driver aDriver, double amount, String aDescription) {
	double theAmount = driverBase.addMoney(aDriver.getName(), amount);
	if (logAddMoney(aDriver, theAmount, aDescription)) return true;
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
public static double roundUp(double value) {
	BigDecimal bd = new BigDecimal(value);
    bd = bd.setScale(2, RoundingMode.HALF_UP);
    return bd.doubleValue();
}
private boolean writeLog(String message) {
	 try
     {
		 logger = new BufferedWriter(new FileWriter(logFile, true));
         logger.write(message);
         logger.close();
         return true;
     }
     catch(Exception e)
     {
    	 new Error("Error while writing to the log file");
     }finally {
    	 try {
    		 logger.close();
    	 }catch (Exception e) {
    	 }
     }return false;
	
}
public String getLogFileLocation() {
	try {
		return logFile.getCanonicalPath();
	} catch (IOException e) {
		return "log file not found";
	}
}
}
