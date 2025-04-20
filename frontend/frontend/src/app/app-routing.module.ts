import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminCategoriesComponent } from './admin-categories/admin-categories.component';
import { RouterModule,Routes } from '@angular/router';

const routes: Routes = [
  { path: 'categories', component: AdminCategoriesComponent }
];
@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes),
    CommonModule,
    
  ],
  exports:[RouterModule]
})
export class AppRoutingModule { }
