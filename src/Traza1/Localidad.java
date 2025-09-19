package Traza1;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@ToString(exclude = "provincia")
public class Localidad {
    private Long identificacion;
    private String nombre;
    private Set<Domicilio> domicilios = new HashSet<>();

    private Provincia provincia;
}
