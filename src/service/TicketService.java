package service;

import model.Sector;
import model.Ticket;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TicketService {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Ticket ticket2 = new Ticket("Hall 3", 111, LocalDateTime.now().plusDays(3));
        Ticket ticket1 = new Ticket(UUID.randomUUID(), "Hall 3", 111,
                LocalDateTime.now().plusDays(3), false, Sector.A, 7.00, BigDecimal.ONE);
    }
}
