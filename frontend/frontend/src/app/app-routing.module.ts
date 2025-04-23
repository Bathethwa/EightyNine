import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminCategoriesComponent } from './admin-categories/admin-categories.component';
import { RouterModule,Routes } from '@angular/router';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './admin/dashboard/dashboard.component';
const routes: Routes = [
  { path: 'categories', component: AdminCategoriesComponent },
  {path: "home", component:HomepageComponent},
  {path:"login",component:LoginComponent},
  {path:"dashboard",component:DashboardComponent},

];
@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes),
    CommonModule,
    
  ],
  exports:[RouterModule]
})
export class AppRoutingModule { }

