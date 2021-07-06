import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {ModuleInterface} from "../../shared/module-service/Module.interface";
import {Router} from "@angular/router";


@Component({
  selector: 'module-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss'],
})
export class ListComponent implements OnInit {

  @Input()
  public moduleList: ModuleInterface[];

  @Output()
  selectedModule = new EventEmitter<number>();

  @Output()
  deletedModule= new EventEmitter<number>();

  constructor(public readonly router: Router) { }

  ngOnInit() {}

  deleteModule(moduleId: number){
    this.deletedModule.emit(moduleId);
  }
  getModuleDetail(moduleId: number){
    this.selectedModule.emit(moduleId);
  }
  async moduleCreation() {
    await this.router.navigate(['module-creation']);
  }

}
