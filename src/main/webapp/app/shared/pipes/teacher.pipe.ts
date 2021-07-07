import { Pipe, PipeTransform } from '@angular/core';
import {User} from "../interface/User.interface";

@Pipe({
  name: 'teacher'
})
export class TeacherPipe implements PipeTransform {

  transform(users: Array<User>): Array<User> {
    if (!users) {
      return users;
    }
    return users.filter(
      user => {
        let roleNames= [];
        user.roles.forEach(
          role => roleNames.push(role.name)
        )
        return roleNames.includes('Teacher')
      }
    );
  }

}
