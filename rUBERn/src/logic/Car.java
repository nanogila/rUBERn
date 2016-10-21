package logic;

public abstract class Car {
	protected QualityTag qualityTag;
	protected String model;
	protected int capacity;
    public String getModel() {
    	return model;
    }
    public QualityTag getQuailityTag() {
    	return qualityTag;
    }
}
