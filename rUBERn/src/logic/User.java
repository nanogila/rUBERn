package logic;

import javax.smartcardio.Card;

public class User {
private String name;
private CreditCard card;
private Gps location;
private String password;

public User(String aName, Integer aCardNumber, String aPassword) {
	name = aName;
	card = new CreditCard(aName, aCardNumber);
	location = new Gps();
	password = aPassword;

}
public String getName() {
	return name;
}
public Integer getCardNumber() {
	return card.getCardNumber();
}
public void updateLocation(long x, long y) {
	location.updateLocation(x, y);
}
public String getLocation() {
	return location.toString();
}
public String getPassword(){
	return password;
}
}
