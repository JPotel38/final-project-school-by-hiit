import {Time} from "@angular/common";
import {ModuleInterface} from "../module-service/Module.interface";

export interface CourseInterface {
  id?: number;
  designation: string;
  date: Date;
  startTime: Time;
  endTime: Time;
  module: ModuleInterface[];
}
