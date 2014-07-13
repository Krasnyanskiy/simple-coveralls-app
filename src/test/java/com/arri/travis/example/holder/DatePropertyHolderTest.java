package com.arri.travis.example.holder;

import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Unit tests for {@link DatePropertyHolder}
 */
public class DatePropertyHolderTest {

    @Test(testName = "DatePropertyHolder_constructor")
    public void should_pass_map_to_parent_class() {

        // Given
        Map<Integer, Date> map = new HashMap<>();

        // When
        DatePropertyHolder holder = new DatePropertyHolder(map);

        // Than
        assertNotNull(holder.getProperties());
        assertEquals(holder.getProperties(), map);
    }
}