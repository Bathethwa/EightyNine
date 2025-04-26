import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Category } from 'src/app/models/category.model';
@Component({
  selector: 'app-category-dialog',
  templateUrl: './category-dialog.component.html',
  styleUrls: ['./category-dialog.component.sass']
})
export class CategoryDialogComponent {
  categoryName: string = '';
  isEditMode: boolean = false;


  constructor(private dialogRef: MatDialogRef<CategoryDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data:{category?: Category}
  ) {
    if(data?.category){
      this.isEditMode =true;
      this.categoryName = data.category.name;
    }
  }

  onCreate() {
    this.dialogRef.close(this.categoryName);
  }

  onSave(){
    const result: Category={
      id: this.data?.category?.id ?? 0,
      name: this.categoryName
    };
    this.dialogRef.close(result)
  }

  
  onCancel() {
    this.dialogRef.close();
  }

}
