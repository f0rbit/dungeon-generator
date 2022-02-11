package dev.forbit.interfaces;


/**
 * Interface for specifying attributes, should only implemented in enums
 * <p>
 * For usage see {@link dev.forbit.enums.DefaultAttributes}
 */
public interface Attribute {

    /**
     * Should return a unique identifier
     *
     * @return package name + enum class name + enum value name
     */
    default String getIdentifier() {
        return getClass().getCanonicalName() + "." + name();
    }

    /**
     * Gets the name of the enum value
     *
     * @return name
     */
    String name();
}
