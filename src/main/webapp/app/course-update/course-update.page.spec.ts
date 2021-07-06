import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { CourseUpdatePage } from './course-update.page';

describe('CourseUpdatePage', () => {
  let component: CourseUpdatePage;
  let fixture: ComponentFixture<CourseUpdatePage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseUpdatePage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(CourseUpdatePage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
