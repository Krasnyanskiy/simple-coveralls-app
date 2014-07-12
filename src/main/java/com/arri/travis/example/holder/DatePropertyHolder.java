package com.arri.travis.example.holder;

import java.util.Date;
import java.util.Map;

/**
 * @author Alexander Krasnyanskiy
 */
public class DatePropertyHolder extends AbstractPropertiesHolder {

    @SuppressWarnings("unchecked")
    public DatePropertyHolder(Map<Integer, Date> properties) {
        super(properties);
    }

    @SuppressWarnings("unchecked")
    public Map<Integer, Date> getProperties() {
        return super.getProperties();
    }
}
