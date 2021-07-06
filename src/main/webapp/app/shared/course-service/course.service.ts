import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CourseInterface} from "./Course.interface";
import {Time} from "@angular/common";

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(public readonly httpClient: HttpClient) {
  }

  getCourseList(): Observable<CourseInterface[]> {
    return this.httpClient.get<CourseInterface[]>(`/api/courses/`);
  }

  getCourseDetail(courseId: number): Observable<CourseInterface> {
    return this.httpClient.get<CourseInterface>(`/api/courses/${courseId}`)
  }

  createCourse(course: { date: any; module: { id: any }; startTime: any; designation: any; endTime: any }) {
    return this.httpClient.post(`/api/courses/`, course, {observe: "response"});
  }

  updateCourse(courseId: number, designation: string, date: Date, startTime: Time, endTime: Time) {
    return this.httpClient.put(`/api/courses/${courseId}`,
      {
        designation: designation,
        date: date,
        startTime: startTime,
        endTime: endTime
      },
      {observe: "response"});
  }

  deleteCourse(courseId: number): Observable<any> {
    return this.httpClient.delete(`/api/courses/${courseId}`, {observe: "response"});
  }
}
