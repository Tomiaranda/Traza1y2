import Traza1.*;
import Traza2.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Optional;



public class Main {
    public static void main(String[] args) {
        // Inicializar Repositorios
        InMemoryRepository<Categoria> categoriaRepo = new InMemoryRepository<>();
        InMemoryRepository<ArticuloInsumo> insumoRepo = new InMemoryRepository<>();
        InMemoryRepository<ArticuloManufacturado> manufacturadoRepo = new InMemoryRepository<>();
        InMemoryRepository<UnidadMedida> unidadRepo = new InMemoryRepository<>();
        InMemoryRepository<Empresa> empresaRepo = new InMemoryRepository<>();

        // =============================
        // Traza1: País, Provincias, Localidades, Domicilios
        // =============================
        Pais pais1 = Pais.builder().id(1L).nombre("Argentina").build();

        Provincia prov1 = Provincia.builder().id(1L).nombre("Buenos Aires").pais(pais1).build();
        Localidad local1 = Localidad.builder().id(1L).nombre("CABA").provincia(prov1).build();
        Domicilio dom1 = Domicilio.builder().id(1L).calle("Av. Cordoba").numero(4100).cp(1870).localidad(local1).build();

        Localidad local2 = Localidad.builder().id(2L).nombre("La Plata").provincia(prov1).build();
        Domicilio dom2 = Domicilio.builder().id(2L).calle("Av. 1").numero(1150).cp(1900).localidad(local2).build();

        Provincia prov2 = Provincia.builder().id(2L).nombre("Cordoba").pais(pais1).build();
        Localidad local3 = Localidad.builder().id(3L).nombre("Cordoba Capital").provincia(prov2).build();
        Domicilio dom3 = Domicilio.builder().id(3L).calle("Jujuy").numero(2602).cp(5000).localidad(local3).build();

        Localidad local4 = Localidad.builder().id(4L).nombre("Villa Carlos Paz").provincia(prov2).build();
        Domicilio dom4 = Domicilio.builder().id(4L).calle("San Martin").numero(500).cp(5152).localidad(local4).build();

        // =============================
        // Sucursales
        // =============================
        Sucursal s1 = Sucursal.builder()
                .id(1L).nombre("Sucursal 1")
                .horarioApertura(LocalTime.of(10, 0))
                .horarioCierre(LocalTime.of(23, 0))
                .esCasaMatriz(true).domicilio(dom1)
                .build();

        Sucursal s2 = Sucursal.builder()
                .id(2L).nombre("Sucursal 2")
                .horarioApertura(LocalTime.of(15, 0))
                .horarioCierre(LocalTime.of(20, 0))
                .esCasaMatriz(false).domicilio(dom2)
                .build();

        Sucursal s3 = Sucursal.builder()
                .id(3L).nombre("Sucursal 3")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(17, 0))
                .esCasaMatriz(true).domicilio(dom3)
                .build();

        Sucursal s4 = Sucursal.builder()
                .id(4L).nombre("Sucursal 4")
                .horarioApertura(LocalTime.of(17, 0))
                .horarioCierre(LocalTime.of(23, 30))
                .esCasaMatriz(false).domicilio(dom4)
                .build();

        // =============================
        // Empresas
        // =============================
        Empresa emp1 = Empresa.builder()
                .id(1L).nombre("Empresa 1")
                .cuit(345858575).razonSocial("Empresa 1 SA").logotipo("logo1.jpg")
                .sucursales(new HashSet<>(Set.of(s1, s2)))
                .build();

        Empresa emp2 = Empresa.builder()
                .id(2L).nombre("Empresa 2")
                .cuit(123456789).razonSocial("Empresa 2 SRL").logotipo("logo2.jpg")
                .sucursales(new HashSet<>(Set.of(s3, s4)))
                .build();

        s1.setEmpresa(emp1);
        s2.setEmpresa(emp1);
        s3.setEmpresa(emp2);
        s4.setEmpresa(emp2);

        empresaRepo.save(emp1);
        empresaRepo.save(emp2);

        // =============================
        // Categorías
        // =============================
        Categoria pizza = Categoria.builder().id(1L).denominacion("Pizza").build();
        Categoria lomos = Categoria.builder().id(2L).denominacion("Lomos").build();
        Categoria insumos = Categoria.builder().id(3L).denominacion("Insumos").build();

        categoriaRepo.save(pizza);
        categoriaRepo.save(lomos);
        categoriaRepo.save(insumos);

        // =============================
        // Unidades de Medida
        // =============================
        UnidadMedida kg = UnidadMedida.builder().id(1L).denominacion("Kilogramos").build();
        UnidadMedida g = UnidadMedida.builder().id(2L).denominacion("Gramos").build();
        UnidadMedida l = UnidadMedida.builder().id(3L).denominacion("Litros").build();

        unidadRepo.save(kg);
        unidadRepo.save(g);
        unidadRepo.save(l);

        // =============================
        // Insumos
        // =============================
        ArticuloInsumo sal = ArticuloInsumo.builder()
                .id(1L).denominacion("Sal").precioCompra(1000.0)
                .stockActual(10000).stockMinimo(500).esParaElaborar(true)
                .unidadMedida(g).categoria(insumos).sucursal(s1)
                .build();

        ArticuloInsumo carne = ArticuloInsumo.builder()
                .id(2L).denominacion("Carne").precioCompra(8000.0)
                .stockActual(20).stockMinimo(2).esParaElaborar(true)
                .unidadMedida(kg).categoria(insumos).sucursal(s1)
                .build();

        insumoRepo.save(sal);
        insumoRepo.save(carne);

        // =============================
        // Manufacturados
        // =============================
        Imagen img1 = Imagen.builder().id(1L).denominacion("PizzaHawaiana1").build();

        ArticuloManufacturadoDetalle d1 = ArticuloManufacturadoDetalle.builder()
                .id(1L).cantidad(1).articuloInsumo(sal).build();

        ArticuloManufacturadoDetalle d2 = ArticuloManufacturadoDetalle.builder()
                .id(2L).cantidad(1).articuloInsumo(carne).build();

        ArticuloManufacturado pizzaHawaiana = ArticuloManufacturado.builder()
                .id(1L).denominacion("Pizza Hawaiana").precioVenta(12000.0)
                .tiempoEstimadoMinutos(20).descripcion("8 porciones")
                .preparacion("Mezclar los ingredientes")
                .categoria(pizza).unidadMedida(kg)
                .imagenes(new HashSet<>(Set.of(img1)))
                .articuloManufacturadoDetalles(new HashSet<>(Set.of(d1, d2)))
                .sucursal(s1)
                .build();

        manufacturadoRepo.save(pizzaHawaiana);

        // =============================
        // Resultados de prueba
        // =============================
        System.out.println("\n=== Empresas ===");
        empresaRepo.findAll().forEach(System.out::println);

        System.out.println("\n=== Categorías ===");
        categoriaRepo.findAll().forEach(System.out::println);

        System.out.println("\n=== Insumos ===");
        insumoRepo.findAll().forEach(System.out::println);

        System.out.println("\n=== Manufacturados ===");
        manufacturadoRepo.findAll().forEach(System.out::println);

        // Buscar por campo
        System.out.println("\n=== Buscar empresa por nombre ===");
        empresaRepo.genericFindByField("nombre", "Empresa 1").forEach(System.out::println);
    }
}
