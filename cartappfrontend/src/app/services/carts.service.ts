import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
// For error handling
import { catchError, map, tap } from 'rxjs/operators';
import { Cart } from '../models/cart';

@Injectable({
  providedIn: 'root'
})
export class CartsService {

  private apiServerURL: string = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  createCart(cart: Cart): Observable<Cart>{
    return this.http.post<Cart>(`${this.apiServerURL}/carts`, cart);
  }

  getCart(id: number): Observable<Cart> {
    return this.http.get<Cart>(`${this.apiServerURL}/carts/${id}`);
  }

  updateCart(id: number, cart: Cart): Observable<Cart> {
    return this.http.put<Cart>(`${this.apiServerURL}/carts/${id}`, cart);
  }

  deleteCart(id: number): Observable<Cart>{
    return this.http.delete<Cart>(`${this.apiServerURL}/carts/${id}`);
  }

  getCarts(): Observable<Cart[]> {
    return this.http.get<Cart[]>(`${this.apiServerURL}/carts`);
  }

  addItemToCart(cartId: number, itemId: number): Observable<Cart> {
    return this.http.post<Cart>(`${this.apiServerURL}/carts/${cartId}/items/${itemId}/add`, null);
  }

  removeItemFromCart(cartId: number, itemId: number): Observable<Cart>{
    return this.http.delete<Cart>(`${this.apiServerURL}/carts/${cartId}/items/${itemId}/remove`);
  }

}
