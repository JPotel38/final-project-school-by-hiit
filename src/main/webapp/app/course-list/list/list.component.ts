import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {CourseInterface} from "../../shared/course-service/Course.interface";

@Component({
  selector: 'course-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss'],
})
export class ListComponent implements OnInit {

  @Input()
  public courseList: CourseInterface[];

  @Output()
  deleteCourseEmitter= new EventEmitter<number>();

  constructor() { }

  ngOnInit() {}

  deleteCourse(courseId: number){
    this.deleteCourseEmitter.emit(courseId);
  }

}
