import { Component, OnInit } from '@angular/core';
import {ReportsService} from "../shared/reports.service";

@Component({
  selector: 'app-reports',
  templateUrl: './reports.page.html',
  styleUrls: ['./reports.page.scss'],
})
export class ReportsPage implements OnInit {

  constructor(public reportsService : ReportsService) { }

  ngOnInit() {
    this.reportsService.getReportsFromBack().subscribe(report =>
    console.log(report)
    )
  }

}
