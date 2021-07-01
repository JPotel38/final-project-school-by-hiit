import {Component, OnInit} from '@angular/core';
import {ReportsService} from "../shared/services/reports.service";
import {Report} from "../shared/interfaces/report/report";
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from "rxjs";

@Component({
  selector: 'app-reports',
  templateUrl: './reports.page.html',
  styleUrls: ['./reports.page.scss']
})
export class ReportsPage implements OnInit {
  reports$: Observable<Array<Report>>;

  constructor(public reportsService: ReportsService,
              public readonly router: Router,
              public route: ActivatedRoute
              ) {
  }

  ngOnInit() {
    this.reports$ = this.reportsService.getReports();
  }

  async goToReportDetails(id: number) {
    await this.router.navigate(['./report-detail', id],  {relativeTo: this.route})
  }

  async goToReportCreation() {
    await this.router.navigate(['./report-creation'],  {relativeTo: this.route})
  }
}
