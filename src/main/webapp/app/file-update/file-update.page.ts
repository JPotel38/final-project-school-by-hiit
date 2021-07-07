import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Observable, Subscription} from "rxjs";
import {FileInterface} from "../shared/file-service/File.interface";
import {ActivatedRoute, Router} from "@angular/router";
import {AlertController} from "@ionic/angular";
import {FileService} from "../shared/file-service/file.service";
import {CourseInterface} from "../shared/course-service/Course.interface";
import {CourseService} from "../shared/course-service/course.service";

@Component({
  selector: 'app-file-update',
  templateUrl: './file-update.page.html',
  styleUrls: ['./file-update.page.scss'],
})
export class FileUpdatePage implements OnInit, OnDestroy {

  public updateFormGroup: FormGroup;
  public fileId: number;
  public updateFileSubscription$: Subscription;
  public fileInterface: FileInterface;
  courseList$: Observable<CourseInterface[]>;

  constructor(public readonly fileService: FileService,
              public readonly activatedRoute: ActivatedRoute,
              public readonly alertCtrl: AlertController,
              public readonly router: Router,
              public readonly courseService: CourseService) { }

  ngOnInit() {

    this.fileId = this.activatedRoute.snapshot.params.id;
      this.fileService.getFileDetail(this.fileId).subscribe(
      value => {
        this.fileInterface= value

      });
    this.courseList$= this.courseService.getCourseList();


    this.updateFormGroup = new FormGroup({
      designation: new FormControl('', Validators.required),
      creationDate: new FormControl('', Validators.required),
      link: new FormControl('', Validators.required),
      course:  new FormControl('', Validators.required)
    });
  }

  updateFile(){
    let file: FileInterface = this.updateFormGroup.value;
    this.updateFileSubscription$ = this.fileService.updateFile(this.fileId,file.designation,file.creationDate,file.link,{id: file.course})
      .subscribe(
        async value => {
          if (value.status === 200) {
            const alert = await this.alertCtrl.create({
              header: 'Success',
              message: `Le Module ${this.fileId} a été modifié avec succès`,
              buttons: ['OK'],
              backdropDismiss: true

            });
            await alert.present();
          }
        }
      );
    this.goToFileList().then();
  }

  async goToFileList() {
    await this.router.navigate(['file-list']);
  }


  ngOnDestroy(){
  }

}
