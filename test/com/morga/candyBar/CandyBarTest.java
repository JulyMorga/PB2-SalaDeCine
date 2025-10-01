package com.morga.candyBar;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CandyBarTest {

    private CandyBar candyBar;
    private Snack palomitas;
    private Bebida refresco;

    // Se ejecuta antes de cada test para inicializar el objeto CandyBar
    @Before
    public void setUp() {
        candyBar = new CandyBar(5); // Capacidad para 5 productos
        palomitas = new Snack("Palomitas", 5.0, Tamano.MEDIANO, 10);
        refresco = new Bebida("Refresco", 3.0, Contenedor.VASO, 15);
    }

    @Test
    public void testAgregarProducto() {
        assertTrue(candyBar.agregarProducto(palomitas));
        assertEquals(1, contarProductosEnInventario());

        assertTrue(candyBar.agregarProducto(refresco));
        assertEquals(2, contarProductosEnInventario());

    }

    @Test
    public void testEliminarProductoExistente() {
        candyBar.agregarProducto(palomitas);
        candyBar.agregarProducto(refresco);

        boolean eliminado = candyBar.eliminarProducto("Palomitas");
        assertTrue(eliminado);
        assertEquals(1, contarProductosEnInventario());
        assertNull(candyBar.obtenerInventario()[0]);
    }

    @Test
    public void testEliminarProductoNoExistente() {
        candyBar.agregarProducto(palomitas);

        boolean eliminado = candyBar.eliminarProducto("Chocolate");
        assertFalse(eliminado);
        assertEquals(1, contarProductosEnInventario());
    }

    @Test
    public void testInventarioLleno() {
        // Llenar el inventario hasta su capacidad
        for (int i = 0; i < 5; i++) {
            candyBar.agregarProducto(new Snack("Snack " + i, 1.0, Tamano.MEDIANO, 5));
        }

        // Intentar agregar un sexto producto
        boolean agregado = candyBar.agregarProducto(new Snack("Snack Extra", 1.0, Tamano.MEDIANO, 3));
        assertFalse(agregado);
        assertEquals(5, contarProductosEnInventario());
    }

    private int contarProductosEnInventario() {
        int count = 0;
        for (Producto p : candyBar.obtenerInventario()) {
            if (p != null) {
                count++;
            }
        }
        return count;
    }
}
