import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UsersService} from "../../shared/services/users.service";
import {User} from "../../shared/interfaces/user/user";
import {Observable} from "rxjs";
import {ReportsService} from "../../shared/services/reports.service";
import {Report} from "../../shared/interfaces/report/report";

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
    public userService: UsersService,
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
    this.users$ = this.userService.getAllUsers();
  }

  validateReport() {
    const formValue = this.reportForm.value;
    const newReport: Report = {
      teacher: formValue.teacherId,
      tutor: formValue.tutorId,
      student: formValue.studentId,
      appointmentDate: formValue.appointmentDate,
      reportText: formValue.reportText
    }
    this.reportsService.createReport(newReport);
  }
}
