import {Component, OnInit, ViewChild} from '@angular/core';
import {CalendarOptions, EventApi, EventInput, FullCalendarComponent} from "@fullcalendar/angular";
import {EventService} from "../schedule/service/event.service";
import {Subscription} from "rxjs";
import {ScheduleEvent} from "../schedule/model/event.interface";

@Component({
  selector: 'app-schedule-view',
  templateUrl: './schedule-view.page.html',
  styleUrls: ['./schedule-view.page.scss'],
})
export class ScheduleViewPage implements OnInit {

  @ViewChild('fullCalendar') fullcalendar: FullCalendarComponent;

  private eventList$: Subscription;

  private eventList: ScheduleEvent[];

  private events: EventInput[] = [];
  
  calendarVisible = true;
  calendarOptions: CalendarOptions = {
    headerToolbar: {
      left: '',
      center: 'prev today next',
      right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
    },
    timeZone: 'UTC',
    slotLabelFormat: {
      hour: '2-digit',
      minute: '2-digit',
      hour12: false
    },
    eventTimeFormat: {
      hour: '2-digit',
      minute: '2-digit',
      hour12: false
    },
    initialView: 'timeGridWeek',
    weekends: true,
    firstDay: 1,
  };
  currentEvents: EventApi[] = [];

  constructor(private eventService: EventService) { }

  ngOnInit() {
    this.getCourseList();
    setTimeout(() => {
      this.fullcalendar.getApi().render()
    });
  }

  getCourseList() {
    this.eventList$ = this.eventService.getEventList().subscribe(
      (res: any) => {
        this.eventList = res;
        this.courseListToEvents(this.eventList);
      });
  }

  courseListToEvents(eventList) {
    eventList.forEach(
      (event) => this.events.push(event)
    );
    this.calendarOptions.events = this.events;
  }

}
