import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable, tap } from 'rxjs';
import { user } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationServiceService {

  private baseUrl = "http://localhost:8080/auth";
  private currentUser:user | null = null;
  constructor(private http: HttpClient) {
 
  }

  login(email:string,password:string):Observable<user>{
    return this.http.post<{token:string, user: user}>(`${this.baseUrl}/login`,{email,password})
    .pipe(
      tap(response => {
        localStorage.setItem('token', response.token);
        this.setUser(response.user); // Save user
      }),
      map(response => response.user)
    );
}

setUser(user:user){
  this.currentUser = user;
  localStorage.setItem("user", JSON.stringify(user));
}

getUser():user|null{

  if (this.currentUser) return this.currentUser;
  const stored = localStorage.getItem('user');
  if (stored) this.currentUser = JSON.parse(stored);
  return this.currentUser;

}
}
