import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ReportCreationPage } from './report-creation.page';

const routes: Routes = [
  {
    path: '',
    component: ReportCreationPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ReportCreationPageRoutingModule {}
