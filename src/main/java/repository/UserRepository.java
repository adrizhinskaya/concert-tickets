package repository;

import model.User;
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
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public long addAndReturnId(String name) {
        String sqlQuery = "insert into User(name, creation_date) values (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setString(2, LocalDate.now().toString());
            return ps;
        }, keyHolder);

        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    public User getById(Long id) {
        String sqlQuery = "select * from User where id = ?";
        return jdbcTemplate.queryForObject(sqlQuery, this::mapRowToUser, id);
    }

    public void deleteById(Long userId) {
        String sqlQuery = "DELETE FROM User WHERE user_id = ?";
        jdbcTemplate.update(sqlQuery, userId);
    }

    public boolean userExists(Long id) {
        String sqlQuery = "select count(*) from User where id = ?";
        Integer count = jdbcTemplate.queryForObject(sqlQuery, Integer.class, id);
        return count != null && count > 0;
    }

    private User mapRowToUser(ResultSet resultSet, Integer rowNum) throws SQLException {
        User user = User.builder()
                .name(resultSet.getString("name"))
                .creationDate(resultSet.getDate("creation_date").toLocalDate())
                .build();
        user.setId(resultSet.getLong("id"));
        return user;
    }
}
