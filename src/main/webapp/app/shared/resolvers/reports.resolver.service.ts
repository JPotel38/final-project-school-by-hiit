import {Injectable} from '@angular/core';
import {ActivatedRoute, ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Observable} from 'rxjs';
import {Report} from "../interface/report";
import {ReportsService} from "../service/reports.service";

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
