import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../models/product.model';
import { ProductsServiceService } from '../services/products.service';
import { SpinnerService } from '../services/spinner.service';

@Component({
  selector: 'app-category-page',
  templateUrl: './category-page.component.html',
  styleUrls: ['./category-page.component.sass']
})
export class CategoryPageComponent implements OnInit {
  
  products:Product[]=[];
  categoryName: string ='';

  constructor(private route: ActivatedRoute, private productService: ProductsServiceService, private spinnerService: SpinnerService) {}

  ngOnInit(): void {
    this.route.params.subscribe(params=>{
      
      this.categoryName = params['categoryName'];
      this.loadProducts();
      this.spinnerService.hide();
    });
    
}


loadProducts():void{
this.spinnerService.show();
  this.productService.getProductsByCategoryName(this.categoryName).subscribe({
    next: (data)=> {this.products = data},
    error: (err)=> {console.log("Error loading Category products",err); this.spinnerService.hide()},
    complete: ()=> {console.log("Category Loaded"); this.spinnerService.hide()}
    
  });
  
}



}
