import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(
    public readonly httpClient: HttpClient
  ) { }

  isConnected(email: string, password: string): Observable<any> {
    return of({token: "TokenALaCon"})
//     this.httpClient.post('/api/login', {
//     email: email,
//     password: password
//  })

 // )
     console.log('from front',email, password);
  }

}

