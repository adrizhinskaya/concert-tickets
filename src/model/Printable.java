package model;

public interface Printable {
    void printRole();

    default void print() {
        System.out.println("print content in console");
    }
}
