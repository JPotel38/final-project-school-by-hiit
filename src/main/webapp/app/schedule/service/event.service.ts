import {Injectable} from '@angular/core';
import {Observable, of} from "rxjs";
import {ScheduleEvent} from "../model/event.interface";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {map, tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class EventService {

  private RESOURCE_URL = '/api/events/';

  constructor(private readonly http: HttpClient) {
  }

  getEventList(): Observable<ScheduleEvent[]> {
    return this.http.get<ScheduleEvent[]>(`${this.RESOURCE_URL}`);
  }

  createEvent(event: ScheduleEvent): Observable<ScheduleEvent> {
    return this.http.post<ScheduleEvent>(`${this.RESOURCE_URL}`, event);
  }

  deleteEvent(id: number) {
    return this.http.delete(`${this.RESOURCE_URL}${id}/`)
  }

  updateEvent(id:number, event: ScheduleEvent){
    return this.http.put(`${this.RESOURCE_URL}${id}/`, event);
  }

}
