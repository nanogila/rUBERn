package logic;
import GUI.Error;
public class QualityTag {
private String tag;
private int value;
public QualityTag (String aTag, int aValue) {
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
public boolean setValue(int aValue) {
	if (aValue <=10 && aValue>0) {
		value = aValue;
		return true;
	}else {
		new Error("Rating must be between 1 and 10");
		return false;
	}
}
public void setName(String aName) {
	tag = aName;
}
}
