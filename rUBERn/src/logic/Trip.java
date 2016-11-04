package logic;

import exceptions.InvalidTripException;

public class Trip {
	private Driver theDriver;
	private User theClient;
	private Double distance;
	private long[] destination;

public Trip (Driver aDriver, User aClient, long[] aDestination) throws InvalidTripException{
	theDriver = aDriver;
	theClient = aClient;
	if (theClient.getDistance(aDestination)<10) throw new InvalidTripException("Trips must be at least 10 meters long");
	distance = theClient.getDistance(aDestination);
	destination = aDestination;
}
public Double getDistanceFromDriver() {
	return theClient.getDistance(theDriver);
}
public Double getDistance() {
	return distance;
}
public Driver getDriver() {
	return theDriver;
}
public User getClient() {
	return theClient;
}
}
