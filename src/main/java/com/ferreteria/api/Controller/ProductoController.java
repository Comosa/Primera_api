package com.ferreteria.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.api.Producto.Producto;
import com.ferreteria.api.Producto.ProductoActualizar;
import com.ferreteria.api.Producto.ProductoListado;
import com.ferreteria.api.Producto.ProductoMostrar;
import com.ferreteria.api.Producto.ProductoRegistrar;
import com.ferreteria.api.Producto.ProductoRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/product")
public class ProductoController {
	@Autowired
	private ProductoRepository productoRepository;
	
	@PostMapping
	public void Registrar(@RequestBody ProductoRegistrar productoRegistrar) {
		productoRepository.save(new Producto(productoRegistrar));
		//System.out.println(productoRegistrar);
	}
	@GetMapping
	public Page<ProductoListado> listarProducto(Pageable paginacion){
		return productoRepository.findAll(paginacion).map(ProductoListado :: new );
	}
	@GetMapping("/{id}")
	public ResponseEntity<ProductoMostrar>  Listarproducto(@PathVariable Long id) {
		Producto producto = productoRepository.getReferenceById(id);
		
		var datos = new ProductoMostrar(producto.getId(), producto.getNombre(),producto.getDescripcion(),producto.getPrecio(),producto.getCantidad());
				return ResponseEntity.ok(datos);
	}
	
	@PutMapping
	@Transactional
	public void Actualizar(@RequestBody ProductoActualizar productoActualizar) {
		Producto producto = productoRepository.getReferenceById(productoActualizar.id());
		producto.ActualizarProducto(productoActualizar);
		//System.out.println(producto);
	}
	
}
