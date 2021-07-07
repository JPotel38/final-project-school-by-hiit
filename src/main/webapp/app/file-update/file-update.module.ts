import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { FileUpdatePageRoutingModule } from './file-update-routing.module';

import { FileUpdatePage } from './file-update.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    FileUpdatePageRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [FileUpdatePage]
})
export class FileUpdatePageModule {}
