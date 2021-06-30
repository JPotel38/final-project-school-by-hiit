import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(
    public readonly httpClient: HttpClient
  ) { }

  isConnected(email: string, password: string) {
//     return this.httpClient.post('/api/login', {
//     email: email,
//     password: password
//  })
     console.log('from front',email, password)
  }

}

