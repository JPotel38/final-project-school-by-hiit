import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { CourseCreationPage } from './course-creation.page';

describe('CourseCreationPage', () => {
  let component: CourseCreationPage;
  let fixture: ComponentFixture<CourseCreationPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseCreationPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(CourseCreationPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
