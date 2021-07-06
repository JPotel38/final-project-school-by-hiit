import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {CourseInterface} from "../../shared/course-service/Course.interface";
import {Router} from "@angular/router";

@Component({
  selector: 'course-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss'],
})
export class ListComponent implements OnInit {

  @Input()
  public courseList: CourseInterface[];

  @Output()
  selectedCourse= new EventEmitter<number>();

  @Output()
  deletedCourse= new EventEmitter<number>();


  constructor(public readonly router: Router) { }

  ngOnInit() {}

  deleteCourse(courseId: number){
    this.deletedCourse.emit(courseId);
  }

  getCourseDetail(courseId: number){
    this.selectedCourse.emit(courseId);
  }

  async courseCreation(){
    await this.router.navigate(['course-creation']);
  }

}
