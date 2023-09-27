package com.ferreteria.api.Producto;

public record ProductoListado(Long id, String nombre, String descripcion, int precio, int cantidad){
	
	public ProductoListado(Producto producto) {
		this(producto.getId(),producto.getNombre(), producto.getDescripcion(), producto.getPrecio(),producto.getCantidad());
	}

}
