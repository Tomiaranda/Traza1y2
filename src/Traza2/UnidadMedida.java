package Traza2;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UnidadMedida {
    private Long id;   // antes: identificacion
    private String denominacion;

    private Set<Articulo> articulos = new HashSet<>();
}

