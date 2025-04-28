import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatTableModule } from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AdminCategoriesComponent } from './admin-categories/admin-categories.component'; 
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { LoginComponent } from './login/login.component';
import { HomepageComponent } from './homepage/homepage.component';
import { DashboardComponent } from './admin/dashboard/dashboard.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ProductsComponent } from './admin/products/products.component';
import { CategoryDialogComponent } from './admin/category-dialog/category-dialog.component';
import { CategoryPageComponent } from './category-page/category-page.component';
import { SpinnerComponent } from './spinner/spinner.component';
import { ViewProductComponent } from './view-product/view-product.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminCategoriesComponent,
    LoginComponent,
    HomepageComponent,
    DashboardComponent,
    NavbarComponent,
    ProductsComponent,
    CategoryDialogComponent,
    CategoryPageComponent,
    SpinnerComponent,
    ViewProductComponent
  ],
  imports: [
    BrowserModule,
    NoopAnimationsModule,
    MatTableModule,
    MatSortModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    MatInputModule,
    MatFormFieldModule,
    MatCardModule,
    MatButtonModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
