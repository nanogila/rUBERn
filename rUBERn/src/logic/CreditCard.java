package logic;

/**
 * Created by tomasvarela on 10/21/16.
 */
public class CreditCard {
    private String name;
    private Integer cardNumber;
    private double balance;

    public CreditCard(String aName, Integer aCardNumber){
        name = aName;
        cardNumber = aCardNumber;
        balance = 0.0;
    }
    public void addMoney(double money){
        balance += money;
    }
    public void removeMoney(double money){
        if (balance < money){
            new Error("Not enough money");
        }
        else{
            balance -= money;
        }
    }
    public double getBalance(){
        return balance;
    }
    public Integer getCardNumber(){
        return cardNumber;
    }
}
