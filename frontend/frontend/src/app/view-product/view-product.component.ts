import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductsServiceService } from '../services/products.service';
import { SpinnerService } from '../services/spinner.service';
import { Product } from '../models/product.model'; // adjust if needed
import { CartService } from '../services/cart.service'; // your cart service

@Component({
  selector: 'app-view-product',
  templateUrl: './view-product.component.html',
})
export class ViewProductComponent implements OnInit {
  product!: Product;
  id!: number;
  selectedImage: string | null = null;

  constructor(
    private route: ActivatedRoute,
    private productService: ProductsServiceService,
    private spinnerService: SpinnerService,
    private cartService: CartService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
      this.loadProduct(this.id);
    });
  }

  loadProduct(id: number): void {
    this.spinnerService.show();
    this.productService.getProductById(id).subscribe({
      next: (product) => {
        this.product = product;
        this.selectedImage = product.images.length > 0 ? product.images[0].image_url : null;
        this.spinnerService.hide();
      },
      error: (err) => {
        console.log('Error loading product', err);
        this.spinnerService.hide();
      },
    });
  }

  changeMainImage(imageUrl: string) {
    this.selectedImage = imageUrl;
  }

  addToCart() {
   // this.cartService.addProduct(this.product);
    alert('Product added to cart!');
  }
}
