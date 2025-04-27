import { Category } from "./category.model";

export interface ProductImage {
    id: number;
    image_url: string;
  }

export interface Product{
    id: number;
    name: string;
    description: string;
    price: number;
    stock: number;
    categories: Category[];
    images: ProductImage[];
    }