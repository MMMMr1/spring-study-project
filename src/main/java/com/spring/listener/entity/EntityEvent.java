package com.spring.listener.entity;

import lombok.Getter;

import java.util.EventObject;

public class EntityEvent extends EventObject {
    @Getter
    private final AccessType  accessType;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */

    public EntityEvent(Object source, AccessType accessType) {
        super(source);
        this.accessType = accessType;
    }

}
