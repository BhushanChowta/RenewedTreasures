import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductService } from '../product.service';
import { RemoveProduct } from './remove-product';

@Component({
  selector: 'app-remove-product',
  templateUrl: './remove-product.component.html',
  styleUrls: ['./remove-product.component.css']
})
export class RemoveProductComponent implements OnInit {
  [x: string]: any;
  product:Observable<RemoveProduct[]>

  constructor(private productservice: ProductService) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData(){
   this.product =  this.productservice.getProducts();
   console.log("test "+this.product)
  }

  deleteProductById(id:any)
  {
    this.productservice.deleteProduct(id).subscribe(data=>console.log(data),
    error=>console.log(error));
    alert("Product Deleted Successfully")
    this.ngOnInit();
  }

}
