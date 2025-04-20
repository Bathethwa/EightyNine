export interface Category{
    id: number;
    name: string;
    description: string;
    price: DoubleRange;
    stock: number;
    categories: Category[];
    }