import {Component, Input, OnInit} from '@angular/core';
import {PopoverController} from "@ionic/angular";
import {EventService} from "../service/event.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-popover',
  templateUrl: './create-popover.component.html',
  styleUrls: ['./create-popover.component.scss'],
})
export class CreatePopoverComponent implements OnInit {

  @Input() courseList;

  eventTitle;

  courseId;

  constructor(public popoverController: PopoverController,
              public eventService: EventService,
              public readonly router: Router) {
  }

  ngOnInit() {
  }

  async create() {
    await this.popoverController.dismiss({
      title: this.eventTitle,
      courseId: this.courseId
    });
  }
  async close() {
    await this.popoverController.dismiss();
  }



}
