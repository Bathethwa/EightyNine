import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cart } from '../models/cart.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private baseUrl = "http://localhost:8080/api/Cart";
  constructor(private http:HttpClient) {}

  getCart(userId:number): Observable<Cart>{
  let params = new HttpParams().set("userId",userId.toString());
  
    return this.http.get<Cart>(`${this.baseUrl}/getCart`,{params});
  }
}
 