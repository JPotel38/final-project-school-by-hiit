import {Component, OnDestroy, OnInit} from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {User} from "../shared/interface/User.interface";
import {UserService} from "../shared/service/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.page.html',
  styleUrls: ['./user-list.page.scss'],
})
export class UserListPage implements OnInit, OnDestroy {

  public userListSubscription$: Subscription;

  private deleteSubscription$: Subscription;

  public userList: User[];

  constructor(
    public readonly userService: UserService,
    public readonly router: Router
  ) {
  }

  ngOnInit() {
    this.getUserList();
  }

  getUserList() {
    this.userListSubscription$ = this.userService.getUserList().subscribe(
      (res: User[]) => {
        this.userList = res;
      }
    );
  }

  deleteUser(index: number) {
    let userId = this.userList[index].id;
    this.deleteSubscription$ = this.userService.deleteUser(userId).subscribe(
      () => this.userList.splice(index, 1)
    );
  }

  async gotToUserDetail(id: number) {
    await this.router.navigate(['user-detail', id]);
  }

  ngOnDestroy() {
    this.userListSubscription$.unsubscribe();
    this.deleteSubscription$.unsubscribe();
  }
}
