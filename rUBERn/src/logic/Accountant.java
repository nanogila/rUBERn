package logic;
import java.util.*;


public class Accountant {
private ArrayList<String> movimientos;
private ClientBase base;
private DriverBase driverBase;
public Accountant(ClientBase aBase, DriverBase aDriverBase) {
movimientos = new ArrayList<>();
base = aBase;
driverBase = aDriverBase;
}
public double imageCost(Trip aTrip) {
	Appraiser anAppraiser = new Appraiser();
	double appraisal = anAppraiser.appraiseCar(aTrip.getDriver().getCar());
	return (aTrip.getDistanceFromDriver()/500)*2/appraisal;
	
}
public double tripCost(Trip aTrip) {
	double cost = 0;
	cost =(aTrip.getDistance()/100)+15;
	return cost;
}
public boolean addMoney(User aUser, double amount) {
	return base.addMoney(aUser.getName(), amount);
}
public boolean addMoney(Driver aDriver, double amount) {
	return driverBase.addMoney(aDriver.getName(), amount);
}
public boolean removeMoney(User aUser, double amount) {
	return base.removeMoney(aUser.getName(), amount);
}
public boolean removeMoney(Driver aDriver, double amount) {
	return driverBase.removeMoney(aDriver.getName(), amount);
}
}
