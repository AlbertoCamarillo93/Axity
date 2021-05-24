import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Car } from '../model/car.model';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private hhtp: HttpClient) { }

  getCar(): Observable<[Car]>{
    return this.hhtp.get<[Car]>('https://super-rest.herokuapp.com/test/cars');
  }

  getSingleCar(id: string): Observable<Car>{
    return this.hhtp.get<Car>('https://super-rest.herokuapp.com/test/cars/' + id);
  }

  saveCar(item: Car, id?: string): Observable<any> {
    //update
    if (id !== '') {
      return this.hhtp.put('https://super-rest.herokuapp.com/test/cars/' + id, item);
    }
    
    return this.hhtp.post('https://super-rest.herokuapp.com/test/cars', item);
    
  }

  deleteCar(id: string): Observable<any> {
  return this.hhtp.delete('https://super-rest.herokuapp.com/test/cars/' + id);
    }
}

