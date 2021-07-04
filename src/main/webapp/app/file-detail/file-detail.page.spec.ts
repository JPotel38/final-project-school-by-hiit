import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { FileDetailPage } from './file-detail.page';

describe('FileDetailPage', () => {
  let component: FileDetailPage;
  let fixture: ComponentFixture<FileDetailPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FileDetailPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(FileDetailPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
