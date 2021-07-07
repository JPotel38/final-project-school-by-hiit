import { Pipe, PipeTransform } from '@angular/core';
import {User} from "../interface/User.interface";

@Pipe({
  name: 'tutor'
})
export class TutorPipe implements PipeTransform {

  transform(users: Array<User>): Array<User> {
    if (!users) {
      return users;
    }
    return users.filter(user => user.roles[0].name === 'Tuteur');
  }

}
