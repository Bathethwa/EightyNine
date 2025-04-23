import { Component } from '@angular/core';
import { user } from '../models/user.model';
import { AuthenticationServiceService } from '../services/authentication.service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.sass']
})


export class NavbarComponent {
  isOpen = false;
  user: user | null = null;
  
   constructor(private authService: AuthenticationServiceService){}

   ngOnInit(): void{

    this.user = this.authService.getUser();
   }

  

  toggleMenu(){
    this.isOpen = !this.isOpen;
  }
}
