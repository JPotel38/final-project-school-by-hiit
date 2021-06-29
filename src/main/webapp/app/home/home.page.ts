import {Component, OnDestroy, OnInit} from '@angular/core';
import {UsersService} from "../shared/users.service";
import {User} from "../shared/interfaces/user/user";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit, OnDestroy{
  userSubscription: Subscription;

  constructor(public usersService : UsersService) {}

  ngOnInit() {
   this.userSubscription = this.usersService.getUsersFromBack().subscribe((data: User[]) =>
  console.log(data))
  }

  ngOnDestroy() {
    this.userSubscription.unsubscribe();
  }
}
