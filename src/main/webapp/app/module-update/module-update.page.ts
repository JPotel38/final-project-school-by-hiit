import {Component, OnDestroy, OnInit} from '@angular/core';
import {ModuleService} from "../shared/module-service/module.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AlertController} from "@ionic/angular";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Subscription} from "rxjs";
import {ModuleInterface} from "../shared/module-service/Module.interface";

@Component({
  selector: 'app-module-update',
  templateUrl: './module-update.page.html',
  styleUrls: ['./module-update.page.scss'],
})
export class ModuleUpdatePage implements OnInit, OnDestroy {

  public updateFormGroup: FormGroup;
  public moduleId: number;
  public updateModuleSubscription$: Subscription;
  public moduleInterface: ModuleInterface;

  constructor(public readonly moduleService: ModuleService,
              public readonly activatedRoute: ActivatedRoute,
              public readonly alertCtrl: AlertController,
              public readonly router: Router) { }

  ngOnInit() {
    this.moduleId = this.activatedRoute.snapshot.params.id;
    this.moduleService.getModuleDetail(this.moduleId).subscribe(
      value => {
        this.moduleInterface= value

      });


    this.updateFormGroup = new FormGroup({
      designation: new FormControl('', Validators.required)
    });

  }

  updateModule(){
    let module: ModuleInterface = this.updateFormGroup.value;
    this.updateModuleSubscription$ = this.moduleService.updateModule(this.moduleId,module.designation)
      .subscribe(
        async value => {
          if (value.status === 200) {
            const alert = await this.alertCtrl.create({
              header: 'Success',
              message: `Le Module ${this.moduleId} a été modifié avec succès`,
              buttons: ['OK'],
              backdropDismiss: true

            });
            await alert.present();
          }
        }
      );
    this.goToModuleList().then();
  }


  async goToModuleList() {
    await this.router.navigate(['module-list']);
  }

  ngOnDestroy(){
  }

}
