package model;

import java.util.UUID;

public abstract class EntityWithId {
    private UUID id;

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDefaultId() {
        this.id = generateId();
    }

    public UUID getId() {
        return id;
    }

    public UUID generateId() {
        return UUID.randomUUID();
    }

    public void print() {
        System.out.println("print content in console");
    }
}
