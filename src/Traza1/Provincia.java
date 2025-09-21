package Traza1;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.util.HashSet;
import java.util.Set;
import lombok.ToString;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "pais")
public class Provincia {
    private Long id;
    private String nombre;
    private Set<Localidad> localidades = new HashSet<>();

    private Pais pais;
}

