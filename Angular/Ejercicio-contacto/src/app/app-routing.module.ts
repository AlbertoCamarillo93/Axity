import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ContactoComponent } from '/home/axity/Documentos/CAP_Angular/AlbertoCamarillo/curso-angular/src/app/contacto/contacto.component';
import { HomeComponent } from './home/home.component';
import { CarComponent } from './car/car.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'contacto',
    component: ContactoComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'car',
    component: CarComponent
  },
  {
    path: 'car/:id',
    component: CarComponent
  },
  {
    path: '**',
    redirectTo: 'login'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
