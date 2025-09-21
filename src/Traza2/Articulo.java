package Traza2;

import Traza1.Sucursal;
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
public class Articulo {
    protected Long id;

    protected Double precioVenta;
    protected String denominacion;

    protected Set<Imagen> imagenes = new HashSet<>();
    protected UnidadMedida unidadMedida;
    protected Categoria categoria;
    protected Sucursal sucursal;
}



