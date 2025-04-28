import { Component, OnInit } from '@angular/core';
import { SpinnerService } from '../services/spinner.service';
@Component({
  selector: 'app-spinner',
  templateUrl: './spinner.component.html',
  styleUrls: ['./spinner.component.sass']
})
export class SpinnerComponent implements OnInit {
  isLoading = false;

  constructor(private spinnerService: SpinnerService) {}

  ngOnInit(): void {
    this.spinnerService.isLoading$.subscribe((loading) => {
      this.isLoading = loading;
    });
  }
}
