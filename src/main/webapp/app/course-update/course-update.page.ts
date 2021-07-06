import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Subscription} from "rxjs";
import {CourseInterface} from "../shared/course-service/Course.interface";
import {CourseService} from "../shared/course-service/course.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AlertController} from "@ionic/angular";

@Component({
  selector: 'app-course-update',
  templateUrl: './course-update.page.html',
  styleUrls: ['./course-update.page.scss'],
})
export class CourseUpdatePage implements OnInit, OnDestroy {

  public updateFormGroup: FormGroup;
  public courseId: number;
  public updateCourseSubscription$: Subscription;
  public courseInterface: CourseInterface;

  constructor(public readonly courseService: CourseService,
              public readonly activatedRoute: ActivatedRoute,
              public readonly alertCtrl: AlertController,
              public readonly router: Router) { }

  ngOnInit() {

    this.courseId = this.activatedRoute.snapshot.params.id;
    this.courseService.getCourseDetail(this.courseId).subscribe(
      value => {
        this.courseInterface= value

      });


    this.updateFormGroup = new FormGroup({
      designation: new FormControl('', Validators.required)
    });

  }

  updateCourse(){
    let course: CourseInterface = this.updateFormGroup.value;
    this.updateCourseSubscription$ = this.courseService.updateCourse(this.courseId,course.designation,course.date,course.startTime,course.endTime)
      .subscribe(
        async value => {
          if (value.status === 200) {
            const alert = await this.alertCtrl.create({
              header: 'Success',
              message: `Le Module ${this.courseId} a été modifié avec succès`,
              buttons: ['OK'],
              backdropDismiss: true

            });
            await alert.present();
          }
        }
      );
    this.goToCourseList().then();
  }

  async goToCourseList() {
    await this.router.navigate(['course-list']);
  }

  ngOnDestroy(){
  }

}
