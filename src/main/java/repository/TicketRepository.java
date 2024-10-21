package repository;

import model.Ticket;
import model.enums.TicketType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Objects;

@Repository
public class TicketRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TicketRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public long addAndReturnId(Long userId, TicketType ticketType) {
        String sqlQuery = "insert into Ticket(user_id, ticket_type, creation_date) values (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, userId.toString());
            ps.setString(2, ticketType.toString());
            ps.setString(3, LocalDate.now().toString());
            return ps;
        }, keyHolder);

        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    public Ticket getById(Long userId, Long ticketId) {
        String sqlQuery = "select * from Ticket where id = ? AND user_id = ?";
        return jdbcTemplate.queryForObject(sqlQuery, this::mapRowToTicket, ticketId, userId);
    }

    public void update(Long ticketId, String ticketType) {
        String sqlQuery = "update Ticket set ticket_type = ? where id = ?";
        jdbcTemplate.update(sqlQuery, ticketType, ticketId);
    }

    public boolean ticketExists(Long id) {
        String sqlQuery = "select count(*) from Ticket where id = ?";
        Integer count = jdbcTemplate.queryForObject(sqlQuery, Integer.class, id);
        return count != null && count > 0;
    }

    private Ticket mapRowToTicket(ResultSet resultSet, Integer rowNum) throws SQLException {
        Ticket ticket = Ticket.builder()
                .userId(resultSet.getLong("user_id"))
                .ticketType(TicketType.valueOf(resultSet.getString("ticket_type")))
                .creationDate(resultSet.getDate("creation_date").toLocalDate())
                .build();
        ticket.setId(resultSet.getLong("id"));
        return ticket;
    }
}
