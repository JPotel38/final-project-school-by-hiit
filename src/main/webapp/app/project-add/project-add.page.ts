import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Project} from "../shared/interface/project";
import {ProjectService} from "../shared/project-service/project.service";
import {AlertController} from "@ionic/angular";

@Component({
  selector: 'app-project-add',
  templateUrl: './project-add.page.html',
  styleUrls: ['./project-add.page.scss'],
})
export class ProjectAddPage implements OnInit {
  projectFormGroup: FormGroup;
  listStatusProject:Observable<any[]>
  project:Project

  constructor(
    public readonly projectService:ProjectService,
    public readonly alertCtrl: AlertController) {
  }

  ngOnInit() {
    this.projectFormGroup= new FormGroup({
      nameProject: new FormControl('', [Validators.required]),
      projectStatus: new FormControl('', [Validators.required]),
      scoreProject: new FormControl('')
    })
    this.projectFormGroup.value.statusProject=[
      {
        value:"IN_PROGRESS",
        name:"En cours"
      },
      {
        value:"DELIVERED",
        name:"Rendu"
      },
      {
        value:"CORRECTED",
        name:"Corrigé"
      }];
    this.listStatusProject=this.projectFormGroup.value.statusProject;
    console.log(this.listStatusProject)
  }

  createProject() {
    this.project={
      idProject: null,
      nameProjects:this.projectFormGroup.value.nameProject,
      projectStatus:this.projectFormGroup.value.statusProject.value,
      scoreProject:this.projectFormGroup.value.scoreProject
    };
    this.projectService.create(this.project)
      .subscribe(async value => {
        if (value.status === 201) {
          const alert = await this.alertCtrl.create({
            header: 'Alert',
            message: 'Projet ajoute',
            buttons: ['OK'],
            backdropDismiss: true
          });
          await alert.present();
        }
      })
  }
}
