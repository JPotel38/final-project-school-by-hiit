import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit, OnDestroy{
  constructor(
  ) {}

  ngOnInit() {
  }


  ngOnDestroy() {
  }
}
