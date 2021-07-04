import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { CourseListPageRoutingModule } from './course-list-routing.module';

import { CourseListPage } from './course-list.page';
import {ListComponent} from "./list/list.component";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    CourseListPageRoutingModule
  ],
  declarations: [CourseListPage,ListComponent]
})
export class CourseListPageModule {}
