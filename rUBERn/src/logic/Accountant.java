package logic;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
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
public boolean logAddMoney(Trip aTrip) {
	LocalDateTime log = LocalDateTime.now();
	return true;
}
public boolean logRemoveMoney() {
	return true;
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
public boolean removeMoney(User aUser, double amount) {
	double theAmount = Math.abs(roundUp(amount));
	return base.removeMoney(aUser.getName(), theAmount);
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
