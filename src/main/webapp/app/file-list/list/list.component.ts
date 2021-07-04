import {Component, Input, OnInit, Output,EventEmitter} from '@angular/core';
import {FileInterface} from "../../shared/file-service/File.interface";

@Component({
  selector: 'file-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss'],
})
export class ListComponent implements OnInit {

  @Input()
  public fileList: FileInterface[];

  @Output()
  deleteFileEmitter= new EventEmitter<number>();

  constructor() { }

  ngOnInit() {}

  deleteFile(fileId: number){
    this.deleteFileEmitter.emit(fileId);
  }

}
