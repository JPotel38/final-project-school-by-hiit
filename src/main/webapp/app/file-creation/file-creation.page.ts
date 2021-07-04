import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Subscription} from "rxjs";
import {FileService} from "../shared/file-service/file.service";
import {Router} from "@angular/router";
import {AlertController, IonDatetime} from "@ionic/angular";
import {Time} from "@angular/common";
import {HttpResponse} from "@angular/common/http";

@Component({
  selector: 'app-file-creation',
  templateUrl: './file-creation.page.html',
  styleUrls: ['./file-creation.page.scss'],
})
export class FileCreationPage implements OnInit, OnDestroy {

  public createFormGroup: FormGroup;
  public createFileSubscription$: Subscription;

  constructor(public readonly fileService: FileService,
              public readonly router: Router,
              public readonly alertCtrl: AlertController) { }

  ngOnInit() {

    this.createFormGroup = new FormGroup({
      designation: new FormControl('',[Validators.required]),
      creationDate: new FormControl('', [Validators.required]),
      link: new FormControl('', [Validators.required])
    });
  }

  createFile(){
    const  createFormValue =  this.createFormGroup.value as CreateFormValue;

    this.createFileSubscription$ = this.fileService.createFile(
      createFormValue.designation,
      createFormValue.creationDate,
      createFormValue.link)
      .subscribe(async (response: HttpResponse<any>)=>{
          if(response.status === 201 && response.statusText === 'OK'){
            const alert = await this.alertCtrl.create({
              header: 'Success',
              message: `Le fichier ${response.body.id}a été créé avec succès`,
              buttons: ['OK'],
              backdropDismiss: true
            });
            await alert.present();
          }
        }
      )
  }

  ngOnDestroy(){

    this.createFileSubscription$?.unsubscribe();
  }

}

interface CreateFormValue {
  designation: string,
  creationDate: IonDatetime,
  link: string
}
