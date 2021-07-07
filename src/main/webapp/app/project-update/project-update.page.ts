import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {ProjectService} from "../shared/project-service/project.service";
import {Project} from "../shared/interface/project";
import {AlertController} from "@ionic/angular";

@Component({
  selector: 'app-project-update',
  templateUrl: './project-update.page.html',
  styleUrls: ['./project-update.page.scss'],
})
export class ProjectUpdatePage implements OnInit {
  projectFormGroup: FormGroup;
  listStatusProject: any;
  project:Project;
  id:number;

  constructor(public readonly activatedRoute:ActivatedRoute,
              public readonly route:Router,
              public readonly projectService:ProjectService,
              public readonly alertCtrl:AlertController) { }

  ngOnInit() {
    this.id = this.activatedRoute.snapshot.params.id;
    this.projectService.getProject(this.id).subscribe(value => this.project=value);
    this.projectFormGroup= new FormGroup({
      idProject:new FormControl(this.id),
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

  }
  updateProject() {
    let project ={
      idProject:this.id,
      nameProjects: this.projectFormGroup.value.nameProject,
      projectStatus:this.projectFormGroup.value.projectStatus.value,
      scoreProject:this.projectFormGroup.value.scoreProject
    }
   this.projectService.update(this.id,project)
     .subscribe(async value => {
       if (value.status === 200) {
         const alert = await this.alertCtrl.create({
           header: 'Alert',
           message: `l utilisateur avec id ${this.id} est mis à jour `,
           buttons: ['OK'],
           backdropDismiss: true
         });
         await alert.present();
       }
     })
    this.route.navigateByUrl("projects");
  }

  goBack() {
    this.route.navigateByUrl("projects")
  }
}
