import { Product } from "./product.model";
import { user } from "./user.model";

export interface Cart{
    id: number;
    created_at:string;
    updated_at:string;
    isCheckedOut:boolean;
    user:user;
    cartItems:CartItems[];

}


export interface CartItems{
id: number;
product: Product;
quantity: number;

    
}