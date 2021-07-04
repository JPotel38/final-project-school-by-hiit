import {IonDatetime} from "@ionic/angular";

export interface FileInterface {
  id?: number;
  designation: string;
  creationDate: IonDatetime;
  link: string;
}
