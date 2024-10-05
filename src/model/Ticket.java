package model;

import model.enums.Sector;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private UUID id;
    private String concertHall;
    private Integer eventCode;
    private LocalDateTime time;
    private final LocalDateTime ticketCreationTime = LocalDateTime.now();
    private Boolean isPromo;
    private Sector stadiumSector;
    private Double maxWeightInKg;
    private BigDecimal price;

    public Ticket(UUID id, String concertHall, Integer eventCode, LocalDateTime time, Boolean isPromo,
                  Sector stadiumSector, Double maxWeightInKg, BigDecimal price) {
        this.id = id;
        setConcertHall(concertHall);
        setEventCode(eventCode);
        this.time = time;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        setMaxWeightInKg(maxWeightInKg);
        this.price = price;
    }

    public Ticket(String concertHall, Integer eventCode, LocalDateTime time) {
        setConcertHall(concertHall);
        setEventCode(eventCode);
        this.time = time;
    }

    public Ticket() {
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setConcertHall(String concertHall) {
        if (concertHall.length() > 10) {
            throw new RuntimeException("concertHall field length must not be longer than 10 .");
        }
        this.concertHall = concertHall;
    }

    public void setEventCode(Integer eventCode) {
        if (eventCode < 0 || eventCode > 999) {
            throw new RuntimeException("eventCode field must have 3 digits .");
        }
        this.eventCode = eventCode;
    }

    public void setMaxWeightInKg(Double maxWeightInKg) {
        if (maxWeightInKg < 0) {
            throw new RuntimeException("maxWeightInKg field must be greater than zero .");
        }
        this.maxWeightInKg = maxWeightInKg;
    }

    public UUID getId() {
        return id;
    }
}


