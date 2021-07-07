import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';
import * as jwt_decode from 'jwt-decode';
import jwtDecode from "jwt-decode";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(
    public readonly httpClient: HttpClient
  ) {
  }

  isConnected(mail: string, password: string): Observable<boolean> {
    return this.httpClient.post<any>('/api/login', {
        username: mail,
        password: password
      }, {observe: 'response'}
    ).pipe(
      tap((resp) => localStorage.setItem('token', resp.headers.get('Authorization'))),
      map((resp) => {
        let existToken: boolean;
        if (resp && resp.headers.get('Authorization')) {
          existToken = true;
        } else {
          existToken = false
        }
        return existToken;

      }),
      catchError(() => of(false))
    );
  }

  isLogged() {
    return !!localStorage.getItem('token')
  }

  getAuthorizationToken() {
    return localStorage.getItem('token')
  }

  isAdmin(){
    let decoded = jwtDecode(localStorage.getItem('token'));
    let authoritiesObj = decoded['authorities'];
    let authorityList = [];
    authoritiesObj.forEach(
      authority => authorityList.push(authority.authority)
    )
    return authorityList.includes("ROLE_ADMIN")
  }

}
