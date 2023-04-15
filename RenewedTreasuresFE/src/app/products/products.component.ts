import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductService } from '../product.service';
import { Product } from './product';

@Component({
  selector: 'products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  [x: string]: any;
  product:Observable<Product[]>

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
    this.ngOnInit();
  }

}
