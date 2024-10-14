package model;

import java.util.UUID;

public abstract class EntityWithId {
    private UUID id;

    public EntityWithId() {
        this.id = generateId();
    }

    public EntityWithId(UUID id) {
        this.id = id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public UUID generateId() {
        return UUID.randomUUID();
    }
}
