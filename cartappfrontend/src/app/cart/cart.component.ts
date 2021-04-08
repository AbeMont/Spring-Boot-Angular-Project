import { Component, OnInit } from '@angular/core';
import { Cart } from '../models/cart';
import { CartsService } from '../services/carts.service';
import { NgForm } from '@angular/forms';

import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Item } from '../models/item';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cart: Cart;
  items?: Item[];

  modalAction: string;

  constructor(
    private cartService: CartsService, 
    private route: ActivatedRoute,
    private location: Location 
    ) { }

  ngOnInit(): void {

    this.getCart();

  }

  getCart(): void {

    const id = +this.route.snapshot.params.id;

    this.cartService.getCart(id).subscribe(cart =>{ 
      this.cart = cart;
      this.items = this.cart.items;
    });

  }

  openModal(action: string, id: number){
    this.modalAction = action;
    console.log("Modal Action: " + this.modalAction, "Cart id: " + id);
  }

  editCart(cartId: number, cart: NgForm): void {
    this.cartService.updateCart(cartId, cart.value).subscribe( response => this.cart = response );
    document.getElementById('closeModal').click();
  }

  deleteCart(cartId: number): void {
    this.cartService.deleteCart(cartId).subscribe(response => {
      document.getElementById('closeModal').click();
      this.location.back();
    } );
  }

  removeItemFromCart(cartId: number, itemId: number){
    this.cartService.removeItemFromCart(cartId,itemId).subscribe(response => {
      this.getCart();
    });
  }

}
