import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginRequest, LoginResponse} from '../model/login.model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  login(data: LoginRequest): Observable < LoginResponse > {
    return this.http.post<LoginResponse>('https://reqres.in/api/login', data);//Para provocare un delay 'https://reqres.in/api/login?delay=5'
  }
}


