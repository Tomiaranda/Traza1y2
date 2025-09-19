package Traza1;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@ToString
public class Pais {
    private Long identificacion;
    private String nombre;
    private Set<Provincia> provincias = new HashSet<>();
}
