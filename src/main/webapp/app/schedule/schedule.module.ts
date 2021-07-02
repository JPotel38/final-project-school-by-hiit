import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { SchedulePageRoutingModule } from './schedule-routing.module';

import { SchedulePage } from './schedule.page';
import {FullCalendarModule} from "@fullcalendar/angular";
import {PopoverComponent} from "./popover/popover.component";
import {CreatePopoverComponent} from "./create-popover/create-popover.component";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    SchedulePageRoutingModule,
    FullCalendarModule
  ],
  declarations: [SchedulePage, PopoverComponent, CreatePopoverComponent]
})
export class SchedulePageModule {}
