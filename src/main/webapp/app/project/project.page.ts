import { Component, OnInit } from '@angular/core';
import {ProjectService} from "../shared/project-service/project.service";
import {Observable} from "rxjs";
import {Project} from "../shared/interface/project";
import {Router} from "@angular/router";
import {AlertController} from "@ionic/angular";

@Component({
  selector: 'app-project',
  templateUrl: './project.page.html',
  styleUrls: ['./project.page.scss'],
})
export class ProjectPage implements OnInit {

  listProject:Observable<Project[]>
  constructor(public readonly projectService:ProjectService,public readonly route:Router,
              public readonly alertCtrl: AlertController) { }

  ngOnInit() {
    this.listProject=this.projectService.getAllProject();
  }


  goToDetailPage(id: number) {
    this.route.navigate(["/project-detail",id])
  }

  goToUpdatePage(id:number) {
    this.route.navigate(["/project-update",id])
  }

  deleteProject(id: number) {
    this.projectService.delete(id).subscribe(async value => {
        if (value.status===204){
          const alert = await this.alertCtrl.create({
            header: 'Alert',
            message: `L'utilisateur ${id} a bien été supprimé`,
            buttons: ['OK'],
            backdropDismiss: true
          });
          this.ngOnInit();
          await alert.present();
        }
    })
  }
}
