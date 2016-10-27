package logic;

import java.util.HashMap;

/**
 * Created by tomasvarela on 10/27/16.
 */
public class Appraiser {
    HashMap < QualityTag , Double > QualityTagsValues;

    public Appraiser(){
        QualityTagsValues = new HashMap<>();
        QualityTagsValues.put(QualityTag.HIGH, 0.7);
        QualityTagsValues.put(QualityTag.VIP, 0.9);
        QualityTagsValues.put(QualityTag.MEDIUM, 0.4);
        QualityTagsValues.put(QualityTag.LOW, 0.2);

    }

    public double appraiseCar(Car aCar){
        QualityTag tag = aCar.getQuailityTag();
        return QualityTagsValues.get(tag);
    }


}
