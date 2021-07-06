import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Role} from "../interface/User.interface";

@Injectable({
  providedIn: 'root'
})
export class RoleService {

  constructor(public readonly httpClient: HttpClient) { }

  getRoles(): Observable<Role[]>{
    return this.httpClient.get<Role[]>('/api/roles')
  }
}
