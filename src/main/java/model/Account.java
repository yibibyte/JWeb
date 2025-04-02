package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Аккаунт пользователя
 *
 * @author Gnevashev Ilya
 * @NAME ilmanuser
 * @version 1.0
 * @since 03.04.2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    private int id;
    private String username;
    private String passwordHash; // Переименовано для соответствия Java naming conventions
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String role; // Роль пользователя (USER, ADMIN, MODERATOR) RBAC (Role-Based Access Control)

    // Дополнительные поля для безопасности
    private boolean isEmailVerified;
    private String phoneNumber;
    private String avatarUrl; // Ссылка на аватар

    // Метод для получения полного имени
    public String getFullName() {
        return firstName + " " + lastName;
    }
}