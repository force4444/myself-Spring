package org.springframework.beans;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue){
        propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues(){
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName){
        if(null == propertyName) return null;

        for(int i = 0; i < propertyValueList.size(); i++ ){
            PropertyValue propertyValue = propertyValueList.get(i);
            if(propertyName.equals(propertyValue.getName())){
                return propertyValue;
            }
        }

        return null;
    }
}
