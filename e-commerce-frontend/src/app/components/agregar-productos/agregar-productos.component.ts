import { Component, OnInit } from '@angular/core';
import {Producto} from '../../models/producto';
import {ProductoService} from '../../services/producto.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-agregar-productos',
  templateUrl: './agregar-productos.component.html',
  styleUrls: ['./agregar-productos.component.css']
})
export class AgregarProductosComponent implements OnInit {

  guardaProducto: Producto = new Producto();

  constructor(private  productoService: ProductoService,
              private routero: Router,
              private activarroutero: ActivatedRoute) { }

  ngOnInit(): void {
    const idPresente = this.activarroutero.snapshot.paramMap.has('idproducto');
    if (idPresente){
      let encontrado: any;
      encontrado = this.activarroutero.snapshot.paramMap.get('idproducto');
      this.productoService.buscarPorId(encontrado).subscribe(
        data => this.guardaProducto = data
      );
    }
  }

  guardarProductos(): void{
    this.productoService.guardar(this.guardaProducto).subscribe(
      data => {
        console.log('respuesta', data);
        this.routero.navigateByUrl('/productos');
      }
    );
  }

  eliminarProducto(idproducto: number): void {
    this.productoService.eliminarPorId(idproducto).subscribe(
      data => {
        console.log('Eliminado!', data);
        this.routero.navigateByUrl('/productos');
      }
    );
  }
}
