import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationServiceService {

  private baseUrl = "http://localhost:8080/auth";
  constructor(private http: HttpClient) {}

  login(email:string,password:string):Observable<any>{
    return this.http.post(`${this.baseUrl}/login`,{email,password}).pipe(tap((response:any)=> {
      const token = response.token;
      if(token){
        localStorage.setItem('authToken',token);
      }
    })
  ); 
}


}
