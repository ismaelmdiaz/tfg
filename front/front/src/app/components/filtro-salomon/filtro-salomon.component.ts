import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NuevoUsuario } from 'src/app/models/nuevo-usuario';
import { Producto } from 'src/app/models/producto';
import { AuthService } from 'src/app/service/auth.service';
import { ProductoService } from 'src/app/service/producto.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-filtro-salomon',
  templateUrl: './filtro-salomon.component.html',
  styleUrls: ['./filtro-salomon.component.css']
})
export class FiltroSalomonComponent implements OnInit {

  isLogged = false;
  usuarioMostrado: string="";
  cestaUsuario:any=[];

  usuarioLogueado: NuevoUsuario;
  producto: Producto;

  errorMessage: string;

  listadoProductos: Producto[] = [];

  constructor(
    private productService: ProductoService,
    private tokenService: TokenService,
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit() {

    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
    // this.listarProductos();
    this.onObtenerUsuario();
    this.filtradoPorMarca('Salomon');
  }

  listarProductos(){

    this.productService.lista().subscribe(

      data => {

        this.listadoProductos = data;
      }
    );
  }

  onObtenerUsuario(){

    this.usuarioMostrado=this.tokenService.getUserName();
    this.authService.obtencionUsuario(this.usuarioMostrado).subscribe(

      data => {

        this.usuarioLogueado = data;

        this.cestaUsuario = this.usuarioLogueado.cesta;

        console.log(this.usuarioLogueado);
        console.log(this.cestaUsuario);
      }
    );
  }

  obtencionProducto(indice:number){

    this.productService.detalle(indice).subscribe(

      data => {
        console.log(data)
      }
    )
  }

  onObtenerProducto(indice:number){

    this.productService.detalle(indice).subscribe(

      data => {

        this.producto = data;
        console.log(this.producto);

        this.anyadirElementoCarrito(this.producto);

        this.actualizacionUsuarioLogueado();
      }
    )
  }

  anyadirElementoCarrito(producto: Producto){

    this.cestaUsuario.push(producto);

    this.usuarioLogueado.cesta = this.cestaUsuario;
  }

  actualizacionUsuarioLogueado(){

    this.authService.update(this.usuarioLogueado.id, this.usuarioLogueado).subscribe(

      data => {
        console.log(data);
      }
    )
  }

  filtradoPorMarca(marca:string){

    this.productService.obtenerPorMarca(marca).subscribe(

      data => {
        this.listadoProductos = data;
      }
    )
  }

}
