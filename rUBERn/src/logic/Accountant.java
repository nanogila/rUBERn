package logic;
import java.util.*;

import GUI.*;
public class Accountant {
ArrayList<String> Movimientos;
Matrix theMatrix;
public Accountant(Matrix aMatrix) {
	theMatrix = aMatrix;
}
public double imageCost(Trip aTrip) {
	Appraiser anAppraiser = new Appraiser();
	double appraisal = anAppraiser.appraiseCar(aTrip.getDriver().getCar());
	return (aTrip.getDistanceFromDriver()/500)*2/appraisal;
	
}
public double tripCost(Trip aTrip) {
	double cost = 0;
	cost =(aTrip.getDistance()/100)+15;
	return cost;
}
}
