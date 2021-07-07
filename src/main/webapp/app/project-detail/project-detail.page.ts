import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Project} from "../shared/interface/project";
import {ProjectService} from "../shared/project-service/project.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-project-detail',
  templateUrl: './project-detail.page.html',
  styleUrls: ['./project-detail.page.scss'],
})
export class ProjectDetailPage implements OnInit {
  project$:Observable<Project>;
  projectId:number;
  constructor(public readonly activedRoute:ActivatedRoute, public readonly projectService:ProjectService,public readonly route:Router ) { }

  ngOnInit() {
   this.projectId= this.activedRoute.snapshot.params.id;
   this.project$=this.projectService.getProject(this.projectId);
  }

  goToBackPage() {
    this.route.navigateByUrl("project");
  }
}
