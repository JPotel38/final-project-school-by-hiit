import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { FileListPageRoutingModule } from './file-list-routing.module';

import { FileListPage } from './file-list.page';
import {ListComponent} from "./list/list.component";
import {CourseListPageRoutingModule} from "../course-list/course-list-routing.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    FileListPageRoutingModule
  ],
  declarations: [FileListPage,ListComponent]
})
export class FileListPageModule {}
