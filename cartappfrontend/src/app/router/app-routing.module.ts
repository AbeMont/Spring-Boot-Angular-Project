import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartsComponent } from './../carts/carts.component';
import { ItemsComponent } from './../items/items.component';
import { DashboardComponent } from './../dashboard/dashboard.component';
import { CartComponent } from '../cart/cart.component';

const routes: Routes = [
  { path: '', redirectTo: "/dashboard", pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'carts', component: CartsComponent },
  { path: 'carts/:id', component: CartComponent },
  { path: 'items', component: ItemsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
