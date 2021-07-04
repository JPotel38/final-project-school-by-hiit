import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ModuleCreationPage } from './module-creation.page';

const routes: Routes = [
  {
    path: '',
    component: ModuleCreationPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ModuleCreationPageRoutingModule {}
