import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {User} from "../interfaces/user/user";

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(public http: HttpClient) {
  }

  getAllUsers(): Observable<Array<User>> {
    return this.http.get<Array<User>>('/api/users')
  }

}
