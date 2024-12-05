import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';


@Injectable({
    providedIn: 'root'
})

export class PersonService {
    constructor(
        private http: HttpClient,
    ) { }


  BaseURL = environment.WEB_API;


  PostAllpersonValues(data:any){
    return this.http.post(`${this.BaseURL}/person`,data);
  }

  GetAllpersonValues(){
    return this.http.get(`${this.BaseURL}/person`);
  }

  Updateperson(data:any){
    return this.http.put(`${this.BaseURL}/person/${data.id}`,data);
  }

  getSpecificperson(id:number){
    return this.http.get(`${this.BaseURL}/person/${id}`);
  }

  getSpecificpersonHistory(id:number){
    return this.http.get(`${this.BaseURL}/person/${id}/history?days=30`);
  }

  DeletepersonValues(dataId:any){
     return this.http.delete(`${this.BaseURL}/person/${dataId}`);
  }

  GetEntityById(personId:any): Observable<any> {
    return this.http.get(`${this.BaseURL}/personid/` + personId);
  }

  Searchperson(data:any): Observable<any> {
    const temp:any = [];
    const objectKeyPair = Object.entries(data);
    objectKeyPair.forEach((element, index) => {
    if (element[1]) {
    temp.push(`${element[0]}=${element[1]}`);
    }
    });
    let jwt_token = sessionStorage.getItem('JwtToken');
    return this.http.get(`${this.BaseURL}` + `/person/get/search?jwt_token=${jwt_token}${temp.length > 0 ? `&${temp.join('&')}` : ''}`);
  }
}