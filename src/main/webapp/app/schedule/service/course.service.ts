import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor() { }

  getCourseList(): Observable<any> {
    return of([
      {
        id: 1,
        designation: 'Kubernetes',
        date: '2021-07-02',
        files: []
      },
      {
        id: 2,
        designation: 'Fil rouge',
        date: '2021-07-01',
        files: []
      },
    ])
  }
}
