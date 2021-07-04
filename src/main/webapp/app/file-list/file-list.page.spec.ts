import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { FileListPage } from './file-list.page';

describe('FileListPage', () => {
  let component: FileListPage;
  let fixture: ComponentFixture<FileListPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FileListPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(FileListPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
