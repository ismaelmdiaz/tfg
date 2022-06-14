import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NuevoUsuario } from '../models/nuevo-usuario';
import { Observable } from 'rxjs';
import { LoginUsuario } from '../models/login-usuario';
import { JwtDto } from '../models/jwt-dto';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  authURL = 'http://localhost:8080/auth/';

  constructor(private http: HttpClient) { }

  public login(loginUsuario: LoginUsuario): Observable<JwtDto> {
    return this.http.post<JwtDto>(this.authURL + 'login', loginUsuario);
  }

  public registration(nuevoUsuario: NuevoUsuario): Observable<any> {
    return this.http.post<any>(this.authURL + 'nuevo', nuevoUsuario);
  }

  public obtencionUsuario(nombreUsuario: string): Observable<NuevoUsuario> {
    return this.http.post<NuevoUsuario>(this.authURL + 'obtencionusuario', nombreUsuario);
  }

  public update(id: number, nuevoUsuario: NuevoUsuario): Observable<any> {
    return this.http.put<any>(this.authURL + `update/${id}`, nuevoUsuario);
  }
}
