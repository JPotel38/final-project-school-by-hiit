import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Observable} from "rxjs";
import {FileInterface} from "../shared/file-service/File.interface";
import {FileService} from "../shared/file-service/file.service";


@Component({
  selector: 'app-file-detail',
  templateUrl: './file-detail.page.html',
  styleUrls: ['./file-detail.page.scss'],
})
export class FileDetailPage implements OnInit {

  fileId: number;
  fileDetail$: Observable<FileInterface>;

  constructor(public readonly activatedRoute: ActivatedRoute,
              public readonly fileService: FileService) { }

  ngOnInit() {
    this.fileId= this.activatedRoute.snapshot.params.id;
    this.fileDetail$= this.fileService.getFileDetail(this.fileId);
  }

}
