package Traza1;

import lombok.*;


import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pais {
    private Long id;
    private String nombre;
    private Set<Provincia> provincias = new HashSet<>();
}
