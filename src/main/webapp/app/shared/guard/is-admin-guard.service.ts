import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {LoginService} from "../../login/service/login.service";

@Injectable({
  providedIn: 'root'
})
export class IsAdminGuard implements CanActivate {

  constructor(private readonly router: Router, private readonly loginService: LoginService) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {

    const isAdmin = this.loginService.isAdmin();

    if (!isAdmin){
      this.router.navigateByUrl('/home').then();
    }

    return isAdmin;
  }
}
