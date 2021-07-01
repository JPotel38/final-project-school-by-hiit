import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ReportCreationPageRoutingModule } from './report-creation-routing.module';

import { ReportCreationPage } from './report-creation.page';
import {TutorPipe} from "../../shared/pipes/tutor.pipe";
import {TeacherPipe} from "../../shared/pipes/teacher.pipe";
import {StudentPipe} from "../../shared/pipes/student.pipe";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ReportCreationPageRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [ReportCreationPage, TutorPipe, TeacherPipe, StudentPipe]
})
export class ReportCreationPageModule {}
