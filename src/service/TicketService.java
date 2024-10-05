package service;

import model.enums.Sector;
import model.Ticket;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

public class TicketService {
    Map<UUID, Ticket> ticketMap = new HashMap<>();

    public void fillRepository() {
        Ticket ticket0 = new Ticket();
        Ticket ticket1 = new Ticket("Hall 1", 111, LocalDateTime.now().plusDays(1));
        Ticket ticket2 = new Ticket("Hall 2", 222, LocalDateTime.now().plusDays(2));
        Ticket ticket3 = new Ticket("Hall 3", 333, LocalDateTime.now().plusDays(3));
        Ticket ticket4 = new Ticket("Hall 4", 444, LocalDateTime.now().plusDays(4));
        Ticket ticket5 = new Ticket("Hall 5", 555, LocalDateTime.now().plusDays(5));
        Ticket ticket6 = new Ticket("Hall 6", 666, LocalDateTime.now().plusDays(6));
        Ticket ticket7 = new Ticket("Hall 7", 777, LocalDateTime.now().plusDays(7));
        Ticket ticket8 = new Ticket("Hall 8", 888, LocalDateTime.now().plusDays(8));
        Ticket ticket9 = new Ticket(UUID.randomUUID(), "Hall 9", 999,
                LocalDateTime.now().plusDays(9), false, Sector.A, 7.00, BigDecimal.ONE);

        createTicket(ticket0);
        createTicket(ticket1);
        createTicket(ticket2);
        createTicket(ticket3);
        createTicket(ticket4);
        createTicket(ticket5);
        createTicket(ticket6);
        createTicket(ticket7);
        createTicket(ticket8);
        createTicket(ticket9);
    }

    public Ticket createTicket(Ticket ticket) {
        if (ticket.getId() == null) {
            ticket.setId(generateId());
        }
        ticketMap.put(ticket.getId(), ticket);
        return ticket;
    }

    public Ticket getById(UUID id) {
        if (!ticketMap.containsKey(id) || id == null) {
            throw new NoSuchElementException("Ticket with id " + id + "doesn't exist. ");
        }
        return ticketMap.get(id);
    }

    private UUID generateId() {
        return UUID.randomUUID();
    }
}
