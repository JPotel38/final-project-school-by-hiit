import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {AlertController} from '@ionic/angular';
import {Observable, Subscription} from 'rxjs';
import {DatePipe} from "@angular/common";
import {UserService} from "../shared/service/user.service";
import {Role, User} from "../shared/interface/User.interface";
import {RoleService} from "../shared/service/role.service";

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.page.html',
  styleUrls: ['./create-user.page.scss'],
})
export class CreateUserPage implements OnInit, OnDestroy {

  public userForm: FormGroup;

  public isCreated$: Subscription;

  user: User;

  userRoles: Role[] = [];

  roleList: Role[];

  constructor(
    public readonly router: Router,
    public readonly userService: UserService,
    public readonly roleService: RoleService,
    public readonly alertCtrl: AlertController,
    private datePipe: DatePipe
  ) {
    this.userForm = new FormGroup({
      lastName: new FormControl('', Validators.required),
      firstName: new FormControl('', Validators.required),
      birthDate: new FormControl('', Validators.required),
      mail: new FormControl('', [Validators.email, Validators.required]),
      phoneNumber: new FormControl('', [Validators.pattern("[0-9 ]{10}"), Validators.required]),
      password: new FormControl('', [Validators.required]),
    });
  }

  ngOnInit() {
    this.getRoles();
  }

  getRoles() {
    this.roleService.getRoles().subscribe(
      (res: Role[]) => this.roleList = res
    )
  }

  addRole(role: Role) {
    if (!this.userRoles.includes(role)) {
      this.userRoles.push(role);
    }
  }

  removeRole(index: number) {
    this.userRoles.splice(index, 1);
  }


  createUser() {
    this.user = this.userForm.value;
    this.user.birthDate = this.datePipe.transform(this.user.birthDate, 'yyyy-MM-dd');
    this.user.roles = this.userRoles;

    const isCreated = this.userService.createUser(this.user);

    this.isCreated$ = isCreated.subscribe(
      async isCreated => {
        if (isCreated) {
          await this.router.navigate(['user-list']);
        } else {
          const alert = await this.alertCtrl.create({
            header: 'Erreur',
            message: "Il y a eu une erreur lors de la création du nouvel user",
            buttons: ['OK'],
            backdropDismiss: true
          });
          await alert.present();
        }
      }
    );
  }

  ngOnDestroy() {
    this.isCreated$.unsubscribe();
  }
}


