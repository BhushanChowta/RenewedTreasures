import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { AdminComponent } from './admin/admin.component';
import { ContactComponent } from './contact/contact.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PaymentComponent } from './payment/payment.component';
import { RemoveProductComponent } from './remove-product/remove-product.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { UpdateProductComponent } from './update-product/update-product.component';

const routes: Routes = [
  {path: "", component: LoginComponent},
  {path: "home", component: HomeComponent},
  {path: "register", component: CreateCustomerComponent},
  {path: "updatecustomer", component: UpdateCustomerComponent},
  {path: "insertproduct", component: CreateProductComponent},
  {path: "admin", component: AdminComponent},
  {path: "removeproduct", component: RemoveProductComponent},
  {path: "updateproduct", component: UpdateProductComponent},
  {path: "about", component: AboutComponent},
  {path: "contact", component: ContactComponent},
  {path: "payment", component: PaymentComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
