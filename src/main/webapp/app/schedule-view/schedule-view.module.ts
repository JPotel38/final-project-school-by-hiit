import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ScheduleViewPageRoutingModule } from './schedule-view-routing.module';

import { ScheduleViewPage } from './schedule-view.page';
import {FullCalendarModule} from "@fullcalendar/angular";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    FullCalendarModule,
    ScheduleViewPageRoutingModule
  ],
  declarations: [ScheduleViewPage]
})
export class ScheduleViewPageModule {}
