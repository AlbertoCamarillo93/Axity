import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { MatTableDataSource } from '@angular/material/table';
import { Car } from '../model/car.model';
import { DataService } from '../services/data.service';
import { CarService } from '../services/car.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  dataSource = new MatTableDataSource<Car>();
  columns = ['brand', 'modelo', 'year', 'actions', 'erase'];

  constructor(
              private dataService: DataService,
              private car: CarService,
              private router: Router          
              ) {
                this.dataService.isLoading.next(true);
                this.car.getCar().subscribe(cars => {
                  this.dataSource.data = cars;
                  this.dataService.isLoading.next(false);
                }, () => {
                  this.dataService.isLoading.next(false);
                  this.dataService.message.next('Lo sentimos, no se pudieron cargar los elementos');
                  //alert('Lo sentimos, no se pudieron cargar los elementos');
                });
               }

  ngOnInit(): void {
  }

  edit(item:Car): void {
    console.log(item);
    this.router.navigate(['car', item._id]);
    
  }

  newItem(): void{
    this.router.navigate(['car']);
  }

  erase(item:Car): void {
    console.log(item);
    this.dataService.isLoading.next(true);
    this.router.navigate(['home', item._id, "erase"]);
     
  }

}
