import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product.model';
import { ProductsServiceService} from 'src/app/services/products.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.sass']
})
export class ProductsComponent implements OnInit {

  products:Product[]=[];

  constructor(private productService :ProductsServiceService){}

ngOnInit(): void {
 this.loadProducts();
}

loadProducts(): void{
  this.productService.getAllProducts().subscribe({
    next: products=> { this.products=products;},
    error: error=>{console.log("error fetching products",error)},
    complete: ()=>{console.log("Product loading complete")}
  });
}



}
