import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {ModuleInterface} from "../shared/module-service/Module.interface";
import {ModuleService} from "../shared/module-service/module.service";


@Component({
  selector: 'app-module-detail',
  templateUrl: './module-detail.page.html',
  styleUrls: ['./module-detail.page.scss'],
})
export class ModuleDetailPage implements OnInit {

  public moduleId: number;
  public moduleDetail$: Observable<ModuleInterface>

  constructor(public readonly activatedRoute: ActivatedRoute,
              public readonly moduleService: ModuleService,
              public readonly router: Router) { }

  ngOnInit() {
    this.moduleId = this.activatedRoute.snapshot.params.id;
    this.moduleDetail$ = this.moduleService.getModuleDetail(this.moduleId);

  }

  async goToCourseList(){
    await this.router.navigate(['course-list']);
  }

}
