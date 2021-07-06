import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Observable, Subscription} from "rxjs";
import {CourseService} from "../shared/course-service/course.service";
import {Router} from "@angular/router";
import {AlertController} from "@ionic/angular";
import {HttpResponse} from "@angular/common/http";
import {ModuleService} from "../shared/module-service/module.service";
import {ModuleInterface} from "../shared/module-service/Module.interface";
import {CourseInterface} from "../shared/course-service/Course.interface";

@Component({
  selector: 'app-course-creation',
  templateUrl: './course-creation.page.html',
  styleUrls: ['./course-creation.page.scss'],
})
export class CourseCreationPage implements OnInit, OnDestroy {

  public createFormGroup: FormGroup;
  public createCourseSubscription$: Subscription;
  public moduleList: Observable<ModuleInterface[]>;
  public course: CourseInterface;

  constructor(public readonly courseService: CourseService,
              public readonly router: Router,
              public readonly alertCtrl: AlertController,
              public readonly moduleService: ModuleService) { }

  ngOnInit() {
    this.moduleList = this.moduleService.getModuleList();
    this.createFormGroup = new FormGroup({
      designation: new FormControl('',[Validators.required]),
      date: new FormControl('', [Validators.required]),
      startTime: new FormControl('', [Validators.required]),
      endTime: new FormControl('', [Validators.required]),
      module: new FormControl('')
    });
  }

  createCourse(){
    this.createCourseSubscription$ = this.courseService.createCourse({
      designation:  this.createFormGroup.value.designation,
      date: this.createFormGroup.value.date,
      endTime: this.createFormGroup.value.endTime,
      startTime: this.createFormGroup.value.startTime,
      module: {
       id: this.createFormGroup.value.module
      }
    }
  )
      .subscribe(async (response: HttpResponse<any>)=>{
        if(response.status === 201 && response.statusText === 'OK'){
          const alert = await this.alertCtrl.create({
            header: 'Success',
            message: `Le cours ${response.body.id}a été créé avec succès`,
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

