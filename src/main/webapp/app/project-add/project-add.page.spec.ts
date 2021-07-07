import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ProjectAddPage } from './project-add.page';

describe('ProjectAddPage', () => {
  let component: ProjectAddPage;
  let fixture: ComponentFixture<ProjectAddPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectAddPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ProjectAddPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
