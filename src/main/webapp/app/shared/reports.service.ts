import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Report} from "./interfaces/report/report";

@Injectable({
  providedIn: 'root'
})
export class ReportsService {

  constructor(public http: HttpClient) { }

  getReportsFromBack(): Observable<Array<Report>>{
   return this.http.get<Array<Report>>('/api/report');
  }
}
