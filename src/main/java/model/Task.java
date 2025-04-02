package model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Задачи Пользователя
 *
 * @author Gnevashev Ilya
 * @NAME ilmanuser
 * @version 1.0
 * @since 03.04.2025
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "title", "description", "deadline", "executor", "isDone"})
public class Task {
    private int id;
    private String title;
    private String description;
    private boolean isDone;
    private User executor;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate deadline;

}
