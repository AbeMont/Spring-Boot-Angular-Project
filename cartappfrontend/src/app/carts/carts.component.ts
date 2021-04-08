import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';



import { Cart } from '../models/cart';
import { CartsService } from './../services/carts.service';

@Component({
  selector: 'app-carts',
  templateUrl: './carts.component.html',
  styleUrls: ['./carts.component.css']
})
export class CartsComponent implements OnInit {

  carts?: Cart[];

  constructor(private cartService: CartsService ) { }

  ngOnInit(): void {
    this.getCarts();
    console.log(this.carts)
  }

  getCarts(): void {
    this.cartService.getCarts().subscribe(
      (response: Cart[]) => {
        console.log(response);
        this.carts = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  createCart(addForm: NgForm): void {
    console.log("Add Form");

    this.cartService.createCart(addForm.value).subscribe( response => this.carts.push(response) );

    document.getElementById('close-modal').click();
  } 

}
