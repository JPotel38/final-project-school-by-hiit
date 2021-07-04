import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ModuleCreationPage } from './module-creation.page';

describe('ModuleCreationPage', () => {
  let component: ModuleCreationPage;
  let fixture: ComponentFixture<ModuleCreationPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModuleCreationPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ModuleCreationPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
