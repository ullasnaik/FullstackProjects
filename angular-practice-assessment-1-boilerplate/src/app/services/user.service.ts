import { Injectable } from '@angular/core';
import { Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() {
  }

  // Implement addContacts method using HttpClient for a saving a Contacts details
  addContact(contact): Observable<any> {
  }

  // Implement getAllContactss method using HttpClient for getting all Contacts details
  getAllContacts(): Observable<any> {

  }
}
