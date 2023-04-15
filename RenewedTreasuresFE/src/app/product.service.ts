import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private updateProductUrl = "http://localhost:8080/updateproduct";


  constructor(private http: HttpClient) { }

  getProducts(): Observable<any> {
    return this.http.get(`http://localhost:8080/products`);
  }  
  
  deleteProduct(id:any): Observable<any> {
    return this.http.delete(`http://localhost:8080/deleteproduct/`+id);
  }

  updateProduct(updateProduct: Object):Observable<Object>{
    return this.http.put(`${this.updateProductUrl}`,updateProduct);
  }

}
