package Traza1;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@ToString(exclude = "pais")
public class Provincia {
    private Long identificacion;
    private String nombre;
    private Set<Localidad> localidades = new HashSet<>();

    private Pais pais;
}
