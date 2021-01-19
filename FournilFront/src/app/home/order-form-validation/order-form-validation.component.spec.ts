import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderFormValidationComponent } from './order-form-validation.component';

describe('OrderFormValidationComponent', () => {
  let component: OrderFormValidationComponent;
  let fixture: ComponentFixture<OrderFormValidationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrderFormValidationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderFormValidationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
