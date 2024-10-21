package model;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Setter
public class User {
    private Long id;
    //@NotBlank
    private String name;
    private LocalDate creationDate;
}