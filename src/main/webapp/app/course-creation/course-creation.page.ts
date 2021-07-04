import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Subscription} from "rxjs";
import {CourseService} from "../shared/course-service/course.service";
import {Router} from "@angular/router";
import {AlertController} from "@ionic/angular";
import {Time} from "@angular/common";
import {HttpResponse} from "@angular/common/http";

@Component({
  selector: 'app-course-creation',
  templateUrl: './course-creation.page.html',
  styleUrls: ['./course-creation.page.scss'],
})
export class CourseCreationPage implements OnInit, OnDestroy {

  public createFormGroup: FormGroup;
  public createCourseSubscription$: Subscription;

  constructor(public readonly courseService: CourseService,
              public readonly router: Router,
              public readonly alertCtrl: AlertController) { }

  ngOnInit() {
    this.createFormGroup = new FormGroup({
      designation: new FormControl('',[Validators.required]),
      date: new FormControl('', [Validators.required]),
      startTime: new FormControl('', [Validators.required]),
      endTime: new FormControl('', [Validators.required])
    });
  }

  createCourse(){
    const  createFormValue =  this.createFormGroup.value as CreateFormValue;

    this.createCourseSubscription$ = this.courseService.createCourse(createFormValue.designation,
      createFormValue.date,
      createFormValue.startTime,
      createFormValue.endTime)
      .subscribe(async (response: HttpResponse<any>)=>{
        if(response.status === 201 && response.statusText === 'OK'){
          const alert = await this.alertCtrl.create({
            header: 'Success',
            message: `Le Cours ${response.body.id}a été créé avec succès`,
            buttons: ['OK'],
            backdropDismiss: true
          });
          await alert.present();
        }
      }
    )
  }

  ngOnDestroy() {
    this.createCourseSubscription$?.unsubscribe();
  }
}

interface CreateFormValue {
  designation: string,
  date: Date,
  startTime: Time,
  endTime: Time
}
