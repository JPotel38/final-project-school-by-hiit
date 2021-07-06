import {Component, Input, OnInit, Output,EventEmitter} from '@angular/core';
import {FileInterface} from "../../shared/file-service/File.interface";
import {Router} from "@angular/router";

@Component({
  selector: 'file-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss'],
})
export class ListComponent implements OnInit {

  @Input()
  public fileList: FileInterface[];

  @Output()
  selectedFile= new EventEmitter<number>();

  @Output()
  deletedFile= new EventEmitter<number>();

  constructor(public readonly router: Router) { }

  ngOnInit() {}

  deleteFile(fileId: number){
    this.deletedFile.emit(fileId);
  }

  getFileDetail(fileId: number){
    this.selectedFile.emit(fileId);
  }

  async fileCreation(){
    await this.router.navigate(['file-creation'])
  }

}
