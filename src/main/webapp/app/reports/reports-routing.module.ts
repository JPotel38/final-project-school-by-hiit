import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {ReportsPage} from './reports.page';
import {ReportsResolver} from "../shared/resolvers/reports.resolver.service";

const routes: Routes = [
  {
    path: 'report-detail/:id',
    loadChildren: () => import('./report-detail/report-detail.module').then(m => m.ReportDetailPageModule),
    resolve: {
      report: ReportsResolver
    }
  },
  {
    path: 'report-creation',
    loadChildren: () => import('./report-creation/report-creation.module').then(m => m.ReportCreationPageModule)
  },
  {
    path: '',
    component: ReportsPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ReportsPageRoutingModule {
}
