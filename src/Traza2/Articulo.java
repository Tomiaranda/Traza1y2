package Traza2;

import Traza1.Sucursal;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Data
@SuperBuilder
@ToString
public class Articulo {
    protected Long identificacion;
    protected Double precioVenta;
    protected String denominacion;

    // Constructor vacío
    public Articulo() {}

    protected Set<Imagen> imagenes = new HashSet<>();
    protected UnidadMedida unidadMedida;
    protected Categoria categoria;
    protected Sucursal sucursal;
}

