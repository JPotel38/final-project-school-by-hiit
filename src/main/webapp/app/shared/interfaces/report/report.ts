import {User} from "../user/user";

export interface Report {
  id: number;
  prof: User;
  tutor: User;
  student: User;
  appointmentDate: Date;
  reportText: string;
  validated: string;
}
