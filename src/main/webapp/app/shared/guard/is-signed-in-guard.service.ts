
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import {LoginService} from "../../login/service/login.service";

@Injectable({
  providedIn: 'root'
})
export class IsSignedInGuard implements CanActivate {

  constructor(private readonly router: Router) {
  }


  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const tokenExist = !!localStorage.getItem('token');

    if(!tokenExist) {
      this.router.navigateByUrl('login').then();
    }

    return tokenExist;
  }
}
