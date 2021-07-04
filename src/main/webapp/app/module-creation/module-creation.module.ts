import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ModuleCreationPageRoutingModule } from './module-creation-routing.module';

import { ModuleCreationPage } from './module-creation.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ModuleCreationPageRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [ModuleCreationPage]
})
export class ModuleCreationPageModule {}
