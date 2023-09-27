package com.ferreteria.api.Producto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "producto")
@Entity(name = "Producto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String nombre;
	String descripcion;
	int precio;
	int cantidad;

	public Producto(ProductoRegistrar productoRegistrar) {
		this.nombre = productoRegistrar.nombre();
		this.descripcion = productoRegistrar.descripcion();
		this.precio = productoRegistrar.precio();
		this.cantidad = productoRegistrar.cantidad();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void ActualizarProducto(ProductoActualizar actualizar) {
		if (actualizar.nombre() != null) {
			this.nombre = actualizar.nombre();
		}
		if (actualizar.descripcion() != null) {
			this.descripcion = actualizar.descripcion();
		}
		if (actualizar.precio() != 0) {
			this.precio = actualizar.precio();
		}
		if (actualizar.cantidad() != 0) {
			this.cantidad = actualizar.cantidad();
		}
	}
}
