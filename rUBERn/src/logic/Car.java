package logic;

import exceptions.EmptyFieldException;

public class Car {
	protected QualityTag qualityTag;
	protected String model;
	protected int capacity;
	public Car (String aModel, int aCapacity, QualityTag aQualityTag) throws EmptyFieldException {
		if (aModel.equals("")) throw new EmptyFieldException("Car model");
		qualityTag = aQualityTag;
		model = aModel;
		capacity = aCapacity;
	}
    public String getModel() {
    	return model;
    }
    public QualityTag getQuailityTag() {
    	return qualityTag;
    }
    public int getCapacity() {
    	return capacity;
    }
    public int getCarQuality() {
    	return qualityTag.getValue();
    }

}
