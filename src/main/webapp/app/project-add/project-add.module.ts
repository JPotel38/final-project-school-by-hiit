import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ProjectAddPageRoutingModule } from './project-add-routing.module';

import { ProjectAddPage } from './project-add.page';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        IonicModule,
        ProjectAddPageRoutingModule,
        ReactiveFormsModule
    ],
  declarations: [ProjectAddPage]
})
export class ProjectAddPageModule {}
