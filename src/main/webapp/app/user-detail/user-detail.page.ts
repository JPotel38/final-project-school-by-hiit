import {AfterViewInit, ChangeDetectionStrategy, Component, OnDestroy, OnInit} from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../shared/service/user.service";
import {User} from "../shared/interface/User.interface";

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.page.html',
  styleUrls: ['./user-detail.page.scss'],
})
export class UserDetailPage implements OnInit {

  userId: number;
  userDetail$: Observable<User>;

  constructor(public readonly activatedRoute: ActivatedRoute,
              public readonly userService: UserService,
              public readonly router: Router) {
  }

  ngOnInit() {
    this.userId = this.activatedRoute.snapshot.params.id;
    this.userDetail$ = this.userService.getUserDetail(this.userId);
  }

  async goToUpdateUser() {
    await this.router.navigate(['/user-update', this.userId]);
  }

  async goToUserList(){
    await this.router.navigate(['/user-list']);
  }

}
