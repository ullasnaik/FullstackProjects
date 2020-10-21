import { Injectable } from '@angular/core';
import { getLocaleDateFormat } from '@angular/common';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class DataService {
   private rest_api="http://localhost:8080/get";
     constructor(private http:HttpClient) { 
    }

   getEmployee(): Observable<any>{
    return this.http.get(this.rest_api);
   }

    
}
