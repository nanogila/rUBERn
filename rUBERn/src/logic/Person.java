package logic;

/**
 * Created by admin on 21/10/2016.
 */
public abstract class Person {

    protected String name;
    protected CreditCard card;
    protected Gps location;
    protected String password;

    public String getName() {
        return name;
    }
    public Integer getCardNumber() {
        return card.getCardNumber();
    }
    public void updateLocation(long x, long y) {
        location.updateLocation(x, y);
    }
    public String getLocationToString() {
        return location.toString();
    }
    public String getPassword(){
        return password;
    }
    public long[] getLocation(){
        return location.getLocation();
    }
    public double getDistance(Person aPerson){
        return location.getDistance(aPerson.getLocation());
    }
    public double getDistance(long [] aLocation){
        return location.getDistance(aLocation);
    }
    public void addMoney(double someMoney) {
    	card.addMoney(someMoney);
    }
    public boolean removeMoney(double someMoney) {
    	return card.removeMoney(someMoney);
    }
}
