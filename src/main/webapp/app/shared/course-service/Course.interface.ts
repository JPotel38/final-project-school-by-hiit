import {Time} from "@angular/common";

export interface CourseInterface {
  id?: number;
  designation: string;
  date: Date;
  startTime: Time;
  endTime: Time;
}
