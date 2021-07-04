import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ModuleDetailPageRoutingModule } from './module-detail-routing.module';

import { ModuleDetailPage } from './module-detail.page';
import {ListComponent} from "../course-list/list/list.component";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ModuleDetailPageRoutingModule
  ],
  declarations: [ModuleDetailPage,ListComponent]
})
export class ModuleDetailPageModule {}
