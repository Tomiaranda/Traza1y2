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


@ToString(exclude = "sucursales")
public class Empresa {
    private Long id;
    private String nombre;
    private String razonSocial;
    private Integer cuit;
    private String logotipo;
    private Set<Sucursal> sucursales = new HashSet<>();
}

