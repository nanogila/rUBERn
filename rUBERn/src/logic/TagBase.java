package logic;

import java.util.*;

import GUI.Error;
import GUI.UserListGUI;
import exceptions.*;

public class TagBase {
private List<QualityTag> tags;
public TagBase() {
	tags= new ArrayList<>();
}
public boolean addTag (QualityTag aTag) throws AlreadyRegisteredException, EmptyFieldException {
	if (checkTag(aTag)) {
		throw new AlreadyRegisteredException(aTag.getTag());
	}else if(aTag.getTag().equals("")){
		throw new EmptyFieldException("tag name");
	}else {
		tags.add(aTag);
		return true;
	}
	
}
public boolean checkTag(QualityTag aTag) {
	QualityTag[] arrayTags = new QualityTag[tags.size()];
	 tags.toArray(arrayTags);
	for (int i=0; i<arrayTags.length; i++) {
	if (aTag.getTag().toLowerCase().equals(arrayTags[i].getTag().toLowerCase())) {
return true;
	}
	}
	return false;
}
public void seeTags() {
	QualityTag[] arrayTags = new QualityTag[tags.size()];
	 tags.toArray(arrayTags);
	 String[] columns = {"Category", "score"};
	 Object[][] data = new Object[tags.size()][columns.length];
	 for (int i=0; i<arrayTags.length; i++) {
		 for (int j=0; j<columns.length; j++) {
			 if(j==0) {
	 data[i][j] = arrayTags[i].getTag();
			 }else if (j==1){
				 data[i][j] = arrayTags[i].getValue();
			 }
	 }
		 }
	 new UserListGUI(columns, data);
}
public String[] getTagNames() {
	QualityTag[] arrayTags = new QualityTag[tags.size()];
	 tags.toArray(arrayTags);
	 String[] data = new String[tags.size()];
	 for (int i=0; i<arrayTags.length; i++) {
	 data[i] = arrayTags[i].getTag();
		 }
	 return data;
}
public boolean removeTag(QualityTag aTag) throws EmptyFieldException, ItemNotFoundException{
	if(aTag.getTag().equals("")){
		throw new EmptyFieldException("tag name");
	}else if (!checkTag(aTag)) {
		throw new ItemNotFoundException(aTag.getTag());
	}else {
		tags.remove(aTag);
		return true;
	}
}
public QualityTag getTag(String aTag) throws ItemNotFoundException {
	QualityTag[] arrayTags = new QualityTag[tags.size()];
	 tags.toArray(arrayTags);
	for (int i=0; i<arrayTags.length; i++) {
	if (aTag.toLowerCase().equals(arrayTags[i].getTag().toLowerCase())) {
		return arrayTags[i];
	}
	}
	throw new ItemNotFoundException(aTag);
}
public boolean setQualityTagName(String aTagName, String aName) throws ItemNotFoundException {
		getTag(aTagName).setName(aName);
		return true;
}
public boolean setQualityTagValue(String aTagName, int aValue) throws InvalidRatingException, ItemNotFoundException {
		return getTag(aTagName).setValue(aValue);
}
}
