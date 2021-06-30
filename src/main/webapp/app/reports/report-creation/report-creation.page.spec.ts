import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ReportCreationPage } from './report-creation.page';

describe('ReportCreationPage', () => {
  let component: ReportCreationPage;
  let fixture: ComponentFixture<ReportCreationPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReportCreationPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ReportCreationPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
