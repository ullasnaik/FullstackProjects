import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Contact } from '../models/Contact';
@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  // form conatins the name of the Contact and mobile number
  form: any = {};
// contacts is to store all Contacts data
contacts: Contact[] = [];
// message is to display message
message;

// isContactedAdded is for validating contact is added or not
isContactedAdded;
constructor(private userservice: UserService) {}
// Call UserService and use getAllContacts method to get Contacts data
  ngOnInit() {
    this.userservice.getAllContacts().subscribe(
      data => {
        this.contacts = data;
      });
  }
  // Write logic to add a Contact by using addContact method of UserService
  // Display message 'Contact already exists' if already a contact exists with same mobile number
  // Display message 'Failed to add Contact' while error handling
  // Display message 'Contact Added' if contact is added
  onSubmit() {
  }
}
