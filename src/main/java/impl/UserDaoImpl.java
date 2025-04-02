package impl;

import dao.UserDao;
import model.Account;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

public class UserDaoImpl implements UserDao {
    private final DataSource dataSource;

    public UserDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int insertUser(Account account) throws SQLException {
        String sql = "INSERT INTO users (username, password_hash, first_name, last_name, email, age, role) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING id";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getPasswordHash());
            stmt.setString(3, account.getFirstName());
            stmt.setString(4, account.getLastName());
            stmt.setString(5, account.getEmail());
            stmt.setInt(6, account.getAge());
            stmt.setString(7, account.getRole());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            throw new SQLException("Failed to insert user");
        }
    }

    @Override
    public boolean updateUser(Account account) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return false;
    }

    @Override
    public Optional<Account> findById(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<Account> findByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(mapRowToUser(rs));
            }
            return Optional.empty();
        }
    }

    @Override
    public Optional<Account> findByEmail(String email) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Account> findByRole(String role) throws SQLException {
        return List.of();
    }

    @Override
    public boolean existsByUsername(String username) throws SQLException {
        return false;
    }

    @Override
    public boolean existsByEmail(String email) throws SQLException {
        return false;
    }

    @Override
    public boolean updatePassword(int userId, String newPasswordHash) throws SQLException {
        return false;
    }

    @Override
    public boolean updateAvatar(int userId, String avatarUrl) throws SQLException {
        return false;
    }

    @Override
    public List<Account> findAllActiveUsers() throws SQLException {
        return List.of();
    }

    @Override
    public List<Account> findUsersWithPagination(int offset, int limit) throws SQLException {
        return List.of();
    }

    private Account mapRowToUser(ResultSet rs) throws SQLException {
        return Account.builder()
                .id(rs.getInt("id"))
                .username(rs.getString("username"))
                .passwordHash(rs.getString("password_hash"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .email(rs.getString("email"))
                .age(rs.getInt("age"))
                .isActive(rs.getBoolean("is_active"))
                .role(rs.getString("role"))
                .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                .build();
    }
}