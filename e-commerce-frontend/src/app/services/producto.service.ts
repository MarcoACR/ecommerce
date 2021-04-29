import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {Producto} from '../models/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private getUrl = 'http://localhost:2525/inicio/';

  constructor(private httpCliente: HttpClient) {}

  public buscarProductos(): Observable<Producto[]>{
    return this.httpCliente.get<Producto[]>(this.getUrl).pipe(
      map(response => response)
    );
  }

  public guardar(producto: Producto): Observable<Producto>{
    return this.httpCliente.post<Producto>(this.getUrl, producto);
  }

  public buscarPorId(idProducto: number): Observable<Producto>{
    return this.httpCliente.get<Producto>(`${this.getUrl}/${idProducto}`).pipe(
    map(response => response)
    );
  }

  public eliminarPorId(idProducto: number): Observable<any>{
    return this.httpCliente.delete<Producto>(`${this.getUrl}/${idProducto}`, {responseType: 'json'});
  }
}
