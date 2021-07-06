import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Observable, Subscription} from "rxjs";
import {FileService} from "../shared/file-service/file.service";
import {Router} from "@angular/router";
import {AlertController, IonDatetime} from "@ionic/angular";
import {HttpResponse} from "@angular/common/http";
import {CourseInterface} from "../shared/course-service/Course.interface";
import {FileInterface} from "../shared/file-service/File.interface";
import {CourseService} from "../shared/course-service/course.service";

@Component({
  selector: 'app-file-creation',
  templateUrl: './file-creation.page.html',
  styleUrls: ['./file-creation.page.scss'],
})
export class FileCreationPage implements OnInit, OnDestroy {

  public createFormGroup: FormGroup;
  public createFileSubscription$: Subscription;
  public courseList: Observable<CourseInterface[]>;
  public file: FileInterface;

  constructor(public readonly fileService: FileService,
              public readonly router: Router,
              public readonly alertCtrl: AlertController,
              public readonly courseService: CourseService) { }

  ngOnInit() {
    this.courseList = this.courseService.getCourseList();
    this.createFormGroup = new FormGroup({
      designation: new FormControl('',[Validators.required]),
      creationDate: new FormControl('', [Validators.required]),
      link: new FormControl('', [Validators.required]),
      course: new FormControl('')
    });
  }

  createFile(){
    this.createFileSubscription$ = this.fileService.createFile({
      designation: this.createFormGroup.value.designation,
      creationDate: this.createFormGroup.value.creationDate,
      link: this.createFormGroup.value.link,
      course:{
        id: this.createFormGroup.value.course
      }
    }
  )
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

