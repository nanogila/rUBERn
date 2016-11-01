package logic;

import java.util.*;

import GUI.Error;
import GUI.UserListGUI;

public class TagBase {
private List<QualityTag> tags;
public TagBase() {
	tags= new ArrayList<>();
}
public boolean addTag (QualityTag aTag) {
	if (checkTag(aTag)) {
		new Error(aTag.getTag()+" is already registered");
		return false;
	}else if(aTag.getTag().equals("")){
		new Error("Tag name is empty");
		return false;
	}else {
		tags.add(aTag);
		new Error("Tag "+aTag.getTag()+" successfully added");
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
public boolean removeTag(QualityTag aTag) {
	if(aTag.getTag().equals("")){
		new Error("Tag name is empty");
		
		return false;
	}else if (!checkTag(aTag)) {
		new Error(aTag.getTag()+" is not registered");
		return false;
	}else {
		tags.remove(aTag);
		new Error("Tag successfully removed");
		return true;
	}
}
public QualityTag getTag(String aTag) {
	QualityTag[] arrayTags = new QualityTag[tags.size()];
	 tags.toArray(arrayTags);
	for (int i=0; i<arrayTags.length; i++) {
	if (aTag.toLowerCase().equals(arrayTags[i].getTag().toLowerCase())) {
		return arrayTags[i];
	}
	}
	return null;
}
public boolean setQualityTagName(String aTagName, String aName) {
	if(getTag(aTagName)!=null) {
		getTag(aTagName).setName(aName);
		return true;
	}
	else return false;
}
public boolean setQualityTagValue(String aTagName, int aValue) {
	if(getTag(aTagName)!=null) {
		return getTag(aTagName).setValue(aValue);
		
	}
	else return false;
}
}
