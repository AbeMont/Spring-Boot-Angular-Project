import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Item } from '../models/item';

@Injectable({
  providedIn: 'root'
})
export class ItemsService {

  constructor(private http: HttpClient) { }

  private apiServerURL: string = 'http://localhost:8080';

  addItem(item: Item): Observable<Item>{
    return this.http.post<Item>(`${this.apiServerURL}/items`, item);
  }

  getItems(): Observable<Item[]>{
    return this.http.get<Item[]>(`${this.apiServerURL}/items`);
  }

}
