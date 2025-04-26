import { Category } from "./category.model";

export interface Product{
    id: number;
    name: string;
    description: string;
    price: DoubleRange;
    stock: number;
    categories: Category[];
    }