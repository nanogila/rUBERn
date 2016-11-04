package logic;
public class Trip {
	private Driver theDriver;
	private User theClient;
	private Double distance;
	private long[] destination;

public Trip (Driver aDriver, User aClient, long[] aDestination) {
	theDriver = aDriver;
	theClient = aClient;
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
