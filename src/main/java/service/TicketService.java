package service;

import collections.CustomArrayList;
import collections.CustomHashSet;
import model.Admin;
import model.Client;
import model.EntityWithId;
import model.Ticket;

public class TicketService extends EntityWithId {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Admin admin = new Admin();
        Client client = new Client();

        admin.printRole();
        client.printRole();

        ticket.print(); // override print()
        admin.print(); // override print()
        client.print(); // base print()

        ticket.shared("+375(25)987-54-32");
        ticket.shared("+375(25)987-54-32", "someEmail@mail.ru.");

        admin.printRole();
        admin.checkTicket();
        client.printRole();
        client.getTicket();

        System.out.println("CustomArrayList CHECK");
        final var ar = new CustomArrayList<Integer>();
        for (int i = 0; i < 11; i++) {
            ar.add(i);
        }
        System.out.println("Size = " + ar.size());
        ar.remove(0);
        System.out.println("Size = " + ar.size());
        System.out.println(ar.get(1));


        System.out.println("CustomHashSet CHECK");
        CustomHashSet<String> set = new CustomHashSet<>();
        set.add("Hello");
        set.add("World");
        set.add("Hello");

        System.out.println(set.contains("Hello"));
        System.out.println(set.contains("Java"));

        for (String s : set) {
            System.out.println(s);
        }

        set.remove("Hello");
        System.out.println(set.contains("Hello"));
    }
}
