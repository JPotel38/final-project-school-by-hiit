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
}
