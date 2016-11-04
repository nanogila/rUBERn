package logic;
import GUI.Error;
import exceptions.InvalidRatingException;
public class QualityTag {
private String tag;
private int value;
public QualityTag (String aTag, int aValue) throws InvalidRatingException {
	tag = aTag;
	value = 0;
	setValue(aValue);
}
public String getTag() {
	return tag;
}
public int getValue() {
	return value;
}
public boolean setValue(int aValue) throws InvalidRatingException{
	if (aValue <=10 && aValue>0) {
		value = aValue;
		return true;
	}else {
		throw new InvalidRatingException();
	}
}
public void setName(String aName) {
	tag = aName;
}
}
