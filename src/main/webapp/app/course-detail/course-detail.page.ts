import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {CourseInterface} from "../shared/course-service/Course.interface";
import {ActivatedRoute, Router} from "@angular/router";
import {CourseService} from "../shared/course-service/course.service";
import {FileService} from "../shared/file-service/file.service";
import {FileInterface} from "../shared/file-service/File.interface";
import {HttpResponse} from "@angular/common/http";

@Component({
  selector: 'app-course-detail',
  templateUrl: './course-detail.page.html',
  styleUrls: ['./course-detail.page.scss'],
})
export class CourseDetailPage implements OnInit {

  public courseId: number;
  public courseDetail$: Observable<CourseInterface>;
  public fileList$: Observable<FileInterface[]>;

  constructor(public readonly activatedRoute: ActivatedRoute,
              public readonly courseService: CourseService,
              public readonly router: Router,
              public readonly fileService: FileService) { }

  ngOnInit() {
    this.courseId = this.activatedRoute.snapshot.params.id;
    this.courseDetail$ = this.courseService.getCourseDetail(this.courseId);
  }

  getFilesByCourse(courseId=this.courseId){
    this.fileList$ = this.fileService.getFileListByCourse(courseId);
  }

  async goToCourseUpdate(id: number){
    await this.router.navigate(['course-update', id]);
  }

  async goToFileList(){
    await this.router.navigate(['file-list']);
  }

  async goToFileDetail(id: number) {
    await this.router.navigate(['file-detail', id]);
  }
}
