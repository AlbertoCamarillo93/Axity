import { compileNgModuleDeclarationExpression } from '@angular/compiler/src/render3/r3_module_compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Car } from '../model/car.model';
import { CarService } from '../services/car.service';
import { DataService } from '../services/data.service';

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit {
  formCar: FormGroup = this.formBuilder.group({});
  disableButton = false;
  id: string = '';
  title = 'Crear Elemento';
  

  constructor(
              private formBuilder: FormBuilder,
              private dataService: DataService,
              private router: Router,
              private car: CarService,
              private activateRoute: ActivatedRoute
              ){ 
                
                this.formCar = this.formBuilder.group({
                  brand:['', Validators.required],
                  modelo:['', Validators.required],
                  year:['', Validators.required],
                });

                this.dataService.isLoading.subscribe(isLoading => {
                  this.disableButton = isLoading;
                });

                this.activateRoute.params.subscribe(parameters => {
                  if (parameters.id) {
                    this.id = parameters.id;
                    this.title = 'Actualizar elemento';

                    this.dataService.isLoading.next(true);                                         
                    this.car.getSingleCar(parameters.id).subscribe(item => {
<<<<<<< HEAD
                      //this.formCar.patchValue(item);
                      this.formCar.get('brand')?.setValue(item.brand);
                      this.formCar.get('modelo')?.setValue(item.modelo);
                      this.formCar.get('year')?.setValue(item.year);
                      this.dataService.isLoading.next(false);
                    });                 
=======
                      this.formCar.patchValue(item);
                      /*this.formCar.get('brand')?.setValue(item.brand);
                      this.formCar.get('modelo')?.setValue(item.modelo);
                      this.formCar.get('year')?.setValue(item.year);*/
                    });
                  this.dataService.isLoading.next(false);
>>>>>>> 880e34da7378c9f5053a76f511938648133b7d4f
                }
                });
              }

  ngOnInit(): void {
  }

  save(): void {
    const data = {
      brand: this.formCar.get('brand')?.value,
      modelo: this.formCar.get('modelo')?.value,
      year: this.formCar.get('year')?.value
  } as Car;

  if (this.id !== '') {
    data._id = this.id;
  }

  console.log(data);

  this.dataService.isLoading.next(true);

    this.car.saveCar(data, this.id).subscribe(() => {
      this.dataService.isLoading.next(false);
      this.router.navigate(['home']);
    }, () => {
      this.dataService.isLoading.next(false);
      this.dataService.message.next('Lo sentimos, ocurrió un error')
      //alert('Lo sentimos, ocurrió un error.');
    });

  }
}
