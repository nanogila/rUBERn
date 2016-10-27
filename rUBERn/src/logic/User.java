package logic;

public class User extends Person {

	public User(String aName, Integer aCardNumber, String aPassword) {
		name = aName;
		card = new CreditCard(aName, aCardNumber);
		location = new Gps();
		password = aPassword;
	}

}
