package logic;

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
    public String getCarModel() {
    	return theCar.getModel();
    }
    public boolean goOnline() {
    	if(status.equals(status.ONLINE)) return false;
    	else {
    		status=status.ONLINE; 
    		return true;
    	}
    }
    public boolean goOffline() {
    	if(status.equals(status.OFFLINE)) return false;
    	else {
    		status=status.OFFLINE; 
    		return true;
    	}
    }
    public Boolean isAvailable() {
    	if (status.equals(status.ONLINE)) return true;
    	return false;
    }
}
