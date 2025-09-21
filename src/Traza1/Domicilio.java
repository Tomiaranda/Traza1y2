package Traza1;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.ToString;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "localidad")
public class Domicilio {
    private Long id;   // antes: identificacion
    private String calle;
    private Integer numero;
    private Integer cp;

    private Localidad localidad;
}

