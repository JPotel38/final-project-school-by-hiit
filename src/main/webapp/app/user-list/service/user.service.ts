import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "./User.interface";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private RESOURCE_URL = 'http://localhost:8081'

  constructor(public readonly httpClient: HttpClient) { }

  getUserList(): Observable<User[]> {
    return this.httpClient.get<User[]>(`/api/users/`);//${this.RESOURCE_URL}
  }

}
