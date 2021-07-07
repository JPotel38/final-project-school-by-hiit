import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ProjectAddPage } from './project-add.page';

const routes: Routes = [
  {
    path: '',
    component: ProjectAddPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProjectAddPageRoutingModule {}
