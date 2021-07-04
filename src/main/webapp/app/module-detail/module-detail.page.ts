import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {ActivatedRoute} from "@angular/router";
import {ModuleInterface} from "../shared/module-service/Module.interface";
import {ModuleService} from "../shared/module-service/module.service";


@Component({
  selector: 'app-module-detail',
  templateUrl: './module-detail.page.html',
  styleUrls: ['./module-detail.page.scss'],
})
export class ModuleDetailPage implements OnInit {

  moduleId: number;
  moduleDetail$: Observable<ModuleInterface>

  constructor(public readonly activatedRoute: ActivatedRoute,
              public readonly moduleService: ModuleService) { }

  ngOnInit() {
    this.moduleId = this.activatedRoute.snapshot.params.id;
    this.moduleDetail$ = this.moduleService.getModuleDetail(this.moduleId);

  }

}
