import {Component, OnDestroy, OnInit} from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {Role, User} from "../shared/interface/User.interface";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../shared/service/user.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {RoleService} from "../shared/service/role.service";

@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.page.html',
  styleUrls: ['./user-update.page.scss'],
})
export class UserUpdatePage implements OnInit, OnDestroy {

  private userId: number;

  private userDetailSubscription$: Subscription;

  private updateSubscription$: Subscription;

  public user: User;

  public userForm: FormGroup;

  public userRoles: Role[] = [];

  public roleList: Role[];

  constructor(public readonly activatedRoute: ActivatedRoute,
              public readonly userService: UserService,
              public readonly roleService: RoleService,
              public readonly router: Router) {
    this.userForm = new FormGroup({
      mail: new FormControl('', [Validators.email]),
      phoneNumber: new FormControl('', [Validators.pattern("[0-9 ]{10}")]),
      password: new FormControl('')
    });
  }


  ngOnInit() {
    this.userId = this.activatedRoute.snapshot.params.id;
    this.getUserDetail(this.userId);
    this.getRoles();
  }

  getRoles() {
    this.roleService.getRoles().subscribe(
      (res: Role[]) => this.roleList = res
    )
  }

  getUserDetail(id: number) {
    this.userDetailSubscription$ = this.userService.getUserDetail(id).subscribe(
      (res) => {
        this.user = res;
        this.userRoles = this.user.roles;
      }
    );
  }

  updateUser() {
    this.user.mail = this.userForm.value.mail.length == 0 ?
      this.user.mail : this.userForm.value.mail;
    this.user.phoneNumber = this.userForm.value.phoneNumber.length == 0 ?
      this.user.phoneNumber : this.userForm.value.phoneNumber;
    this.user.password = this.userForm.value.password.length == 0 ?
      this.user.password : this.userForm.value.password;

    this.user.roles = this.userRoles;
    this.updateSubscription$ = this.userService.updateUser(this.userId, this.user).subscribe(
      () => this.goToUserDetail()
    );
  }

  addRole(role: Role) {
    let rolesIdList = this.userRoles.map(role => role.id);
    if (!rolesIdList.includes(role.id)) {
      this.userRoles.push(role);
    }
  }

  removeRole(index: number) {
    this.userRoles.splice(index, 1);
  }

  async cancelChange() {
    await this.goToUserDetail();
  }

  async goToUserDetail() {
    await this.router.navigate(['/user-detail', this.userId])
  }

  ngOnDestroy(): void {
    this.updateSubscription$.unsubscribe();
    this.userDetailSubscription$.unsubscribe();
  }
}
