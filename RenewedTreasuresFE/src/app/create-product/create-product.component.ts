import { Component, OnInit } from '@angular/core';
import { CustomerserviceService } from '../customerservice.service';
import { CreateProduct } from './create-product';

@Component({
  selector: 'insertproduct',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {

  addproduct: CreateProduct = new CreateProduct();

  constructor(private customerservice:CustomerserviceService) { }
  
  ngOnInit() {
  }
  
  addCustomers(){
    this.customerservice.addProduct(this.addproduct).subscribe(data => console.log(data),
    error => console.log(error));
    alert("Product Added Successful")
  }
  
  onSubmit(){
    console.log("Inside on AddProduct Submit")
    this.addCustomers();
  }
  

}

