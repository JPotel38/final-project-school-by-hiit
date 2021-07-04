import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { FileCreationPage } from './file-creation.page';

const routes: Routes = [
  {
    path: '',
    component: FileCreationPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class FileCreationPageRoutingModule {}
