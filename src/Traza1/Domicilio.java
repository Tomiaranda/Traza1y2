package Traza1;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString(exclude = "localidad")
public class Domicilio {
    private Long identificacion;
    private String calle;
    private Integer numero;
    private Integer cp;

    private Localidad localidad;
}
