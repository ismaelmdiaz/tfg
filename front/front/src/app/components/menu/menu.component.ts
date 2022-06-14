import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  isLogged = false;

  showBrands=false;

  constructor(
    private tokenService: TokenService,
    private router: Router
  ) { }

  ngOnInit() {
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  onLogout(){

    this.tokenService.logOut();

    // window.location.reload();

    this.router.navigate(['/login']);
  }

  mostrar=false;

  ocultarMenu(){
    
    if(this.mostrar==false){
      this.mostrar=true;
    }else{
      this.mostrar=false;
    }
  }

  showBrandsBox(){
    this.showBrands=!this.showBrands;
  }

}
