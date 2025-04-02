package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

/**
 *  Пользователи
 * @author Gnevashev Ilya
 * @NAME ilmanuser
 * @version 1.0
 * @since 03.04.2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private String email;

    // Метод для генерации тестовых пользователей
    public static List<User> generateTestUsers() {
        return List.of(
                // Администраторы
                User.builder()
                        .login("admin")
                        .password("admin123")
                        .firstName("Алексей")
                        .lastName("Петров")
                        .age(35)
                        .email("admin@example.com")
                        .build(),

                // Обычные пользователи
                User.builder()
                        .login("ivan_ivanov")
                        .password("qwerty123")
                        .firstName("Иван")
                        .lastName("Иванов")
                        .age(28)
                        .email("ivan@example.com")
                        .build(),

                User.builder()
                        .login("anna_sidorova")
                        .password("anna2023")
                        .firstName("Анна")
                        .lastName("Сидорова")
                        .age(22)
                        .email("anna@example.com")
                        .build(),

                // Дополнительные пользователи (17 шт)
                User.builder().login("petr_petrov").password("petrpass").firstName("Пётр").lastName("Петров").age(31).email("petr@example.com").build(),
                User.builder().login("elena").password("elenapass").firstName("Елена").lastName("Кузнецова").age(25).email("elena@example.com").build(),
                User.builder().login("sergey").password("sergey88").firstName("Сергей").lastName("Васильев").age(40).email("sergey@example.com").build(),
                User.builder().login("olga").password("olga2023").firstName("Ольга").lastName("Смирнова").age(29).email("olga@example.com").build(),
                User.builder().login("dmitry").password("dima555").firstName("Дмитрий").lastName("Попов").age(33).email("dmitry@example.com").build(),
                User.builder().login("ekaterina").password("katya").firstName("Екатерина").lastName("Морозова").age(26).email("ekaterina@example.com").build(),
                User.builder().login("nikolay").password("kolya").firstName("Николай").lastName("Волков").age(45).email("nikolay@example.com").build(),
                User.builder().login("alexander").password("sasha").firstName("Александр").lastName("Лебедев").age(38).email("alexander@example.com").build(),
                User.builder().login("maria").password("mariapass").firstName("Мария").lastName("Фёдорова").age(27).email("maria@example.com").build(),
                User.builder().login("vladimir").password("vova").firstName("Владимир").lastName("Павлов").age(42).email("vladimir@example.com").build(),
                User.builder().login("svetlana").password("sveta").firstName("Светлана").lastName("Голубева").age(25).email("svetlana@example.com").build(),
                User.builder().login("mikhail").password("misha").firstName("Михаил").lastName("Виноградов").age(36).email("mikhail@example.com").build(),
                User.builder().login("tatyana").password("tanya").firstName("Татьяна").lastName("Белова").age(29).email("tatyana@example.com").build(),
                User.builder().login("andrey").password("andrey").firstName("Андрей").lastName("Комаров").age(31).email("andrey@example.com").build(),
                User.builder().login("natalia").password("nata").firstName("Наталья").lastName("Орлова").age(27).email("natalia@example.com").build(),
                User.builder().login("artem").password("artem").firstName("Артём").lastName("Андреев").age(24).email("artem@example.com").build(),
                User.builder().login("irina").password("ira").firstName("Ирина").lastName("Макарова").age(32).email("irina@example.com").build()
        );
    }
}