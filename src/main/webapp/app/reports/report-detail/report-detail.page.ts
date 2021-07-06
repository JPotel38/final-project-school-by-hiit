import {Component, OnInit} from '@angular/core';
import {Location} from '@angular/common';
import {ReportsService} from "../../shared/services/reports.service";
import {Report} from "../../shared/interfaces/report/Report";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from "rxjs";
import {User} from "../../shared/interfaces/user/User.interface";
import {UserService} from "../../shared/services/user.service";

@Component({
  selector: 'app-report-detail',
  templateUrl: './report-detail.page.html',
  styleUrls: ['./report-detail.page.scss'],
})
export class ReportDetailPage implements OnInit {
  report: Report;
  validatedForm: FormGroup;
  teacher$: Observable<User>;
  tutor$: Observable<User>;
  student$: Observable<User>;

  constructor(public reportsService: ReportsService,
              public usersService: UserService,
              private _location: Location,
              public readonly router: Router,
              private route: ActivatedRoute,
              fb: FormBuilder
  ) {
    this.validatedForm = fb.group({
      isValidated: [null, Validators.required],
    });
  }

  ngOnInit() {
    this.report = this.route.snapshot.data.report;
    this.teacher$ = this.usersService.getUserDetail(this.report.teacherId);
    this.tutor$ = this.usersService.getUserDetail(this.report.tutorId);
    this.student$ = this.usersService.getUserDetail(this.report.studentId);
  }

  async goBack() {
      await this.router.navigate(['./reports'])
    }

  isValidated(event) {
    if (event.detail.checked === true) {
      this.validatedForm.get('isValidated').setValue('Validated')
    } else {
      this.validatedForm.get('isValidated').setValue('Not validated')
    }
  }

  Validate() {
    const validatedReport: Report = {
      ...this.report,
      validated: this.validatedForm.value.isValidated
    }
    this.reportsService.updateReport(this.report.id, validatedReport);
  }
}
