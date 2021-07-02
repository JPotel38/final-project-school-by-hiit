export interface ScheduleEvent {
  id?: number;
  title: string;
  start: Date;
  end: Date;
  allDay: boolean;
  courseId: number;
}
