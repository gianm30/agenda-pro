package com.gian.carrasco.agenda.pro.api.rest.aplicacion.servicios;

import com.gian.carrasco.agenda.pro.api.rest.dominio.evento.productor.ProductoProductor;
import com.gian.carrasco.agenda.pro.api.rest.dominio.excepciones.NoExisteCategoriaExcepcion;
import com.gian.carrasco.agenda.pro.api.rest.dominio.excepciones.NoExisteMarcaExcepcion;
import com.gian.carrasco.agenda.pro.api.rest.dominio.excepciones.NoHayIdCategoriaExcepcion;
import com.gian.carrasco.agenda.pro.api.rest.dominio.excepciones.NoHayIdMarcaExcepcion;
import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Categoria;
import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Marca;
import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Producto;
import com.gian.carrasco.agenda.pro.api.rest.dominio.puerto.salida.CategoriaRepositorio;
import com.gian.carrasco.agenda.pro.api.rest.dominio.puerto.salida.MarcaRepositorio;
import com.gian.carrasco.agenda.pro.api.rest.dominio.puerto.salida.ProductoRepositorio;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static com.gian.carrasco.agenda.pro.api.rest.aplicacion.servicios.TestUtil.POSICION_INICIAL;
import static com.gian.carrasco.agenda.pro.api.rest.aplicacion.servicios.TestUtil.generar;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductoServicioTest {
    @InjectMocks
    private ProductoServicio servicio;

    @Mock
    private ProductoRepositorio repositorio;

    @Mock
    private CategoriaRepositorio categoriaRepositorio;

    @Mock
    private MarcaRepositorio marcaRepositorio;

    @Mock
    private ProductoProductor productor;

    @Nested
    class buscarTodos {
        @Test
        void cuandoNoHayDatos() {
            int filas = 0;
            List<Producto> datos = generar(filas, Producto.class);

            //Given
            when(repositorio.buscarTodos(anyInt(), anyInt())).thenReturn(datos);

            //When
            var rpta = servicio.buscarTodos(POSICION_INICIAL, filas);

            //Then
            assertThat(rpta).isNotNull();
            assertThat(rpta).isEmpty();
            verify(repositorio, only()).buscarTodos(POSICION_INICIAL, filas);
        }

        @Test
        void cuandoHayDatos() {
            int filas = 10;
            List<Producto> datos = generar(filas, Producto.class);

            //Given
            when(repositorio.buscarTodos(anyInt(), anyInt())).thenReturn(datos);

            //When
            var rpta = servicio.buscarTodos(POSICION_INICIAL, filas);

            //Then
            assertThat(rpta).isNotNull();
            assertThat(rpta).hasSize(datos.size());
            verify(repositorio, only()).buscarTodos(POSICION_INICIAL, filas);
        }
    }

    @Nested
    class buscarPorId {
        @Test
        void cuandoNoHayDatos() {
            var id = 1;
            Optional<Producto> producto = empty();

            //Given
            when(repositorio.buscarPorId(anyInt())).thenReturn(producto);

            //When
            var rpta = servicio.buscarPorId(id);

            //Then
            assertThat(rpta).isNotNull();
            assertThat(rpta.isEmpty()).isTrue();
            verify(repositorio, only()).buscarPorId(id);
        }

        @Test
        void cuandoHayDatos() {
            var id = 1;
            var producto = of(Producto.builder().id(id).build());

            //Given
            when(repositorio.buscarPorId(anyInt())).thenReturn(producto);

            //When
            var rpta = servicio.buscarPorId(id);

            //Then
            assertThat(rpta).isNotNull();
            assertThat(rpta.isPresent()).isTrue();
            assertThat(rpta.get().getId()).isEqualTo(id);
            verify(repositorio, only()).buscarPorId(id);
        }
    }

    @Nested
    class buscarCoincidenciasPorNombre {
        @Test
        void cuandoNoHayDatos() {
            int filas = 0;
            String nombre = "Laptop";
            List<Producto> datos = generar(filas, Producto.class);

            //Given
            when(repositorio.buscarCoincidenciasPorNombre(anyString())).thenReturn(datos);

            //When
            var rpta = servicio.buscarCoincidenciasPorNombre(nombre);

            //Then
            assertThat(rpta).isNotNull();
            assertThat(rpta).isEmpty();
            verify(repositorio, only()).buscarCoincidenciasPorNombre(nombre);
        }

        @Test
        void cuandoHayDatos() {
            int filas = 10;
            String nombre = "Laptop";
            List<Producto> datos = generar(filas, Producto.class);

            //Given
            when(repositorio.buscarCoincidenciasPorNombre(anyString())).thenReturn(datos);

            //When
            var rpta = servicio.buscarCoincidenciasPorNombre(nombre);

            //Then
            assertThat(rpta).isNotNull();
            assertThat(rpta).hasSize(datos.size());
            verify(repositorio, only()).buscarCoincidenciasPorNombre(nombre);
        }
    }

    @Nested
    class crear {
        @Test
        void cuandoNoSeEnviaCategoria() {
            //Given
            //When
            assertThrows(NoHayIdCategoriaExcepcion.class, () -> servicio.crear(new Producto()));

            //Then
            verify(categoriaRepositorio, never()).buscarPorId(anyInt());
        }

        @Test
        void cuandoNoExisteCategoria() {
            var producto = Producto.builder()
                    .categoria(Categoria.builder()
                            .id(1)
                            .build())
                    .build();

            //Given
            when(categoriaRepositorio.buscarPorId(anyInt())).thenReturn(empty());

            //When
            assertThrows(NoExisteCategoriaExcepcion.class, () -> servicio.crear(producto));

            //Then
            verify(categoriaRepositorio, only()).buscarPorId(anyInt());
        }

        @Test
        void cuandoNoSeEnviaMarca() {
            var objCategoria = Categoria.builder()
                    .id(1)
                    .build();
            var objProducto = Producto.builder()
                    .categoria(objCategoria)
                    .build();
            var categoria = of(objCategoria);

            //Given
            when(categoriaRepositorio.buscarPorId(anyInt())).thenReturn(categoria);

            //When
            assertThrows(NoHayIdMarcaExcepcion.class, () -> servicio.crear(objProducto));

            //Then
            verify(categoriaRepositorio, only()).buscarPorId(anyInt());
        }

        @Test
        void cuandoNoExisteMarca() {
            var objCategoria = Categoria.builder()
                    .id(1)
                    .build();
            var objMarca = Marca.builder()
                    .id(1)
                    .build();
            var objProducto = Producto.builder()
                    .categoria(objCategoria)
                    .marca(objMarca)
                    .build();
            var categoria = of(objCategoria);
            var marca = of(objMarca);

            //Given
            when(categoriaRepositorio.buscarPorId(anyInt())).thenReturn(categoria);
            when(marcaRepositorio.buscarPorId(anyInt())).thenReturn(empty());

            //When
            assertThrows(NoExisteMarcaExcepcion.class, () -> servicio.crear(objProducto));

            //Then
            verify(categoriaRepositorio, only()).buscarPorId(anyInt());
            verify(marcaRepositorio, only()).buscarPorId(anyInt());
        }

        @Test
        void cuandoNoSePudoGuardar() {
            var objCategoria = Categoria.builder()
                    .id(1)
                    .build();
            var objMarca = Marca.builder()
                    .id(1)
                    .build();
            var objProducto = Producto.builder()
                    .categoria(objCategoria)
                    .marca(objMarca)
                    .build();
            var categoria = of(objCategoria);
            var marca = of(objMarca);

            //Given
            when(categoriaRepositorio.buscarPorId(anyInt())).thenReturn(categoria);
            when(marcaRepositorio.buscarPorId(anyInt())).thenReturn(marca);

            //When
            var rpta = servicio.crear(objProducto);

            //Then
            assertThat(rpta).isEmpty();
            verify(categoriaRepositorio, only()).buscarPorId(anyInt());
            verify(marcaRepositorio, only()).buscarPorId(anyInt());
        }
    }
}