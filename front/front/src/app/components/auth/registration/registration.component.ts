import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NuevoUsuario } from 'src/app/models/nuevo-usuario';
import { AuthService } from 'src/app/service/auth.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  nuevoUsuario: NuevoUsuario; 

  nombre: string;
  nombreUsuario: string;
  email: string;
  password: string;
  // cesta:string[]=[];

  errorMessage: string;

  isLogged = false;

  constructor(
    private tokenService: TokenService,
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
    
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    }
  }

  onRegister() {

    this.nuevoUsuario = new NuevoUsuario(this.nombre, this.nombreUsuario, this.email, this.password);
    this.authService.registration(this.nuevoUsuario).subscribe(

      data => {

        this.router.navigate(['/login']);//una vez efectuado el registro, se va al login
      },
      err => {

        this.errorMessage = err.error.mensaje;
      }
    );
  }

}
