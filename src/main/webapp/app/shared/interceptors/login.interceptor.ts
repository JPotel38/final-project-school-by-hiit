import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";

@Injectable()
export class LoginInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = localStorage.getItem('token');
    if(!!token){
      const reqCloned = req.clone({
        headers: req.headers.set('Authorization', `${token}`)
      });
      return next.handle(reqCloned);
    } else {
      return next.handle(req);
    }
  }
}
