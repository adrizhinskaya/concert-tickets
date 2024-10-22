package com.example;

import com.example.service.TicketService;
import com.example.service.UserService;
import model.enums.TicketType;

public class TicketServiceApp {
    public static void main(String[] args) {
        UserService userService = new UserService();

        userService.add("Alice");
        System.out.println("User 'Alice' added.");
        String userName = userService.getById(1);
        System.out.println("User with ID 1: " + userName);
        userService.deleteById(1);
        System.out.println("User with ID 1 deleted.");
        userName = userService.getById(1);
        System.out.println("User with ID 1 after deleting: " + userName);
        userService.add("Alice");
        System.out.println("User 'Alice' added.");
        userName = userService.getById(2);
        System.out.println("User with ID 2: " + userName);


        TicketService ticketService = new TicketService();
        ticketService.add(2, TicketType.DAY);
        System.out.println("\nTicket with ID 1 added.");
        String ticketType = ticketService.getById(2, 1);
        System.out.println("Ticket with ID 1 has ticketType: " + ticketType);
        ticketService.update(1, TicketType.WEEK);
        System.out.println("Ticket with ID 1 updated ticketType.");
        ticketType = ticketService.getById(2, 1);
        System.out.println("Updated Ticket ticketType with ID 1: " + ticketType);
    }
}

