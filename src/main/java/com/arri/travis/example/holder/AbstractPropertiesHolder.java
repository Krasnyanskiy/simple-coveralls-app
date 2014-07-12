package com.arri.travis.example.holder;

import java.util.Map;

/**
 * @author Alexander Krasnyanskiy
 */
public abstract class AbstractPropertiesHolder<Id extends Integer, HolderType> {
    private Map<Id, HolderType> properties;

    public AbstractPropertiesHolder(Map<Id, HolderType> properties) {
        this.properties = properties;
    }

    public Map getProperties() {
        return properties;
    }
}