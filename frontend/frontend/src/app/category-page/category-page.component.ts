import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CategoryService } from '../services/category.service';
import { Category } from '../models/category.model';

@Component({
  selector: 'app-category-page',
  templateUrl: './category-page.component.html',
  styleUrls: ['./category-page.component.sass']
})
export class CategoryPageComponent implements OnInit {
  
  categoryProducts:Category[]=[];
  categoryName: string ='';

  constructor(private route: ActivatedRoute, private categoryService: CategoryService) {}

  ngOnInit(): void {
    this.categoryName = this.route.snapshot.paramMap.get('categoryName')||'';
    
}

loadProducts():void{

  
}

}
