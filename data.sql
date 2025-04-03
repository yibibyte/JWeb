

INSERT INTO users (
    username,
    password_hash,
    first_name,
    last_name,
    email,
    age,
    is_active,
    role,
    is_email_verified,
    phone_number,
    avatar_url
) VALUES
-- Администраторы
('admin', '$2a$10$xJwL5vx5z5U2hB6cLZqkUeYl6Z7wQ8vR9mN0sK1L2M3N4O5P6Q7R8S9T0', 'Алексей', 'Петров', 'admin@example.com', 35, true, 'ADMIN', true, '+79111234567', 'https://example.com/avatars/admin.jpg');

// Вставка пользователей с уникальными именами и хеш-паролями случайными данными
INSERT INTO users (
    username,
    password_hash,
    first_name,
    last_name,
    email,
    age,
    is_active,
    role,
    is_email_verified,
    phone_number,
    avatar_url
) VALUES
-- Администраторы
('admin', '$2a$10$xJwL5vx5z5U2hB6cLZqkUeYl6Z7wQ8vR9mN0sK1L2M3N4O5P6Q7R8S9T0', 'Алексей', 'Петров', 'admin@example.com', 35, true, 'ADMIN', true, '+79111234567', 'https://example.com/avatars/admin.jpg'),
('supervisor', '$2a$10$yH9vX8u7R6tQ5w4E3D2C1B0N9M8L7K6J5I4H3G2F1E0D9C8B7A6Z5Y4', 'Ольга', 'Сидорова', 'supervisor@example.com', 32, true, 'ADMIN', true, '+79217654321', 'https://example.com/avatars/supervisor.jpg'),

-- Менеджеры
('manager1', '$2a$10$zA1B2C3D4E5F6G7H8I9J0K1L2M3N4O5P6Q7R8S9T0U1V2W3X4Y5Z6', 'Иван', 'Козлов', 'manager1@example.com', 28, true, 'MANAGER', true, '+79031112233', NULL),
('manager2', '$2a$10$qW1E2R3T4Y5U6I7O8P9A0S1D2F3G4H5J6K7L8Z9X0C1V2B3N4M5Q6W7', 'Елена', 'Николаева', 'manager2@example.com', 31, true, 'MANAGER', true, '+79032223344', 'https://example.com/avatars/elena.jpg'),

-- Обычные пользователи
('user1', '$2a$10$aB1cD2eF3gH4iJ5kL6mN7oP8qR9sT0uV1wX2yZ3A4B5C6D7E8F9G0H1', 'Дмитрий', 'Волков', 'user1@example.com', 25, true, 'USER', true, '+79053334455', NULL),
('user2', '$2a$10$bC2dE3fG4hI5jK6lM7nO8pQ9rS0tU1vW2xY3zA4B5C6D7E8F9G0H1I2', 'Анна', 'Зайцева', 'user2@example.com', 22, true, 'USER', false, '+79054445566', 'https://example.com/avatars/anna.jpg'),
('user3', '$2a$10$cD3eF4gH5iJ6kL7mN8oP9qR0sT1uV2wX3yZ4A5B6C7D8E9F0G1H2I3J4', 'Сергей', 'Белов', 'user3@example.com', 27, true, 'USER', true, '+79055556677', NULL),
('user4', '$2a$10$dE4fG5hI6jK7lM8nO9pQ0rS1tU2vW3xY4zA5B6C7D8E9F0G1H2I3J4K5', 'Мария', 'Крылова', 'user4@example.com', 29, false, 'USER', true, '+79056667788', 'https://example.com/avatars/maria.jpg'),

-- Тестовые пользователи с разными данными
('test_user5', '$2a$10$eF5gH6iJ7kL8mN9oP0qR1sT2uV3wX4yZ5A6B7C8D9E0F1G2H3I4J5K6', 'Артем', 'Гусев', 'artem@example.com', 24, true, 'USER', false, '+79057778899', NULL),
('test_user6', '$2a$10$fG6hI7jK8lM9nO0pQ1rS2tU3vW4xY5zA6B7C8D9E0F1G2H3I4J5K6L7', 'Виктория', 'Орлова', 'vika@example.com', 26, true, 'USER', true, '+79058889900', 'https://example.com/avatars/vika.jpg'),
('test_user7', '$2a$10$gH7iJ8kL9mN0oP1qQ2rS3tU4vW5xY6zA7B8C9D0E1F2G3H4I5J6K7L8', 'Павел', 'Морозов', 'pavel@example.com', 30, true, 'USER', true, '+79059990011', NULL),
('test_user8', '$2a$10$hI8jK9lM0nO1pP2qQ3rS4tU5vW6xY7zA8B9C0D1E2F3G4H5I6J7K8L9', 'Юлия', 'Власова', 'yulia@example.com', 23, false, 'USER', false, '+79051001122', 'https://example.com/avatars/yulia.jpg'),

-- Пользователи с минимальными данными
('minimal1', '$2a$10$iJ9kL0mN1oO2pP3qQ4rS5tU6vW7xY8zA9B0C1D2E3F4G5H6I7J8K9', 'Антон', 'Иванов', 'minimal1@example.com', 20, true, 'USER', false, NULL, NULL),
('minimal2', '$2a$10$jK0lL1mN2oO3pP4qQ5rS6tU7vW8xY9zA0B1C2D3E4F5G6H7I8J9K0', 'Кристина', 'Петрова', 'minimal2@example.com', 21, true, 'USER', false, NULL, NULL),

-- Пользователи для тестирования граничных случаев
('long_username_1234567890', '$2a$10$kL1mN2oO3pP4qQ5rS6tU7vW8xY9zA0B1C2D3E4F5G6H7I8J9K0L1', 'Александр', 'Длиннофамильный', 'long@example.com', 40, true, 'USER', true, '+79123456789', NULL),
('special_chars_!@#$', '$2a$10$lM2nO3pP4qQ5rS6tU7vW8xY9zA0B1C2D3E4F5G6H7I8J9K0L1M2', 'Екатерина', 'Символова', 'special@example.com', 33, true, 'USER', true, '+79234567890', NULL),
('inactive_user', '$2a$10$mN3oP4qQ5rS6tU7vW8xY9zA0B1C2D3E4F5G6H7I8J9K0L1M2N3', 'Максим', 'Неактивов', 'inactive@example.com', 45, false, 'USER', false, '+79345678901', NULL),
('no_email_user', '$2a$10$nO4pP5qQ6rS7tU8vW9xY0zA1B2C3D4E5F6G7H8I9J0K1L2M3N4O5', 'Вадим', 'Беземейлов', NULL, 50, true, 'USER', false, '+79456789012', NULL);