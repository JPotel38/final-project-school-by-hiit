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
    return this.httpClient.post<any>('http://localhost:8081/login', {
      username: email,
      password: password
      }).pipe(
      tap(response => {
                  console.log(response);
         }))
  }
}
