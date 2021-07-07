import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {ModuleInterface} from "../shared/module-service/Module.interface";
import {ModuleService} from "../shared/module-service/module.service";
import {CourseService} from "../shared/course-service/course.service";
import {CourseInterface} from "../shared/course-service/Course.interface";


@Component({
  selector: 'app-module-detail',
  templateUrl: './module-detail.page.html',
  styleUrls: ['./module-detail.page.scss'],
})
export class ModuleDetailPage implements OnInit {

  public moduleId: number;
  public moduleDetail$: Observable<ModuleInterface>
  public courseList$: Observable<CourseInterface[]>

  constructor(public readonly activatedRoute: ActivatedRoute,
              public readonly moduleService: ModuleService,
              public readonly router: Router,
              public readonly courseService: CourseService) { }

  ngOnInit() {
    this.moduleId = this.activatedRoute.snapshot.params.id;
    this.moduleDetail$ = this.moduleService.getModuleDetail(this.moduleId);
  }

  getCoursesByModule(moduleId=this.moduleId){
    this.courseList$ = this.courseService.getCourseListByModule(moduleId);
  }

  async goToModuleUpdate(id: number){
    await this.router.navigate(['module-update', id]);
  }

  async goToCourseDetail(id: number) {
    await this.router.navigate(['course-detail', id]);
  }


}
