import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";
import {AlertController} from "@ionic/angular";
import {HttpResponse} from "@angular/common/http";
import {ModuleService} from "../shared/module-service/module.service";

@Component({
  selector: 'app-module-creation',
  templateUrl: './module-creation.page.html',
  styleUrls: ['./module-creation.page.scss'],
})
export class ModuleCreationPage implements OnInit, OnDestroy {

  public createFormGroup: FormGroup;
  public createModuleSubscription$: Subscription;

  constructor(public readonly moduleService: ModuleService,
              public readonly router: Router,
              public readonly alertCtrl: AlertController){}

  ngOnInit() {
    this.createFormGroup = new FormGroup({
      designation: new FormControl('',[Validators.required])
    });
  }

  createModule(){
    const createFormValue = this.createFormGroup.value as CreateFormValue;

    this.createModuleSubscription$ = this.moduleService.createModule(createFormValue.designation)
      .subscribe(async (response: HttpResponse<any>) =>{
        if (response.status === 201 && response.statusText === 'OK'){
          const alert = await this.alertCtrl.create({
            header: 'Success',
            message: `Le Module ${response.body.id}a été créé avec succès`,
            buttons: ['OK'],
            backdropDismiss: true
          });
          await alert.present();
        }
      }
    )
  }

  ngOnDestroy(){
    this.createModuleSubscription$?.unsubscribe();
  }
}

  interface CreateFormValue {designation: string}
