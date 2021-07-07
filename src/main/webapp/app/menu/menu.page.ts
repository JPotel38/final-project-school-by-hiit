import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {LoginService} from "../login/service/login.service";
import {Router} from "@angular/router";
import {MenuPageModule} from "./menu.module";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.page.html',
  styleUrls: ['./menu.page.scss'],
})
export class MenuPage implements OnInit {
  @Input() variable: string;

  @Output() event: EventEmitter<any> = new EventEmitter();

  isLogged: boolean;

  isAdmin: boolean

  constructor(public readonly loginService: LoginService,
              public readonly router: Router) {
  }

  ngOnInit() {
    this.isLogged = this.loginService.isLogged();
    this.isAdmin = this.loginService.isAdmin();
  }

  eventFunction() {
    // console.log('test');
    // this.event.emit('click')
  }

  logout() {
    localStorage.removeItem('token')
    this.router.navigate(['home']).then(
      () => window.location.reload()
    );
  }

  async login() {
    await this.router.navigate(['login']);
  }
}
