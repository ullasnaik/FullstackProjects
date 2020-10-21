import { Component } from '@angular/core';
import { DataService } from './data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Demo';
  data:any;
  
  constructor(private dataService:DataService){}
  ngOnInit(){
    this.dataService.getEmployee().subscribe(
      
      data=>{
        this.data=data;
        console.log(this.data);
        
      }
    )
  }
}

