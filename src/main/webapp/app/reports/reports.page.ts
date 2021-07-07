import {Component, OnInit} from '@angular/core';
import {ReportsService} from "../shared/service/reports.service";
import {Report} from "../shared/interface/report";
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from "rxjs";
import {Location} from "@angular/common";
import {LoginService} from "../login/service/login.service";

@Component({
  selector: 'app-reports',
  templateUrl: './reports.page.html',
  styleUrls: ['./reports.page.scss']
})
export class ReportsPage implements OnInit {
  reports$: Observable<Array<Report>>;

  isAdminOrTeacher :boolean;

  constructor(public reportsService: ReportsService,
              public readonly router: Router,
              public route: ActivatedRoute,
              private _location: Location,
              public readonly loginService: LoginService
  ) {
  }

  ngOnInit() {
    this.reports$ = this.reportsService.getReports();
    this.isAdminOrTeacher= (this.loginService.isTeacher() || this.loginService.isAdmin());
  }

  async goToReportCreation() {
    await this.router.navigate(['./report-creation'], {relativeTo: this.route})
  }

  async goToReportDetails(id: number) {
    await this.router.navigate(['./report-detail', id], {relativeTo: this.route})
  }

  goBack() {
    this._location.back();
  }
}
