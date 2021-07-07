import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ProjectUpdatePageRoutingModule } from './project-update-routing.module';

import { ProjectUpdatePage } from './project-update.page';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        IonicModule,
        ProjectUpdatePageRoutingModule,
        ReactiveFormsModule
    ],
  declarations: [ProjectUpdatePage]
})
export class ProjectUpdatePageModule {}
