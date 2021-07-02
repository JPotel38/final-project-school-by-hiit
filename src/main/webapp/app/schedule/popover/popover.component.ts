import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {PopoverController} from "@ionic/angular";
import {EventInput} from "@fullcalendar/angular";
import {EventService} from "../service/event.service";
import {Router} from "@angular/router";
import {ScheduleEvent} from "../model/event.interface";

@Component({
  selector: 'app-popover',
  templateUrl: './popover.component.html',
  styleUrls: ['./popover.component.scss'],
})
export class PopoverComponent implements OnInit {

  @Input() event: EventInput;

  @Input() courseList;

  courseId: number;

  constructor(public popoverController: PopoverController,
              public eventService: EventService,
              public readonly router: Router) {
  }

  ngOnInit() {
  }

  async close() {
    await this.popoverController.dismiss();
  }

  async delete() {
    await this.popoverController.dismiss({
        operation: 'DELETE',
        event: this.event
      }
    )
  }

  async update() {
    await this.popoverController.dismiss({
      operation: 'UPDATE',
      event: this.event,
      courseId: this.courseId
    });
  }

}
