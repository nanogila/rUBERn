package logic;

public class QualityTag {
private String tag;
private double value;
public QualityTag (String aTag, double aValue) {
	tag = aTag;
	value = aValue;
}
public String getTag() {
	return tag;
}
public double getValue() {
	return value;
}
}
