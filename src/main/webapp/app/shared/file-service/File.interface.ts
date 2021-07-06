import {IonDatetime} from "@ionic/angular";
import {CourseInterface} from "../course-service/Course.interface";

export interface FileInterface {
  id?: number;
  designation: string;
  creationDate: IonDatetime;
  link: string;
  course: CourseInterface[];

}
