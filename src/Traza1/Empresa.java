package Traza1;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@ToString(exclude = "sucursales")
public class Empresa {
    private Long identificacion;
    private String nombre;
    private String razonSocial;
    private Integer cuit;
    private String logotipo;
    private Set<Sucursal> sucursales = new HashSet<>();
}
