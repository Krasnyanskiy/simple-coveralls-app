package com.arri.travis.example.holder;

import java.util.Map;

/**
 * @author Alexander Krasnyanskiy
 */
public class MapPropertyHolder extends AbstractPropertiesHolder {

    @SuppressWarnings("unchecked")
    public MapPropertyHolder(Map<Integer, Map<String, String>> properties) {
        super(properties);
    }

    @SuppressWarnings("unchecked")
    public Map<Integer, Map<String, String>> getProperties() {
        return super.getProperties();
    }
}
