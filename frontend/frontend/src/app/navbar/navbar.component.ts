import { Component, ElementRef, HostListener, ViewChild} from '@angular/core';
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

  
  
  

  womenDropdownOpen = false;
  menDropdownOpen = false;

  @ViewChild('womenButton') womenButtonRef!: ElementRef;
  @ViewChild('womenDropdown') womenDropdownRef!: ElementRef;
  @ViewChild('menButton') menButtonRef!: ElementRef;
  @ViewChild('menDropdown') menDropdownRef!: ElementRef;

  toggleWomenDropdown() {
    this.womenDropdownOpen = !this.womenDropdownOpen;
    this.menDropdownOpen = false; // Close the other dropdown
  }

  toggleMenDropdown() {
    this.menDropdownOpen = !this.menDropdownOpen;
    this.womenDropdownOpen = false; // Close the other dropdown
  }

  @HostListener('document:click', ['$event'])
  onDocumentClick(event: MouseEvent) {
    if (
      this.womenDropdownOpen &&
      !this.womenButtonRef.nativeElement.contains(event.target) &&
      !this.womenDropdownRef.nativeElement.contains(event.target)
    ) {
      this.womenDropdownOpen = false;
    }

    if (
      this.menDropdownOpen &&
      !this.menButtonRef.nativeElement.contains(event.target) &&
      !this.menDropdownRef.nativeElement.contains(event.target)
    ) {
      this.menDropdownOpen = false;
    }
  }
}
