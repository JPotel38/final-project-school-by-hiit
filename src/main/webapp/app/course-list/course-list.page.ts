import {Component, OnDestroy, OnInit} from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {CourseInterface} from "../shared/course-service/Course.interface";
import {CourseService} from "../shared/course-service/course.service";
import {Router} from "@angular/router";
import {AlertController} from "@ionic/angular";
import {HttpResponse} from "@angular/common/http";

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.page.html',
  styleUrls: ['./course-list.page.scss'],
})
export class CourseListPage implements OnInit, OnDestroy {

  public courseList$: Observable<CourseInterface[]>;
  public deleteCourseSubscription$: Subscription;

  constructor(public readonly courseService: CourseService,
              public readonly router: Router,
              public readonly alertCtrl: AlertController) { }

  ngOnInit() {
    this.getCourseList();
  }

  getCourseList(){
    this.courseList$= this.courseService.getCourseList();
  }

  deleteCourse(courseId: number){
    this.deleteCourseSubscription$= this.courseService.deleteCourse(courseId).subscribe(
      async (response: HttpResponse<any>)=>{
        if (response.status === 204){
          const alert= await this.alertCtrl.create({
            header: 'Alert',
            message: `Le cours ${courseId} a bien été supprimé`,
            buttons: [`OK`],
            backdropDismiss: true
          });
          await alert.present();
        }
      }
    )
  }

  ngOnDestroy() {
    this.deleteCourseSubscription$?.unsubscribe();
  }

  async courseCreation(){
    await this.router.navigate(['course-creation']);
  }

  async goToCourseDetail(id: number) {
    await this.router.navigate(['course-detail', id]);
  }

  async goToCourseList() {
    await this.router.navigate(['course-list']);
  }

}
