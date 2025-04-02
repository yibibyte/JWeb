package dao;

import model.Account;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    // Основные CRUD-операции
    int insertUser(Account account) throws SQLException;
    boolean updateUser(Account account) throws SQLException;
    boolean deleteUser(int id) throws SQLException;
    Optional<Account> findById(int id) throws SQLException;

    // Поисковые методы
    Optional<Account> findByUsername(String username) throws SQLException;
    Optional<Account> findByEmail(String email) throws SQLException;
    List<Account> findByRole(String role) throws SQLException;

    // Методы для аутентификации
    boolean existsByUsername(String username) throws SQLException;
    boolean existsByEmail(String email) throws SQLException;

    // Дополнительные методы
    boolean updatePassword(int userId, String newPasswordHash) throws SQLException;
    boolean updateAvatar(int userId, String avatarUrl) throws SQLException;
    List<Account> findAllActiveUsers() throws SQLException;

    // Пагинация
    List<Account> findUsersWithPagination(int offset, int limit) throws SQLException;
}