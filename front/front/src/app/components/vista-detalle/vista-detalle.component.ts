import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NuevoUsuario } from 'src/app/models/nuevo-usuario';
import { Producto } from 'src/app/models/producto';
import { AuthService } from 'src/app/service/auth.service';
import { ProductoService } from 'src/app/service/producto.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-vista-detalle',
  templateUrl: './vista-detalle.component.html',
  styleUrls: ['./vista-detalle.component.css']
})
export class VistaDetalleComponent implements OnInit {

  isLogged = false;
  usuarioMostrado: string="";
  cestaUsuario:any[]=[];

  producto: Producto;

  errorMessage: string;

  listadoProductos: Producto[] = [];

  id:number;

  productTypeShoe=false;

  showSizesBox=false;

  usuarioLogueado: NuevoUsuario;

  items=[39, 40, 41, 42, 43, 44, 45];

  sizeSelectedClicked="Select size";

  showAlertToSelectSize=false;

  counterRegistered=0;

  registeredProductoNotToAdd=false;

  constructor(

    private productService: ProductoService,
    private tokenService: TokenService,
    private authService: AuthService,
    private router: Router,

    private productoService: ProductoService,
    private route: ActivatedRoute
    ) { 
      this.id=this.route.snapshot.params.id;
    }

  ngOnInit() {

    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
    this.onObtenerUsuario();

    this.obtencionProducto(this.id);
  }

  onObtenerUsuario(){

    this.usuarioMostrado=this.tokenService.getUserName();
    this.authService.obtencionUsuario(this.usuarioMostrado).subscribe(

      data => {

        this.usuarioLogueado = data;

        this.cestaUsuario = this.usuarioLogueado.cesta;
      }
    );
  }

  onObtenerProducto(indice:number){

    if(parseInt(this.sizeSelectedClicked)>=39 || 
       parseInt(this.sizeSelectedClicked)<=45){

      if(this.isLogged){

        this.cestaUsuario.forEach((element)=>{

          if(element.id==indice){
            
            this.counterRegistered++;
          }
        });

        if(this.counterRegistered>=1){

          this.registeredProductoNotToAdd=true;
          
        }else{

          this.productService.detalle(indice).subscribe(
  
            data => {
      
              this.producto = data;
      
              this.anyadirElementoCarrito(this.producto);
      
              this.actualizacionUsuarioLogueado();
    
              this.router.navigate(['/carrito']);
            }
          )
        }

      }else{
        
        this.router.navigate(['/login']);
      }
    }else{

      this.showAlertToSelectSize=true;
    }
  }

  anyadirElementoCarrito(producto: Producto){

    this.cestaUsuario.push(producto);

    this.usuarioLogueado.cesta = this.cestaUsuario;
  }

  actualizacionUsuarioLogueado(){

    this.authService.update(this.usuarioLogueado.id, this.usuarioLogueado).subscribe(

      data => {
      }
    )
  }

  obtencionProducto(id:number){

    this.productoService.detalle(id).subscribe(

      data => {
        this.producto=data;

        if(this.producto.typeproduct=='shoe'){
          this.productTypeShoe=true;
        }
      }
    )
  }

  showSizesTablesBox(){

    this.showSizesBox=!this.showSizesBox;
  }

  sizeSelected(sizeNum:number){

    if(this.showAlertToSelectSize){
      this.showAlertToSelectSize=false;
    }

    this.showSizesBox=!this.showSizesBox;
    this.sizeSelectedClicked=sizeNum.toString();
  }

}
