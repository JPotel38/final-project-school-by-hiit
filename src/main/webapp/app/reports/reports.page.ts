import {Component, OnInit} from '@angular/core';
import {ReportsService} from "../shared/services/reports.service";
import {Report} from "../shared/interfaces/report/Report";
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from "rxjs";
import {Location} from "@angular/common";
import {UserService} from "../shared/services/user.service";
import {User} from "../shared/interfaces/user/User.interface";

@Component({
  selector: 'app-reports',
  templateUrl: './reports.page.html',
  styleUrls: ['./reports.page.scss']
})
export class ReportsPage implements OnInit {
   reports$: Observable<Array<Report>>;

  constructor(public reportsService: ReportsService,
              public readonly router: Router,
              public route: ActivatedRoute,
              private _location: Location
  ) {
  }

  ngOnInit() {
    this.reports$ = this.reportsService.getReports();
  }

  async goToReportCreation() {
    await this.router.navigate(['./report-creation'], {relativeTo: this.route})
  }

  goBack() {
    this._location.back();
  }

  async goToReportDetails(id: number) {
    await this.router.navigate(['./report-detail', id], {relativeTo: this.route})

  }
}
