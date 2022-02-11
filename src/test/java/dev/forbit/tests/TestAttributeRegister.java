package dev.forbit.tests;

import dev.forbit.enums.DefaultAttributes;
import dev.forbit.interfaces.Attribute;
import dev.forbit.util.AttributeRegister;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAttributeRegister {

    @Test void verifyOriginalAttributes() {
        AttributeRegister register = new AttributeRegister();

        Assertions.assertEquals(register.getAttributes().size(), 2, "contains original 2 attributes");
        Assertions.assertAll(() -> Assertions.assertTrue(register.getAttributes().contains(DefaultAttributes.END_ROOM), "contains DefaultAttributes.END_ROOM"),
                             () -> Assertions.assertTrue(register.getAttributes().contains(DefaultAttributes.START_ROOM), " contains DefaultAttributes.START_ROOM"));
    }

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

    @Test void addingDuplicateAttributesThrowsError() {
        AttributeRegister register = new AttributeRegister();

        Assertions.assertThrows(IllegalArgumentException.class, () -> register.registerAttributes(DefaultAttributes.values()), "should throw error trying to register duplicate entries");
    }


    enum AdditionalAttributes implements Attribute {
        MAGIC_PORTAL_ROOM("magic_portal"),
        TESTING_ADDITIONAL_ATTRIBUTES("test_attribute");

        @Getter String identifier;

        AdditionalAttributes(String id) {
            this.identifier = id;
        }


    }
}
