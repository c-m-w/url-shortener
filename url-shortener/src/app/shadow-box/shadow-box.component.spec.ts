import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShadowBoxComponent } from './shadow-box.component';

describe('ShadowBoxComponent', () => {
  let component: ShadowBoxComponent;
  let fixture: ComponentFixture<ShadowBoxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShadowBoxComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShadowBoxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
