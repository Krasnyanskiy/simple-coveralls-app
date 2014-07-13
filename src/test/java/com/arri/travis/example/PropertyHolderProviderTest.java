package com.arri.travis.example;

import com.arri.travis.example.holder.DatePropertyHolder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;
import static org.powermock.reflect.internal.WhiteboxImpl.setInternalState;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

/**
 * Unit tests for {@link PropertyHolderProvider}.
 */
@PrepareForTest(PropertyHolderProvider.class)
public class PropertyHolderProviderTest extends PowerMockTestCase {

    @Mock
    private PropertyHolderProvider providerMock;

    @Mock
    private Map mockedMap;

    @InjectMocks
    private DatePropertyHolder expectedHolderMock;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void should_set_field_and_return_an_instance_of_PropertyHolderProvider() throws Exception {

        // Given
        whenNew(PropertyHolderProvider.class)
                .withParameterTypes(Map.class)
                .withArguments(mockedMap)
                .thenReturn(providerMock);

        setInternalState(providerMock, "property", mockedMap);

        // When
        PropertyHolderProvider property = new PropertyHolderProvider(mockedMap);
        Map retrieved = property.getProperty();

        // Than
        assertNotNull(property);
        assertEquals(retrieved, mockedMap);
    }

    @Test
    public void should_return_proper_DatePropertyHolder_instance() throws Exception {

        // Given
        whenNew(PropertyHolderProvider.class)
                .withParameterTypes(Map.class)
                .withArguments(mockedMap)
                .thenReturn(providerMock);

        when(providerMock.create(Mockito.eq(DatePropertyHolder.class)))
                .thenReturn(expectedHolderMock);

        // When
        DatePropertyHolder retrieved =
                new PropertyHolderProvider(mockedMap).create(DatePropertyHolder.class);

        // Than
        assertNotNull(retrieved);
        assertEquals(retrieved, expectedHolderMock);
        verify(providerMock, times(1)).create(DatePropertyHolder.class);
    }

    @Test
    public void should_invoke_getter() {
        PropertyHolderProvider provider = new PropertyHolderProvider(mockedMap);
        assertNotNull(provider.getProperty());

        PropertyHolderProvider providerWithNullProp = new PropertyHolderProvider(null);
        assertNull(providerWithNullProp.getProperty());
    }

    @AfterMethod
    public void tearDown() {
        reset(providerMock, mockedMap);
    }
}