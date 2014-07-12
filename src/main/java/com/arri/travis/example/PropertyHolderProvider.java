package com.arri.travis.example;

import com.arri.travis.example.holder.AbstractPropertiesHolder;

import java.util.Map;

/**
 * @author Alexander Krasnyanskiy
 */
public class PropertyHolderProvider {
    private Map property;

    public PropertyHolderProvider(Map property) {
        this.property = property;
    }

    public <T extends AbstractPropertiesHolder> T create(Class<T> type) throws Exception {
        return type.getConstructor(Map.class).newInstance(property);
    }

    public Map getProperty() {
        return property;
    }
}