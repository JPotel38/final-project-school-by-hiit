import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { FileUpdatePage } from './file-update.page';

const routes: Routes = [
  {
    path: '',
    component: FileUpdatePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class FileUpdatePageRoutingModule {}
