import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Project} from "../interface/project";

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(public readonly http:HttpClient) { }
  getAllProject():Observable<Project[]>{
    return this.http.get<Project[]>("/api/project");
  }
  getProject(id:number):Observable<Project>{
    return this.http.get<Project>(`/api/project/${id}`);
  }
  delete(id:number){
    return this.http.delete(`/api/project/${id}`,{observe:"response"})
  }
  update(id:number,project:Project){
    return this.http.put(`/api/project/${id}`,project,{observe:"response"})
  }

  create(project: Project){
    console.log(project)
    return this.http.post('/api/project/create',project,{observe:"response"})
  }
}
