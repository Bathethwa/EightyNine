import { Component, OnInit } from '@angular/core';
import { ProductsServiceService } from '../services/products.service';
import { Product } from '../models/product.model';
@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.sass']
})
export class HomepageComponent implements OnInit {

 products: Product[] =[]; 
 currentImageIndexes: number[] = [];
 activeImageIndex: { [productId: number]: number } = {};

constructor(private productService: ProductsServiceService){}

ngOnInit(): void {
   this.loadProducts();
}


loadProducts():void{ 
  this.productService.getAllProducts().subscribe({
    next: data => {this.products = data.slice(6,8);
    this.currentImageIndexes = new Array(this.products.length).fill(0);
    },
    
    error: error=> {console.log("reached error while loading homepage",error)},
    complete: ()=>{
        
      console.log("Home page loaded")}
  })
}

 prevImage(productId: number, imagesLength: number): void {
    if (this.activeImageIndex[productId] === 0) {
      this.activeImageIndex[productId] = imagesLength - 1;
    } else {
      this.activeImageIndex[productId]--;
    }
  }

  nextImage(productId: number, imagesLength: number): void {
    if (this.activeImageIndex[productId] === imagesLength - 1) {
      this.activeImageIndex[productId] = 0;
    } else {
      this.activeImageIndex[productId]++;
    }
  }


}
