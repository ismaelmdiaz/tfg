import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from '../models/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  productosURL = 'http://localhost:8080/producto/';

  constructor(private http: HttpClient) { }

  public lista(): Observable<Producto[]> {
    return this.http.get<Producto[]>(this.productosURL + 'listaproductos');
  }

  public detalle(indice: number): Observable<Producto> {
    return this.http.get<Producto>(this.productosURL + `detalle/${indice}`);
  }

  public obtenerPorMarca(marca: string): Observable<Producto[]> {
    return this.http.get<Producto[]>(this.productosURL + `marca/${marca}`);
  }

}
