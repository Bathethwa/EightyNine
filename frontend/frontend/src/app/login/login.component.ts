import { Component } from '@angular/core';
import { Router} from '@angular/router';
import {Roles} from '../models/roles.enum';

import {AuthenticationServiceService} from '../services/authentication.service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent {

email ="";
password="";
errorMessage="";

constructor(private authService: AuthenticationServiceService, private router:Router){}

onSubmit():void{
  this.authService.login(this.email,this.password).subscribe({
    
     next:(user)=>{
      console.log('Login successful!');
      if(user.role == Roles.ADMIN )
      {
        this.router.navigate(['/dashboard']);
      }else{
        this.router.navigate(['/home']);
      }

     },
     error:err =>{
        this.errorMessage = 'Invalid email or password';
        console.error('Login failed',err);
     }

  })

}


}
