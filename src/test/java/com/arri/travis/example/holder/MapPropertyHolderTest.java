package com.arri.travis.example.holder;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class MapPropertyHolderTest {

    @Test(testName = "MapPropertyHolder_constructor")
    public void should_pass_map_to_parent_class() {

        // Given
        Map<Integer, Map<String, String>> map = new HashMap<>();

        // When
        MapPropertyHolder holder = new MapPropertyHolder(map);

        // Than
        assertNotNull(holder.getProperties());
        assertEquals(holder.getProperties(), map);
    }
}