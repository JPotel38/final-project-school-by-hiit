import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { User } from 'src/main/webapp/app/shared/interface/user'

@Injectable({
  providedIn: 'root'
})
export class CreateUserService {

  constructor(
    public readonly httpClient: HttpClient) { }


  isCreated(user: User): Observable<any> {
    return this.httpClient.post(
//     'api/users/', user
 'api/users/', {
        firstName: "Eva",
        lastName: "Delp",
        birthDate: "2000-03-03",
        mail: "eva9@mail.fr",
        phoneNumber: "1234567890",
        password: "aa",
        roles: [
            {
                id: 3,
                name: "Professeur",
                privileges: []
            }
        ]
    }
    )
    }





}
