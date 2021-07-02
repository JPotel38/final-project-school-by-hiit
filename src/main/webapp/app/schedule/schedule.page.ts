import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {
  CalendarOptions,
  DateSelectArg,
  EventApi,
  EventChangeArg,
  EventInput,
  FullCalendarComponent
} from "@fullcalendar/angular";
import {EventService} from "./service/event.service";
import {Subscription} from "rxjs";
import {ScheduleEvent} from "./model/event.interface";
import {PopoverController} from "@ionic/angular";
import {PopoverComponent} from "./popover/popover.component";
import {CreatePopoverComponent} from "./create-popover/create-popover.component";


@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.page.html',
  styleUrls: ['./schedule.page.scss'],
})
export class SchedulePage implements OnInit, OnDestroy {

  @ViewChild('fullCalendar') fullcalendar: FullCalendarComponent;

  private eventList$: Subscription;

  private deleteSubscription: Subscription;

  private eventList: ScheduleEvent[];

  private events: EventInput[] = [];

  private event: EventInput;

  courses = [
    {
      id: 1,
      designation: 'Devops'
    },
    {
      id: 2,
      designation: 'FrontEnd'
    }
  ];

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
    editable: true,
    selectable: true,
    selectMirror: true,
    dayMaxEvents: true,
    firstDay: 1,
    nowIndicator: false,
    select: this.handleDateSelect.bind(this),
    eventClick: this.showPopover.bind(this),
    eventsSet: this.handleEvents.bind(this),
    eventChange: this.handleEventChange.bind(this)
  };
  currentEvents: EventApi[] = [];


  constructor(private eventService: EventService,
              public popoverController: PopoverController) {
  }

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

  async handleDateSelect(selectInfo: any) {
    //const title = prompt('Please enter a new title for your event');
    const calendarApi = selectInfo.view.calendar;
    calendarApi.unselect(); // clear date selection

    const popover = await this.popoverController.create({
      event: selectInfo,
      component: CreatePopoverComponent,
      componentProps: {
        courseList: this.courses,
      },
    });
    await popover.present();

    return popover.onDidDismiss().then(
      (data: any) => {
        console.log(data.data.title)
        this.eventService.createEvent({
          title: data.data.title,
          start: selectInfo.start,
          end: selectInfo.end,
          allDay: selectInfo.allDay,
          courseId: data.data.courseId,
        }).subscribe(
          (event: ScheduleEvent) => {
            calendarApi.addEvent({
                id: `${event.id}`,
                title: event.title,
                start: event.start,
                end: event.end,
                allDay: event.allDay
              }
            )
          })
      });
  }

  handleEvents(events: EventApi[]) {
    this.currentEvents = events;
  }

  handleEventChange(changeInfo: EventChangeArg) {
    this.eventService.updateEvent(+changeInfo.event.id, {
      title: changeInfo.event.title,
      start: changeInfo.event.start,
      end: changeInfo.event.end,
      allDay: changeInfo.event.allDay,
      courseId: 0,
    }).subscribe()
  }

  async showPopover(ev: any) {
    this.event = {
      id: ev.event.id,
      title: ev.event.title,
      start: ev.event.start,
      end: ev.event.end,
      allDay: ev.event.allDay
    }
    const popover = await this.popoverController.create({
      event: ev,
      component: PopoverComponent,
      componentProps: {
        event: this.event,
        courseList: this.courses
      },
    });
    await popover.present();

    return popover.onDidDismiss().then(
      (data: any) => {
        let operation = data.data.operation;
        let event: ScheduleEvent = data.data.event;
        if (operation == "DELETE") {
          console.log('deletion')
          this.deleteSubscription = this.eventService.deleteEvent(+event.id).subscribe(
            () => ev.event.remove()
          );
        } else if (operation == 'UPDATE') {
          event.courseId = data.data.courseId;
          this.eventService.updateEvent(+event.id, event).subscribe(
            () => window.location.reload()
          )
        }
      });
  }

  ngOnDestroy() {
    this.eventList$.unsubscribe();
    this.deleteSubscription.unsubscribe();
  }
}
