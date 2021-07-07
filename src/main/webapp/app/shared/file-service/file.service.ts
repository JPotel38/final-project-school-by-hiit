import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {FileInterface} from "./File.interface";
import {IonDatetime} from "@ionic/angular";

@Injectable({
  providedIn: 'root'
})
export class FileService {

  constructor(public readonly httpClient: HttpClient) { }

  getFileList(): Observable<FileInterface[]>{
    return this.httpClient.get<FileInterface[]>(`/api/files/`);
  }

  getFileListByCourse(courseId : number): Observable<FileInterface[]>{
    return this.httpClient.get<FileInterface[]>(`/api/files/course/${courseId}`);
  }

  getFileDetail(fileId: number): Observable<FileInterface>{
    return this.httpClient.get<FileInterface>(`/api/files/${fileId}`);
  }

  createFile(file: {designation: any; creationDate: any; link: string; course:{ id: any}}){
    return this.httpClient.post(`/api/files/`, file, {observe: "response"});
  }

  updateFile(fileId: number, designation: string, creationDate: IonDatetime, link: string, course: { id: any}){
    return this.httpClient.put(`/api/files/${fileId}`,
      {
        designation: designation,
        creationDate: creationDate,
        link: link,
        course: course
      },
      {observe: "response"});
  }

  deleteFile(fileId: number): Observable<any>{
    return this.httpClient.delete(`/api/files/${fileId}`,{observe: "response"});
  }


}
