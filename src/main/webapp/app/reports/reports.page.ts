import {Component, OnInit} from '@angular/core';
import {ReportsService} from "../shared/reports.service";
import {Report} from "../shared/interfaces/report/report";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-reports',
  templateUrl: './reports.page.html',
  styleUrls: ['./reports.page.scss'],
})
export class ReportsPage implements OnInit {
  reports: Array<Report> = [];

  constructor(public reportsService: ReportsService,
              public readonly router: Router,
              public route: ActivatedRoute
              ) {
  }

  ngOnInit() {
    this.reportsService.getReports().subscribe(report =>
      this.reports = report
    )
  }

  async details(id: number) {
    await this.router.navigate(['./report-detail', id],  {relativeTo: this.route})
  }

  async goToReportCreation() {
    await this.router.navigate(['./report-creation'],  {relativeTo: this.route})

  }
}
