import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ContactoComponent } from './contacto/contacto.component';
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
<<<<<<< HEAD
=======
  /*{
    path: 'car/:id/:erase',
    component: CarComponent
  },*/
>>>>>>> 880e34da7378c9f5053a76f511938648133b7d4f
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
