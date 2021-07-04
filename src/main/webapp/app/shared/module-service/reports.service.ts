import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Report} from "../interface/report";

@Injectable({
  providedIn: 'root'
})
export class ReportsService {

  constructor(public http: HttpClient) {
  }

  getReports(): Observable<Array<Report>> {
    return this.http.get<Array<Report>>('/api/report');
  }

  getReportsDetails(id: number): Observable<Report> {
    return this.http.get<Report>(`/api/report/${id}`)
  }

  createReport(report: Report): Observable<string> {
    return this.http.post('/api/report/post', report, {responseType: 'text'});
  }

  updateReport(id: number, report: Report): Observable<any> {
    return this.http.put(`/api/report/put/${id}`, report);
  }
}
