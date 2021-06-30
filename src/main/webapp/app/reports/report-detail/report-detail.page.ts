import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ReportsService} from "../../shared/reports.service";
import {Report} from "../../shared/interfaces/report/report";

@Component({
  selector: 'app-report-detail',
  templateUrl: './report-detail.page.html',
  styleUrls: ['./report-detail.page.scss'],
})
export class ReportDetailPage implements OnInit {
   reportId: number;
   report: Report;

  constructor(public readonly activatedRoute: ActivatedRoute,
              public service: ReportsService
              ) { }

  ngOnInit() {
    this.reportId = this.activatedRoute.snapshot.params.id;
    this.service.getReportsDetails(this.reportId).subscribe(response =>
    this.report = response
    )

  }

}
