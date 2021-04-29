package io.azzlo.e_commerce.controller;

import io.azzlo.e_commerce.model.Producto;
import io.azzlo.e_commerce.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/inicio")
@RestController
public class ProductoController {

    @Autowired
    ProductoService serviceProduc;

    @GetMapping("/")
    public ResponseEntity<List<Producto>> bucarProductos(){
        List<Producto> Productos = serviceProduc.buscarProductos();
        return new ResponseEntity<List<Producto>>(Productos, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto){
        Producto guardarProductos = serviceProduc.guardar(producto);
        return new ResponseEntity<Producto>(guardarProductos, HttpStatus.OK);
    }

    @GetMapping("/{idproducto}")
    public ResponseEntity<Producto> buscarProductoporId (@PathVariable("idproducto") Long idproducto){
        Producto encontrado = serviceProduc.encontrarPorId(idproducto);
        return new ResponseEntity<Producto>(encontrado, HttpStatus.OK);
    }

    @DeleteMapping("/{idproducto}")
    public  ResponseEntity<String> eliminarProducto(@PathVariable("idproducto") Long idproducto){
        serviceProduc.eliminar(idproducto);
        String texto = "El producto se ha Eliminado con exito";
        return new ResponseEntity<String>(texto, HttpStatus.OK);
    }
}
