package rUBERn;

public class User {
private String name;
private Integer card;
private Gps location;
public User(String aName, Integer aCard) {
	name = aName;
	card = aCard;
	location = new Gps();
}
public String getName() {
	return name;
}
public Integer getCard() {
	return card;
}
public void updateLocation(long x, long y) {
	location.updateLocation(x, y);
}
public String getLocation() {
	return location.toString();
}
}
