import {User} from "../user/user";

export interface Report {
  id: number;
  author: User;
  appointmentDate: Date;
  reportText: string;
  validated: string;
}
