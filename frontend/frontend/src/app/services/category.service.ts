import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { Category } from '../models/category.model';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private baseUrl = 'http://localhost:8080/api/categories'; //  backend URL

  constructor(private http: HttpClient) { }

  getAllCategories(): Observable<Category[]> {
    return this.http.get<Category[]>(`${this.baseUrl}/getcategories`);
  }

  getCategoryById(id:number):Observable<Category>{

    return this.http.get<Category>(`${this.baseUrl}/${id}`);
  }

  createCategory(category:Category):Observable<any>{
     return this.http.post<any>(`${this.baseUrl}/createcategory`,category)
  }

  updateCategory(id:number, updatedCategory:Category):Observable<any>{
    return this.http.put<Category>(`${this.baseUrl}/updateCategory/${id}`, updatedCategory)
  }




}
