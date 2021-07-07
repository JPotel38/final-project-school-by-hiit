import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AlertController } from '@ionic/angular';
import { LoginService } from './service/login.service';
import { Observable, Subscription } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  public loginFormGroup: FormGroup;
  public isConnected$: Subscription;

  constructor(
    public readonly router: Router,
    public readonly loginService: LoginService,
    public readonly alertCtrl: AlertController,
  )
  {
  this.loginFormGroup = new FormGroup({
        mail: new FormControl('', Validators.required),
        password: new FormControl('', Validators.required)
      });
  }

  ngOnInit() {}

  seConnecter() {
    const loginFormValue = this.loginFormGroup.value;

    const isConnected = this.loginService.isConnected(loginFormValue.mail, loginFormValue.password)

    this.isConnected$ = isConnected.subscribe(
      async isConnected => {
         if(isConnected) {
            await this.router.navigate(['home']);
          } else {
            const alert = await this.alertCtrl.create({
            header: 'Erreur',
            message: "L'email ou le mot de passe est invalide",
            buttons: ['OK'],
            backdropDismiss: true
            });
            await alert.present();
          }
      }
    );
  }

   ngOnDestroy(): void {
      this.isConnected$?.unsubscribe();
    }
}

