import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {
  CalendarApi,
  CalendarOptions,
  DateSelectArg, EventAddArg,
  EventApi,
  EventChangeArg,
  EventClickArg, EventInput, EventRemoveArg,
  FullCalendarComponent
} from "@fullcalendar/angular";
import {createEventId, INITIAL_EVENTS} from "./event-utils";
import {CourseService} from "./service/course.service";
import {pipe, Subscription} from "rxjs";


@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.page.html',
  styleUrls: ['./schedule.page.scss'],
})
export class SchedulePage implements OnInit, OnDestroy {

  @ViewChild('fullCalendar') fullcalendar: FullCalendarComponent;

  courseList$: Subscription;

  courseList: any[];

  events: EventInput[] = [];

  calendarVisible = true;
  calendarOptions: CalendarOptions = {
    headerToolbar: {
      left: 'prev,next today',
      center: 'title',
      right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
    },
    initialView: 'timeGridWeek',
    //events: [],
    // initialEvents: INITIAL_EVENTS, // alternatively, use the `events` setting to fetch from a feed
    weekends: true,
    editable: true,
    selectable: true,
    selectMirror: true,
    dayMaxEvents: true,
    select: this.handleDateSelect.bind(this),
    eventClick: this.handleEventClick.bind(this),
    eventsSet: this.handleEvents.bind(this),
    eventAdd: this.handleEventAdd.bind(this),
    eventChange: this.handleEventChange.bind(this),
    eventRemove: this.handleEventRemove.bind(this)
  };
  currentEvents: EventApi[] = [];


  constructor(private courseService: CourseService) {
  }

  ngOnInit() {
    this.getCourseList();
    this.courseListToEvents(this.courseList);
    setTimeout(() => {
      this.fullcalendar.getApi().render()
    });
  }

  getCourseList() {
    this.courseList$ = this.courseService.getCourseList().subscribe(
      pipe((res: any) => this.courseList = res)
    );
  }

  courseListToEvents(courseList) {
    courseList.forEach(
      (course) => this.events.push(
        {
          id: course.id,
          title: course.designation,
          start: course.date + 'T09:00:00',
          end: course.date + 'T17:00:00',
        }
      )
    );
    this.calendarOptions.events = this.events;
  }

  handleCalendarToggle() {
    this.calendarVisible = !this.calendarVisible;
  }

  handleWeekendsToggle() {
    const {calendarOptions} = this;
    calendarOptions.weekends = !calendarOptions.weekends;
  }

  handleDateSelect(selectInfo: DateSelectArg) {
    const title = prompt('Please enter a new title for your event');
    const calendarApi = selectInfo.view.calendar;

    calendarApi.unselect(); // clear date selection

    if (title) {
      calendarApi.addEvent({
        id: createEventId(),
        title,
        start: selectInfo.startStr,
        end: selectInfo.endStr,
        allDay: selectInfo.allDay
      });
    }
  }

  handleEventClick(clickInfo: EventClickArg) {
    if (confirm(`Are you sure you want to delete the event '${clickInfo.event.title}'`)) {
      clickInfo.event.remove();
    }
  }

  handleEvents(events: EventApi[]) {
    this.currentEvents = events;
  }

  handleEventChange(changeInfo: EventChangeArg) {
    console.log(`update event ${changeInfo.event.title}`);
  }

  handleEventAdd(addInfo: EventAddArg) {
    console.log(`event created : ${addInfo.event.title}`);
  }

  handleEventRemove(removeInfo: EventRemoveArg) {
    console.log(`event deleted : ${removeInfo.event.title}`);
  }

  ngOnDestroy() {
    this.courseList$.unsubscribe();
  }
}
