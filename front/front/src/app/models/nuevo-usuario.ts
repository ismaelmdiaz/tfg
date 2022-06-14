export class NuevoUsuario {
    id?: number;
    nombre: string;
    nombreUsuario: string;
    email: string;
    roles: string[];
    cesta: string[];
    password: string;

    constructor(nombre: string, nombreUsuario: string, email: string, password: string) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.roles = ['user'];
        this.cesta = [];
    }
}