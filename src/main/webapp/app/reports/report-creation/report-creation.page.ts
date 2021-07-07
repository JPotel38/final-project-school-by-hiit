import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Observable} from "rxjs";
import {ReportsService} from "../../shared/service/reports.service";
import {Report} from "../../shared/interface/report";
import {UserService} from "../../shared/service/user.service";
import {User} from "../../shared/interface/User.interface";

@Component({
  selector: 'app-report-creation',
  templateUrl: './report-creation.page.html',
  styleUrls: ['./report-creation.page.scss'],
})
export class ReportCreationPage implements OnInit {
  reportForm: FormGroup;
  users$: Observable<Array<User>>;
  teacher: User;
  tutor: User;
  student: User;

  constructor(
    fb: FormBuilder,
    public userService: UserService,
    public reportsService: ReportsService
  ) {
    this.reportForm = fb.group({
      reportText: [null, Validators.required],
      appointmentDate: [null, Validators.required],
      teacherId: [null, Validators.required],
      tutorId: [null, Validators.required],
      studentId: [null, Validators.required]
    });
  }

  ngOnInit() {
    this.users$ = this.userService.getUserList();
  }

  validateReport() {
    const formValue = this.reportForm.value;
    const newReport: Report = {
      teacherId: formValue.teacherId,
      tutorId: formValue.tutorId,
      studentId: formValue.studentId,
      appointmentDate: formValue.appointmentDate,
      reportText: formValue.reportText,
      validated: 'Not validated'
    }
    this.reportsService.createReport(newReport);
  }
}
