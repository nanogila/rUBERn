package logic;

public class User {
private String name;
private Integer card;
private Gps location;
private String password;

public User(String aName, Integer aCard, String aPassword) {
	name = aName;
	card = aCard;
	location = new Gps();
	password = aPassword;

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
public String getPassword(){
	return password;
}
}
