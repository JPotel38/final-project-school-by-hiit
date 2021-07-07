import {Component, OnInit, ViewChild} from '@angular/core';
import {CalendarOptions, EventApi, EventInput, FullCalendarComponent} from "@fullcalendar/angular";
import {EventService} from "../schedule/service/event.service";
import {Subscription} from "rxjs";
import {ScheduleEvent} from "../schedule/model/event.interface";
import {LoginService} from "../login/service/login.service";

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

  public isAdmin: boolean;

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
    eventTextColor: 'white',
    eventColor: '#97136b',
    initialView: 'timeGridWeek',
    weekends: true,
    firstDay: 1,
  };
  currentEvents: EventApi[] = [];


  constructor(private eventService: EventService,
              private readonly loginService: LoginService) { }

  ngOnInit() {
    this.isAdmin = this.loginService.isAdmin();
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
