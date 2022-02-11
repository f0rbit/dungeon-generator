package dev.forbit.util;

import dev.forbit.enums.DefaultAttributes;
import dev.forbit.interfaces.Attribute;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AttributeRegister {

    private final Set<Attribute> attributes = new HashSet<>(Set.of(DefaultAttributes.values()));

    public void registerAttributes(Attribute... attributes) throws IllegalArgumentException {
        List.of(attributes).forEach((attribute) -> {
            if (contains(attribute.getIdentifier())) {
                throw new IllegalArgumentException("Attempted to register an attribute with a duplicate id. Attribute = "+attribute+" identifier: "+attribute.getIdentifier());
            } else {
                this.attributes.add(attribute);
            }
        });
    }

    public Set<Attribute> getAttributes() {
        return this.attributes;
    }

    private boolean contains(String identifier) {
        return (attributes.stream().anyMatch((attribute -> attribute.getIdentifier().equalsIgnoreCase(identifier))));
    }
}
