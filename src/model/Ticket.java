package model;

import model.enums.Sector;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Ticket extends EntityWithId {
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
        checkConcertHall(concertHall);
        checkEventCode(eventCode);
        checkMaxWeightInKg(maxWeightInKg);

        setId(id);
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.maxWeightInKg = maxWeightInKg;
        this.time = time;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.price = price;
    }

    public Ticket(String concertHall, Integer eventCode, LocalDateTime time) {
        super();
        checkConcertHall(concertHall);
        checkEventCode(eventCode);

        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
    }

    public Ticket() {
        super();
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setStadiumSector(Sector stadiumSector) {
        this.stadiumSector = stadiumSector;
    }

    public String getConcertHall() {
        return concertHall;
    }

    public Integer getEventCode() {
        return eventCode;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public LocalDateTime getTicketCreationTime() {
        return ticketCreationTime;
    }

    public Boolean getPromo() {
        return isPromo;
    }

    public Sector getStadiumSector() {
        return stadiumSector;
    }

    public Double getMaxWeightInKg() {
        return maxWeightInKg;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void print() {
        System.out.println("TICKET print() method");
    }

    public void shared(String phone) {
        System.out.println("Shared by phone " + phone);
    }

    public void shared(String phone, String email) {
        System.out.printf("Shared by phone %s and email %s%n", phone, email);
    }

    private void checkConcertHall(String concertHall) {
        if (concertHall.length() > 10) {
            throw new RuntimeException("concertHall field length must not be longer than 10 .");
        }
    }

    private void checkEventCode(Integer eventCode) {
        if (eventCode < 0 || eventCode > 999) {
            throw new RuntimeException("eventCode field must have 3 digits .");
        }
    }

    private void checkMaxWeightInKg(Double maxWeightInKg) {
        if (maxWeightInKg < 0) {
            throw new RuntimeException("maxWeightInKg field must be greater than zero .");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(concertHall, ticket.concertHall) &&
                Objects.equals(eventCode, ticket.eventCode) &&
                Objects.equals(time, ticket.time) &&
                Objects.equals(ticketCreationTime, ticket.ticketCreationTime) &&
                Objects.equals(isPromo, ticket.isPromo) &&
                stadiumSector == ticket.stadiumSector &&
                Objects.equals(maxWeightInKg, ticket.maxWeightInKg) &&
                Objects.equals(price, ticket.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(concertHall, eventCode, time, ticketCreationTime, isPromo, stadiumSector, maxWeightInKg,
                price);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "concertHall='" + concertHall + '\'' +
                ", eventCode=" + eventCode +
                ", time=" + time +
                ", ticketCreationTime=" + ticketCreationTime +
                ", isPromo=" + isPromo +
                ", stadiumSector=" + stadiumSector +
                ", maxWeightInKg=" + maxWeightInKg +
                ", price=" + price +
                '}';
    }
}


