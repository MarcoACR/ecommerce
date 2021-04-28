import { Component, OnInit } from '@angular/core';
import {ProductoService} from '../../services/producto.service';
import {Producto} from '../../models/producto';


@Component({
  selector: 'app-lista-productos',
  templateUrl: './lista-productos.component.html',
  styleUrls: ['./lista-productos.component.css']
})
export class ListaProductosComponent implements OnInit {

  productos: Producto[] = [];

  constructor(private productoService: ProductoService) { }

  ngOnInit(): void{

    this.productoService.buscarProductos().subscribe(
      data => this.productos = data
    );
  }
}
