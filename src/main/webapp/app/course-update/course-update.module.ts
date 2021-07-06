import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { CourseUpdatePageRoutingModule } from './course-update-routing.module';

import { CourseUpdatePage } from './course-update.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    CourseUpdatePageRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [CourseUpdatePage]
})
export class CourseUpdatePageModule {}
