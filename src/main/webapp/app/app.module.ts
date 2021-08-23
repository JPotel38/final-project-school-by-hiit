import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouteReuseStrategy, RouterModule} from '@angular/router';

import {IonicModule, IonicRouteStrategy} from '@ionic/angular';

import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';

import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {MenuPageModule} from "./menu/menu.module";
import {TeacherPipe} from './shared/pipes/teacher.pipe';
import {TutorPipe} from './shared/pipes/tutor.pipe';
import {StudentPipe} from './shared/pipes/student.pipe';
import {DatePipe} from "@angular/common";
import {LoginInterceptor} from "./shared/interceptors/login.interceptor";
import {FullCalendarModule} from "@fullcalendar/angular";

@NgModule({
  declarations: [AppComponent],
  entryComponents: [],
  imports: [BrowserModule, IonicModule.forRoot(), AppRoutingModule, RouterModule, MenuPageModule, HttpClientModule,
    FullCalendarModule,
    MenuPageModule
  ],
  providers: [
    TutorPipe, StudentPipe, TeacherPipe, {provide: RouteReuseStrategy, useClass: IonicRouteStrategy},
    { provide: HTTP_INTERCEPTORS, useClass: LoginInterceptor, multi: true },
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
