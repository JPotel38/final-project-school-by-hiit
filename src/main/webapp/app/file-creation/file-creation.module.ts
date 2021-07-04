import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { FileCreationPageRoutingModule } from './file-creation-routing.module';

import { FileCreationPage } from './file-creation.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    FileCreationPageRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [FileCreationPage]
})
export class FileCreationPageModule {}
