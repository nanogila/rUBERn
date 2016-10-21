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
    public String getLocation() {
        return location.toString();
    }
    public String getPassword(){
        return password;
    }
}
