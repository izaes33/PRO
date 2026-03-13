package model;

import lombok.*;

import java.time.OffsetDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Clasificacion {
    private Team[] table;
}