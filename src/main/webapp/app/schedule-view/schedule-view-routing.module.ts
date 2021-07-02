import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ScheduleViewPage } from './schedule-view.page';

const routes: Routes = [
  {
    path: '',
    component: ScheduleViewPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ScheduleViewPageRoutingModule {}
