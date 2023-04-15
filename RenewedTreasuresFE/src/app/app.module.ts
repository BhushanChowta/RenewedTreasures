import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { SliderComponent } from './slider/slider.component';
import { ProductsComponent } from './products/products.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { AdminComponent } from './admin/admin.component';
import { RemoveProductComponent } from './remove-product/remove-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { PaymentComponent } from './payment/payment.component';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    HomeComponent,
    CreateCustomerComponent,
    SliderComponent,
    ProductsComponent,
    UpdateCustomerComponent,
    CreateProductComponent,
    AdminComponent,
    RemoveProductComponent,
    UpdateProductComponent,
    AboutComponent,
    ContactComponent,
    PaymentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
