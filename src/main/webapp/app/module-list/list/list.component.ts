import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {ModuleInterface} from "../service/Module.interface";


@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss'],
})
export class ListComponent implements OnInit {

  @Input()
  public moduleList : ModuleInterface[];

  @Output()
  deleteModuleEmitter = new EventEmitter<number>();

  constructor() { }

  ngOnInit() {}

  deleteModule(moduleId: number){
    this.deleteModuleEmitter.emit(moduleId);
  }

}
