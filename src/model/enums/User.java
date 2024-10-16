package model.enums;

import model.EntityWithId;

public class User extends EntityWithId {
    public User() {
        super();
    }

    public void printRole() {
        System.out.println("USER printRole() method");
    }

}
