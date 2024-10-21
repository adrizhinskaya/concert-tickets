package model;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Setter;
import model.enums.TicketType;

import java.time.LocalDate;

@Builder
@Setter
public class Ticket {
    private Long id;
    //@NotNull
    private Long userId;
    //@NotNull
    private TicketType ticketType;
    private LocalDate creationDate;
}