import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NuevoUsuario } from 'src/app/models/nuevo-usuario';
import { Producto } from 'src/app/models/producto';
import { AuthService } from 'src/app/service/auth.service';
import { ProductoService } from 'src/app/service/producto.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  isLogged = false;
  usuarioMostrado: string="";
  cestaUsuario:any=[];

  usuarioLogueado: NuevoUsuario;
  producto: Producto;

  errorMessage: string;

  listadoProductos: Producto[] = [];

  homeProductsImages:any[]=[
    {
      focus:'https://cms-cdn.thesolesupplier.co.uk/2021/09/palace-x-salomon-xt-6.jpg', 
      linkTo:'/salomon'
    },
    {
      focus:'https://cdn.25gramos.com/wp-content/uploads/sites/7/2020/12/Palace_Arcteryx_Fleek_6.jpg', 
      linkTo:'/arcteryx'
    },
    {
      focus:'https://images.complex.com/complex/images/c_fill,dpr_auto,f_auto,q_90,w_1400/fl_lossy,pg_1/tvaibr2zvlyhso5oeo0w/organiclab-zip-release-details-03', 
      linkTo:'salomon'
    },
    {
      focus:'https://www.highsnobiety.com/static-assets/thumbor/1l6yOG9Oi1qhZWhY3juFEYrC460=/1600x1067/www.highsnobiety.com/static-assets/wp-content/uploads/2022/02/07101055/salomon-end_0000_G9347_launches_hero_landscape_1.jpg', 
      linkTo:'salomon'
    },
    
  ];

  constructor(
    private tokenService: TokenService
  ) { }

  ngOnInit(): void {

    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }
}
