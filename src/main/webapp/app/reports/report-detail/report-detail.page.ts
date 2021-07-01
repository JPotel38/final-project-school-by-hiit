import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ReportsService} from "../../shared/services/reports.service";
import {Report} from "../../shared/interfaces/report/report";
import {Observable} from "rxjs";
import {tap} from "rxjs/operators";

@Component({
  selector: 'app-report-detail',
  templateUrl: './report-detail.page.html',
  styleUrls: ['./report-detail.page.scss'],
})
export class ReportDetailPage implements OnInit {
   reportId: number;
   report$: Observable<Report>;

  constructor(public readonly activatedRoute: ActivatedRoute,
              public service: ReportsService
              ) { }

  ngOnInit() {
    this.reportId = this.activatedRoute.snapshot.params.id;
    this.report$ = this.service.getReportsDetails(this.reportId);

  }

}
