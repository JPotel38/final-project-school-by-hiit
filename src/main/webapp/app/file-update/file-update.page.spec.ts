import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { FileUpdatePage } from './file-update.page';

describe('FileUpdatePage', () => {
  let component: FileUpdatePage;
  let fixture: ComponentFixture<FileUpdatePage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FileUpdatePage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(FileUpdatePage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
