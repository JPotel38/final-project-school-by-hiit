import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {CourseInterface} from "../shared/course-service/Course.interface";
import {ActivatedRoute, Router} from "@angular/router";
import {CourseService} from "../shared/course-service/course.service";

@Component({
  selector: 'app-course-detail',
  templateUrl: './course-detail.page.html',
  styleUrls: ['./course-detail.page.scss'],
})
export class CourseDetailPage implements OnInit {

  courseId: number;
  courseDetail$: Observable<CourseInterface>;

  constructor(public readonly activatedRoute: ActivatedRoute,
              public readonly courseService: CourseService,
              public readonly router: Router) { }

  ngOnInit() {
    this.courseId = this.activatedRoute.snapshot.params.id;
    this.courseDetail$ = this.courseService.getCourseDetail(this.courseId);
  }
  async goToCourseUpdate(id: number){
    await this.router.navigate(['course-update', id]);
  }

  async goToFileList(){
    await this.router.navigate(['file-list']);
  }

}
