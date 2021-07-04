import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CourseListPage } from './course-list.page';
import {ListComponent} from "./list/list.component";

const routes: Routes = [
  {
    path: '',
    component: CourseListPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule, ListComponent],
  declarations: [
    ListComponent
  ]
})
export class CourseListPageRoutingModule {}
