package dev.forbit.tests;

import dev.forbit.enums.DefaultAttributes;
import dev.forbit.interfaces.Attribute;
import dev.forbit.util.AttributeRegister;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAttributeRegister {

    /**
     * Test the registry contains the default attributes
     */
    @Test void verifyOriginalAttributes() {
        AttributeRegister register = new AttributeRegister();

        Assertions.assertEquals(register.getAttributes().size(), 2, "contains original 2 attributes");
        Assertions.assertAll(() -> Assertions.assertTrue(register.getAttributes().contains(DefaultAttributes.END_ROOM), "contains DefaultAttributes.END_ROOM"),
                             () -> Assertions.assertTrue(register.getAttributes().contains(DefaultAttributes.START_ROOM), " contains DefaultAttributes.START_ROOM"));
    }

    /**
     * Tests adding additional attributes to the registry.
     */
    @Test void addingAdditionalAttributes() {
        AttributeRegister register = new AttributeRegister();

        register.registerAttributes(AdditionalAttributes.values());

        Assertions.assertEquals(register.getAttributes().size(), 4, "contains all 4 attributes");


        Assertions.assertAll(() -> Assertions.assertTrue(register.getAttributes().contains(DefaultAttributes.END_ROOM), "contains DefaultAttributes.END_ROOM"),
                             () -> Assertions.assertTrue(register.getAttributes().contains(DefaultAttributes.START_ROOM), " contains DefaultAttributes.START_ROOM"),
                             () -> Assertions.assertTrue(register.getAttributes().contains(AdditionalAttributes.MAGIC_PORTAL_ROOM),
                                                         "contains AdditionalAttributes.MAGIC_PORTAL_ROOM"),
                             () -> Assertions.assertTrue(register.getAttributes().contains(AdditionalAttributes.TESTING_ADDITIONAL_ATTRIBUTES),
                                                         "contains AdditionalAttributes.TESTING_ADDITIONAL_ATTRIBUTES"));

    }

    /**
     * Ensures that adding duplicate attributes results in an exception
     */
    @Test void addingDuplicateAttributesThrowsError() {
        AttributeRegister register = new AttributeRegister();

        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> register.registerAttributes(DefaultAttributes.values()),
                                "should throw error trying to register duplicate entries");
    }

    /**
     * Verifies the {@link Attribute#getIdentifier()} function works
     */
    @Test void verifyAttributeNamingSystem() {
        // test default attributes
        Assertions.assertEquals(DefaultAttributes.END_ROOM.getIdentifier(), "dev.forbit.enums.DefaultAttributes.END_ROOM");
        Assertions.assertEquals(DefaultAttributes.START_ROOM.getIdentifier(), "dev.forbit.enums.DefaultAttributes.START_ROOM");
        // test additional attributes
        Assertions.assertEquals(AdditionalAttributes.MAGIC_PORTAL_ROOM.getIdentifier(), "dev.forbit.tests.TestAttributeRegister.AdditionalAttributes.MAGIC_PORTAL_ROOM");
        Assertions.assertEquals(AdditionalAttributes.TESTING_ADDITIONAL_ATTRIBUTES.getIdentifier(),
                                "dev.forbit.tests.TestAttributeRegister.AdditionalAttributes.TESTING_ADDITIONAL_ATTRIBUTES");
    }


    /**
     * Attributes used for testing purposes.
     */
    enum AdditionalAttributes implements Attribute {
        MAGIC_PORTAL_ROOM,
        TESTING_ADDITIONAL_ATTRIBUTES;
    }
}
