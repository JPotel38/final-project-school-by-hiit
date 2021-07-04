import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {ModuleInterface} from "./service/Module.interface";
import {ModuleService} from "./service/module.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-module-list',
  templateUrl: './module-list.page.html',
  styleUrls: ['./module-list.page.scss'],
})
export class ModuleListPage implements OnInit {

  public moduleList$ : Observable<ModuleInterface[]>;

  constructor(public readonly moduleService:ModuleService, public readonly router: Router) { }

  ngOnInit() {
    this.getModuleList();
  }

  getModuleList(){
    this.moduleList$ = this.moduleService.getModuleList();
  }

}
