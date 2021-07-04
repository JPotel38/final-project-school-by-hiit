import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { FileCreationPage } from './file-creation.page';

describe('FileCreationPage', () => {
  let component: FileCreationPage;
  let fixture: ComponentFixture<FileCreationPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FileCreationPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(FileCreationPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
