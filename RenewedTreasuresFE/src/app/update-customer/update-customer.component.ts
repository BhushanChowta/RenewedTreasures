import { Component, OnInit } from '@angular/core';
import { CustomerserviceService } from '../customerservice.service';
import { Updatecustomer } from './updatecustomer';

@Component({
  selector: 'updatecustomer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {

  updatecustomer: Updatecustomer = new Updatecustomer();

  constructor(private customerservice:CustomerserviceService) { }

  ngOnInit() {
  }

  updateCustomer(){
    this.customerservice.updateCustomer(this.updatecustomer).subscribe(data => console.log(data),
    error => console.log(error));
    this.updatecustomer = new Updatecustomer();
    alert("Update Successful")
  }

  onSubmit(){
    console.log("Inside on Submit")
    this.updateCustomer();
  }

}
