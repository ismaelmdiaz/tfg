import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NuevoUsuario } from 'src/app/models/nuevo-usuario';
import { AuthService } from 'src/app/service/auth.service';
import { ProductoService } from 'src/app/service/producto.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.css']
})
export class CarritoComponent implements OnInit {

  isLogged = false;
  usuarioMostrado: string="";
  cestaUsuario:any=[];

  usuarioLogueado: NuevoUsuario;

  errorMessage: string;

  constructor(
    private tokenService: TokenService,
    private authService: AuthService,
    private productService: ProductoService
  ) { }

  ngOnInit() {
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
    this.onObtenerUsuario();
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

  eliminarElementoCarrito(indiceElemento:number){

    this.cestaUsuario.splice(indiceElemento, 1);

    this.usuarioLogueado.cesta = this.cestaUsuario;

    console.log('la cesta queda así tras este borrado', this.usuarioLogueado.cesta);

    this.actualizacionUsuarioLogueado();
  }

  actualizacionUsuarioLogueado(){

    console.log('el usuario queda así', this.usuarioLogueado);

    this.authService.update(this.usuarioLogueado.id, this.usuarioLogueado).subscribe(

      data => {
        console.log(data);
      }
    )
  }

  obtencionProducto(indice:number){

    this.productService.detalle(indice).subscribe(

      data => {
        console.log(data)
      }
    )
  }
}
