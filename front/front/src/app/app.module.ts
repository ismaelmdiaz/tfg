import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/auth/login/login.component';

import { MenuComponent } from './components/menu/menu.component';
import { HomeComponent } from './components/home/home.component';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CarritoComponent } from './components/carrito/carrito.component';
import { FiltroMarcaComponent } from './components/filtro-marca/filtro-marca.component';
import { VistaDetalleComponent } from './components/vista-detalle/vista-detalle.component';
import { RegistrationComponent } from './components/auth/registration/registration.component';
import { FooterComponent } from './components/footer/footer.component';
import { FiltroSalomonComponent } from './components/filtro-salomon/filtro-salomon.component';
import { FiltroArcteryxComponent } from './components/filtro-arcteryx/filtro-arcteryx.component';


const rutas:Routes=[
  {path:'', component:HomeComponent},
  {path:'login', component:LoginComponent},
  {path:'registration', component:RegistrationComponent},
  {path:'carrito', component:CarritoComponent},
  {path:'brands', component:FiltroMarcaComponent},
  {path:'product/:id', component:VistaDetalleComponent},
  {path:'salomon', component:FiltroSalomonComponent},
  {path:'arcteryx', component:FiltroArcteryxComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    MenuComponent,
    HomeComponent,
    CarritoComponent,
    FiltroMarcaComponent,
    VistaDetalleComponent,
    FooterComponent,
    MenuComponent,
    FiltroSalomonComponent,
    FiltroArcteryxComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(rutas),
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
