package Traza1;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import Traza2.Articulo;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString(exclude = "empresa")
public class Sucursal {
    private Long identificacion;
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private boolean esCasaMatriz;

    private Empresa empresa;
    private Domicilio domicilio;
    private Set<Articulo> articulos = new HashSet<>();
}
