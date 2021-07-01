import { Pipe, PipeTransform } from '@angular/core';
import {User} from "../interfaces/user/user";

@Pipe({
  name: 'student'
})
export class StudentPipe implements PipeTransform {

  transform(users: Array<User>): Array<User> {
    if (!users) {
      return users;
    }
    return users.filter(user => user.roles[0].name === 'Etudiant');
  }
}
