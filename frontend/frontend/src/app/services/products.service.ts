import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product.model';
@Injectable({
  providedIn: 'root'
})
export class ProductsServiceService {

  private baseUrl = "http://localhost:8080/api/Products";
  constructor(private http:HttpClient) {}

  getAllProducts(): Observable<Product[]>{
    return this.http.get<Product[]>(`${this.baseUrl}/getAllProducts`);
  }

  getProductById(id:number): Observable<Product>{
    return this.http.get<Product>(`${this.baseUrl}/${id}`)
  }

  createProduct(product: Product): Observable<any>{
    return this.http.post<any>(`${this.baseUrl}/createProduct`, product);
  }

  updateProduct(id:number, updatedProduct:Product):Observable<Product>{
    return this.http.put<Product>(`${this.baseUrl}/updateProduct/${id}`,updatedProduct);
  }
}
