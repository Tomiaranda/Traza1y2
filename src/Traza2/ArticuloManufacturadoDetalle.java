package Traza2;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ArticuloManufacturadoDetalle {
    private Long id;   // antes: identificacion
    private Integer cantidad;

    private ArticuloInsumo articuloInsumo;
}


