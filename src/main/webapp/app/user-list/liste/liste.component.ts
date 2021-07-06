import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {User} from "../../shared/interface/User.interface";

@Component({
  selector: 'app-liste',
  templateUrl: './liste.component.html',
  styleUrls: ['./liste.component.scss'],
})
export class ListeComponent implements OnInit {

  @Input()
  public liste: User[];

  @Output()
  private selectedUser = new EventEmitter<number>();

  @Output()
  private deletedUser = new EventEmitter<number>();

  constructor() { }

  ngOnInit() {}

  selectUser(id: number) {
    this.selectedUser.emit(id);
  }

  deleteUser(id: number) {
    this.deletedUser.emit(id)
  }
}
