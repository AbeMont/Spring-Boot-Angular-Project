import { Component, Input, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

import { Cart } from '../models/cart';
import { Item } from '../models/item';
import { CartsService } from '../services/carts.service';
import { ItemsService } from '../services/items.service';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {

  constructor(
    private itemsService: ItemsService,
    private cartsService: CartsService
    ) { }

  items?: Item[];
  carts: Cart[];

  cart?: Cart;
  cartItems?: Item[];
  structured?: [];

  itemId: number;
  cartId: number;

  modalAction: string;
  imgString?: string;
  serialNumber?: number;

  ngOnInit(): void {
    this.getItems();
    console.log(this.items);
  }

  getItems(): void {

    this.itemsService.getItems().subscribe(response => {

      // this.items = response.sort((a, b) => {

      //   if (a.name < b.name) {return -1}
      //   if (a.name > b.name) {return 1}
      //   return 0;

      // });

      this.items = response;

      console.log(this.items);

    });

  }

  openModal(action: string, id: number): void {

    console.log(action);

    if (action === 'add'){
      
      this.modalAction = action;
      this.itemId = id;
      this.cartsService.getCarts().subscribe(carts => this.carts = carts);

    }

    if (action === 'view'){

      this.modalAction = action;
      this.cartId = id;
      this.getCart(this.cartId);

    }

    if (action === 'createItem'){
      this.modalAction = action;
    }

    
  }

  addItemToCart(cartId: number): void {
    console.log("Cart id: " + cartId, "Item id: " + this.itemId);

    // Once the subsciption is complete, we need getitems to update the items in the UI.
    this.cartsService.addItemToCart(cartId, this.itemId).subscribe( response => this.getItems());

    // Close Modal
    document.getElementById('close-modal').click();

  }

  getCart(id: number): void{
    this.cartsService.getCart(id).subscribe(response => {
      this.cart = response;
      this.cartItems = response.items;
    });
  } 

  removeItemFormCart(cartId: number, itemId: number): void {

    console.log("Cart Id: " + cartId, "Item Id: " + itemId);
    this.cartsService.removeItemFromCart(cartId, itemId).subscribe( response => {
      // update UI in the modal
      this.getCart(cartId);
      // update Ui of all items
      this.getItems();
    });

  }

  createItem(item: NgForm): void {
    console.log(item.value);
    this.itemsService.addItem(item.value).subscribe(response => {

      this.getItems();
      document.getElementById('close-modal').click();

    } );
  }

  productSelect(event):void {
    console.log(event.target.value);

    switch (event.target.value){

      case "Backpack": {
        this.imgString = "https://cdn.shopify.com/s/files/1/0533/2089/files/placeholder-images-product-1_large.png";
        this.serialNumber = 7894;
      }
      break;

      case "Shoe": {
        this.imgString = "https://cdn.shopify.com/s/files/1/0533/2089/files/placeholder-images-product-2_large.png";
        this.serialNumber = 1111;
      }
      break;

      case "Glasses": {
        this.imgString = "https://cdn.shopify.com/s/files/1/0533/2089/files/placeholder-images-product-3_large.png";
        this.serialNumber = 1597;
      }
      break;

      case "Cap": {
        this.imgString = "https://cdn.shopify.com/s/files/1/0533/2089/files/placeholder-images-product-4_large.png";
        this.serialNumber = 3491;
      }
      break;

      case "Watch": {
        this.imgString = "https://cdn.shopify.com/s/files/1/0533/2089/files/placeholder-images-product-5_large.png";
        this.serialNumber = 83598;
      }
      break;

      case "Lamp": {
        this.imgString = "https://cdn.shopify.com/s/files/1/0533/2089/files/placeholder-images-product-6_large.png";
        this.serialNumber = 8833;
      }

      default : {
        this.imgString = undefined;
      }

    }

  }

}
