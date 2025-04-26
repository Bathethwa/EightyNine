import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CategoryService } from '../services/category.service';
import { Category } from '../models/category.model';
import { CategoryDialogComponent } from '../admin/category-dialog/category-dialog.component';

@Component({
  selector: 'app-admin-categories',
  templateUrl: './admin-categories.component.html',
  styleUrls: ['./admin-categories.component.sass']
})
export class AdminCategoriesComponent implements OnInit {
  categories: Category[] = [];
  displayedColumns: string[] = ['id', 'name', 'edit','delete'];

  constructor(private dialog: MatDialog,private categoryService: CategoryService) {}

  ngOnInit(): void {
    this.loadCategories();
  }


  loadCategories(): void{
    this.categoryService.getAllCategories().subscribe((data) => {
      this.categories = data;
    });
    
  }
  openCreateCategoryDialog() {
    const dialogRef = this.dialog.open(CategoryDialogComponent,{
      width:'400px',
      data: null
    });
  
    dialogRef.afterClosed().subscribe(categoryName => {
      
      if (categoryName) {
        const newCategory: Category = { id: 0, name: categoryName };
        this.categoryService.createCategory(newCategory).subscribe({
          next: () => {
            console.log('Category created!');
            this.loadCategories();
          },
          error: err => console.error('Error creating category:', err)
        });
      }
    });
  
}

openEditCategoryDialog(category: Category) {
  const dialogRef = this.dialog.open(CategoryDialogComponent, {
    width:'400px',
    data: { category }
  });

  dialogRef.afterClosed().subscribe(result => {
    if (result) {
      this.categoryService.updateCategory(result.id, result).subscribe(() => {
        console.log('Category updated!');
       this.loadCategories();
      });
    }
  });
}

}
