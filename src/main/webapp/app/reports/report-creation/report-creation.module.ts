import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ReportCreationPageRoutingModule } from './report-creation-routing.module';

import { ReportCreationPage } from './report-creation.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ReportCreationPageRoutingModule
  ],
  declarations: [ReportCreationPage]
})
export class ReportCreationPageModule {}
