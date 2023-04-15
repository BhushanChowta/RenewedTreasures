import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Updateproduct } from './update-product';

@Component({
  selector: 'updateproduct',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  updateproduct: Updateproduct = new Updateproduct();

  constructor(private productservice:ProductService) { }

  ngOnInit() {
  }

  updateProduct(){
    this.productservice.updateProduct(this.updateproduct).subscribe(data => console.log(data),
    error => console.log(error));
    this.updateproduct = new Updateproduct();
    alert("Update Successful")
  }

  onSubmit(){
    console.log("Inside on Submit")
    this.updateProduct();
  }
}
