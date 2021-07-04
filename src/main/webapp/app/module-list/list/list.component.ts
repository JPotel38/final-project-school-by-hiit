import {Component, Input, OnInit} from '@angular/core';
import {ModuleInterface} from "../service/Module.interface";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss'],
})
export class ListComponent implements OnInit {

  @Input()
  public moduleList : ModuleInterface[];

  constructor() { }

  ngOnInit() {}

}
