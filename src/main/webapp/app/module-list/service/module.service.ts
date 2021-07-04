import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ModuleInterface} from "./Module.interface";

@Injectable({
  providedIn: 'root'
})
export class ModuleService {

  constructor(public readonly httpClient: HttpClient) { }

  getModuleList(): Observable<ModuleInterface[]>{
    return this.httpClient.get<ModuleInterface[]>(`/api/modules/`);
  }

  getModuleDetail(moduleId: number): Observable<ModuleInterface>{
    return this.httpClient.get<ModuleInterface>(`/api/modules/${moduleId}`);
  }

  createModule(designation: string){
    return this.httpClient.post(`/api/modules/`,
      {
      designation: designation
    },
      {observe: "response"});
  }

  updateModule(moduleId: number, designation: string){
    return this.httpClient.put(`/api/modules/${moduleId}`,
      {
        designation: designation
      },
      {observe: "response"});
  }

  deleteModule(moduleId: number): Observable<any>{
    return this.httpClient.delete(`/api/modules/${moduleId}`,{observe: "response"});
  }
}
