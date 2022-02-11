package dev.forbit.enums;

import dev.forbit.interfaces.Attribute;
import lombok.Getter;

public enum DefaultAttributes implements Attribute {
    START_ROOM("start_room"),
    END_ROOM("end_room");

    @Getter String identifier;

    DefaultAttributes(String id) {
        this.identifier = id;
    }

}
