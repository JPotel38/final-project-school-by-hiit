import { Component, OnInit, OnDestroy } from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {ModuleInterface} from "./service/Module.interface";
import {ModuleService} from "./service/module.service";
import {Router} from "@angular/router";
import {AlertController} from "@ionic/angular";
import {async} from "@angular/core/testing";
import {HttpResponse} from "@angular/common/http";

@Component({
  selector: 'app-module-list',
  templateUrl: './module-list.page.html',
  styleUrls: ['./module-list.page.scss'],
})
export class ModuleListPage implements OnInit, OnDestroy {

  public moduleList$ : Observable<ModuleInterface[]>;
  public deleteModuleSubscription$: Subscription;

  constructor(public moduleService:ModuleService,
              public readonly router: Router,
              public readonly alertCtrl : AlertController) { }

  ngOnInit() {
    this.getModuleList();
  }

  getModuleList(){
    this.moduleList$ = this.moduleService.getModuleList();
  }

  deleteModule(moduleId: number){
    this.deleteModuleSubscription$ = this.moduleService.deleteModule(moduleId).subscribe(
      async(response: HttpResponse<any>)=>{
        if(response.status === 204 && response.statusText === 'OK'){
          const alert = await this.alertCtrl.create({
            header: 'Alert',
            message: `Le module ${moduleId} a bien été supprimé`,
            buttons: [`OK`],
            backdropDismiss: true
          });
          await alert.present();
        }
      }
    )
  }

  ngOnDestroy() {
    this.deleteModuleSubscription$?.unsubscribe();
  }


}
