package logic;

public class Car {
	protected QualityTag qualityTag;
	protected String model;
	protected int capacity;
	public Car (String aModel, int aCapacity, QualityTag aQualityTag) {
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
