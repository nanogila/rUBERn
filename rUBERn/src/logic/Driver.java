package logic;

public class Driver extends Person {

    private Car theCar;

    public Driver(String aName, Integer aCardNumber, String aPassword,Car aCar) {
        name = aName;
        card = new CreditCard(aName, aCardNumber);
        location = new Gps();
        password = aPassword;
        theCar = aCar;
    }
}
