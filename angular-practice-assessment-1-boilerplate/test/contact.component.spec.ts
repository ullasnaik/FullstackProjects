import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { ContactComponent } from '../src/app/contact/contact.component';
import { UserService } from '../src/app/services/user.service';
import { HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { of } from 'rxjs';
import { SearchPipe } from 'src/app/pipe/search.pipe';
import { Contact } from 'src/app/models/Contact';

const contacts: Contact[] = [
  {
      name:"Ravi",
      mobile:1234567890
  },
  {
    name:"abc",
    mobile:9876543210
  },
  {
    name:"xyz",
    mobile:7834210723
  }
]

describe('ContactComponent', () => {
  let component: ContactComponent;
  let fixture: ComponentFixture<ContactComponent>;
  let userService:UserService;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpClientModule,FormsModule
      ],
      declarations: [ ContactComponent,SearchPipe ],
      providers:[UserService]
    })
    .compileComponents();
    userService = TestBed.get(UserService);
    spyOn(userService,'getAllContacts').and.returnValue(of(''));
    spyOn(userService,'addContact').and.returnValue(of(''));
  }));

  beforeEach(() => {

    fixture = TestBed.createComponent(ContactComponent);
    component = fixture.componentInstance;

    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // test to check onSubmit method existence
  it('onSubmit() should exists', () => {
    expect(component.onSubmit).toBeTruthy();
  });

  // test to check ngOnInit method existence
  it('ngOnInit() should exists', () => {
    expect(component.ngOnInit).toBeTruthy();
  });

  // test to check reloadPage method existence
  // it('reloadPage() should exists', () => {
  //   expect(component.reloadPage).toBeTruthy();
  // });

  // test to check getAllContacts is called in ngOnInit or not
  it('ngOnInit() should call UserService to getAllContacts ', () => {
    component.ngOnInit();
    expect(userService.getAllContacts).toHaveBeenCalled();
  });

  // test to check addContact is called in onSubmit or not
  it('onSubmit() should call UserService to add a Contact ', () => {
    component.contacts = contacts;
    component.form.name = 'test';
    component.form.mobile = '123456';

    component.onSubmit();
    expect(userService.addContact).toHaveBeenCalled();
    expect(component.message).toEqual('Contact added');
  });

  // test to check addContact is called in onSubmit or not
  it('onSubmit() should check for existing contact ', () => {
    component.contacts = contacts;
    component.form.name = 'test';
    component.form.mobile = 9876543210;
    component.onSubmit();
    expect(component.message).toEqual('Contact already exists');
  });
  
});
