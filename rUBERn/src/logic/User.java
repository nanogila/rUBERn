package logic;

public class User extends Person {
private boolean isTravelling;
	public User(String aName, Integer aCardNumber, String aPassword) {
		name = aName;
		card = new CreditCard(aName, aCardNumber);
		location = new Gps();
		password = aPassword;
		isTravelling=false;
	}
	public boolean startTrip() {
		if(!isTravelling) {
			isTravelling=true;
			return true;
		}
		return false;
	}
	public boolean endTrip() {
		if (isTravelling) {
			isTravelling=false;
			return true;
		}
		return false;
	}
	public boolean isTravelling() {
		return isTravelling;
	}

}
