package dev.forbit.util;

import dev.forbit.enums.DefaultAttributes;
import dev.forbit.interfaces.Attribute;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The attribute register, to create an attribute see {@link DefaultAttributes}
 */
public class AttributeRegister {

    /**
     * The collection of registered attributes.
     * <p>
     * Initially contains the default attributes listed in {@link DefaultAttributes}
     */
    private final Set<Attribute> attributes = new HashSet<>(Set.of(DefaultAttributes.values()));


    /**
     * Registers an array of attribute values
     * <p>
     * Example usage:
     * <pre>{@code
     *  // Declare some attributes somewhere
     *  enum AdditionalAttributes implements Attribute {
     *      MAGIC_PORTAL_ROOM,
     *      ANOTHER_ATTRIBUTE;
     *  }
     *  // Register them somewhere in the codebase
     *  public void registerAttributes() {
     *      AttributeRegister register = ...
     *      register.registerAttributes(AdditionalAttributes.values());
     *  }
     * }</pre>
     *
     * @param attributes an array of attributes to register
     *
     * @throws IllegalArgumentException exception thrown if attempting to add an attribute with a matching identifier to one that has already been registered.
     */
    public void registerAttributes(Attribute... attributes) throws IllegalArgumentException {
        List.of(attributes).forEach((attribute) -> {
            if (contains(attribute.getIdentifier())) {
                throw new IllegalArgumentException(
                        "Attempted to register an attribute with a duplicate id. Attribute = " + attribute + " identifier: " + attribute.getIdentifier());
            } else {
                this.attributes.add(attribute);
            }
        });
    }

    /**
     * Gets a set of the registered attributes
     *
     * @return the registered attributes
     */
    public Set<Attribute> getAttributes() {
        return this.attributes;
    }

    /**
     * Checks to see if a registered attribute has the identifier given.
     *
     * @param identifier id to check
     *
     * @return true if the registry contains an attribute with a matching identifier
     */
    private boolean contains(String identifier) {
        return (attributes.stream().anyMatch((attribute -> attribute.getIdentifier().equalsIgnoreCase(identifier))));
    }
}
