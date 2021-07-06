import {Injectable} from '@angular/core';
import {ActivatedRoute, ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Observable} from 'rxjs';
import {Report} from "../interfaces/report/Report";
import {ReportsService} from "../services/reports.service";

@Injectable({
  providedIn: 'root'
})
export class ReportsResolver implements Resolve<Report> {
  constructor(private reportsService: ReportsService) {
  }

  resolve(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<Report> | Promise<Report> | Report {
    return this.reportsService.getReportsDetails(+route.paramMap.get('id'));
  }
}
