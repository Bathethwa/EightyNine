import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Cart, CartItems } from '../models/cart.model';
import { CartService } from '../services/cart.service';
import { Product, ProductImage } from '../models/product.model';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.sass']
})
export class CartComponent implements OnInit {
  
   cart: Cart | undefined;
   items: CartItems[]=[];
   product: Product[]=[];
   images: ProductImage[]=[];

   id: number = 0;


   

   
  constructor(private route: ActivatedRoute, private cartService: CartService ){}
  ngOnInit(): void {
    
    this.route.params.subscribe((params)=>{
       this.id = params['id'];
       console.log(this.id);
       this.loadCart(this.id);
    })
  }


 loadCart(id:number): void{

   this.cartService.getCart(id).subscribe({
    next: (data)=> {this.cart = data;

      if (this.cart&& this.cart.cartItems){
        console.log(this.cart);
        this.items = this.cart.cartItems;
      }
    },
    error: (err)=> {console.log("Error while loading cart",err)},
    complete:()=>{console.log("loaded Cart")}
   });


 }


}
