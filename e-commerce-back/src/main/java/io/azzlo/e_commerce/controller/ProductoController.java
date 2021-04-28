package io.azzlo.e_commerce.controller;

import io.azzlo.e_commerce.model.Producto;
import io.azzlo.e_commerce.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
