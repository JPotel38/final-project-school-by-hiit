import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../interface/User.interface";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(public readonly httpClient: HttpClient) { }

  getUserList(): Observable<User[]> {
    return this.httpClient.get<User[]>(`/api/users/`);
  }

  getUserDetail(userId: number): Observable<User>  {
    return this.httpClient.get<User>(`/api/users/${userId}`);
  }

  createUser(user: User): Observable<User> {
    return this.httpClient.post<User>('/api/users/', user)
  }

  updateUser(userId: number, user:User){
    return this.httpClient.put<User>(`/api/users/${userId}`, user);
  }

  deleteUser(userId: number){
    return this.httpClient.delete(`/api/users/${userId}`)
  }

}
