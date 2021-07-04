import {Component, OnDestroy, OnInit} from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {FileInterface} from "../shared/file-service/File.interface";
import {Router} from "@angular/router";
import {AlertController} from "@ionic/angular";
import {HttpResponse} from "@angular/common/http";

@Component({
  selector: 'app-file-list',
  templateUrl: './file-list.page.html',
  styleUrls: ['./file-list.page.scss'],
})
export class FileListPage implements OnInit, OnDestroy {

  public fileList$: Observable<FileInterface>;
  public deleteFileSubscription$: Subscription;

  constructor(public readonly fileService,
              public readonly router: Router,
              public readonly alertCtrl: AlertController) { }

  ngOnInit() {
  }

  getFileList(){
    this.fileList$= this.fileService.getFileList();
  }

  deleteFile(fileId: number){
    this.deleteFileSubscription$= this.fileService.deleteFile(fileId).subscribe(
      async (response: HttpResponse<any>)=>{
        if (response.status === 204 && response.statusText === 'OK'){
          const alert= await this.alertCtrl.create({
            header: 'Alert',
            message: `Le fichier ${fileId} a bien été supprimé`,
            buttons: [`OK`],
            backdropDismiss: true
          });
          await alert.present();
        }
      }
    )
  }

  ngOnDestroy(){
    this.deleteFileSubscription$?.unsubscribe();
  }

  async fileCreation(){
    await this.router.navigate(['file-creation']);
  }

}
