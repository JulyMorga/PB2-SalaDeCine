package com.morga.candyBar;

public class CandyBar {
	private Producto[] productos;
	
	public CandyBar(int cantidadDeProductos) {
		productos = new Producto[cantidadDeProductos];
	}

	public boolean agregarProducto(Producto producto) {
		for (int i = 0; i < productos.length; i++) {
			if(productos[i] == null) {
				productos[i] = producto;
				return true;
			}
		}

		return false;
	}

	public boolean eliminarProducto(String nombreABuscar) {

		for (int i = 0; i < productos.length; i++) {
			if(productos[i] != null && productos[i].getNombre().equalsIgnoreCase(nombreABuscar)) {
				productos[i] = null;
				return true;
			}
		}
		return false;
	}

	public Producto[] obtenerInventario() {
		return this.productos;
	}
	

}
