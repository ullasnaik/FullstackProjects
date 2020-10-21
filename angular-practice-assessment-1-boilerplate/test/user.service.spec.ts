import { TestBed, inject } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { Contact } from 'src/app/models/Contact';
import { UserService } from '../src/app/services/user.service';

const contacts:Contact[] = [
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

describe('UserService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports:[HttpClientTestingModule],
    providers:[UserService]
  }));

  it('should be created', () => {
    const service: UserService = TestBed.get(UserService);
    expect(service).toBeTruthy();
  });

  // testing service for getAllContacts method
  it('getAllContacts() should fetch allcontacts',
  inject([HttpTestingController, UserService],
    (httpMock: HttpTestingController, service: UserService) => {
      // We call the service
      service.getAllContacts().subscribe(data => {
        expect(data.data.length).toBe(3);
        expect(data.data).toEqual(contacts);
      });
      // We set the expectations for the HttpClient mock
      const req = httpMock.expectOne('http://localhost:3000/contacts');
      expect(req.request.method).toEqual('GET');
      // Then we set the fake data to be returned by the mock
      req.flush({data:contacts });
      // httpMock.verify();
    })
);
  // testing service for add Contact method
  it('addContact() method should add contact',
  inject([HttpTestingController, UserService],
    (httpMock: HttpTestingController, service: UserService) => {
      let Contact:Contact={
        name:"test",
        mobile:88348344386,
      }
      // We call the service
      service.addContact(Contact).subscribe(data => {
        expect(data.data.length).toBe(3);
        expect(data.data).toEqual(contacts);
      });

      // We set the expectations for the HttpClient mock
      const req = httpMock.expectOne('http://localhost:3000/contacts');
      expect(req.request.method).toEqual('POST');
      // Then we set the fake data to be returned by the mock
      req.flush({data:contacts});
      // httpMock.verify();
      })
    ); 

    afterEach(inject([HttpTestingController], (httpMock: HttpTestingController) => {
      httpMock.verify();
    }));
});
