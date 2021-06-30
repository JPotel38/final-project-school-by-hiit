import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from './service/login.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  public loginFormGroup: FormGroup;

  constructor(
    public readonly router: Router,
    public readonly loginService: LoginService,
  )
  {
  this.loginFormGroup = new FormGroup({
        email: new FormControl('', Validators.required),
        password: new FormControl('', Validators.required)
      });
  }

  ngOnInit() {

  }

  seConnecter() {
    const loginFormValue = this.loginFormGroup.value;
      console.log(loginFormValue)
  }

  submitForm() {
  console.log(this.loginFormGroup.getRawValue)
  }
}
