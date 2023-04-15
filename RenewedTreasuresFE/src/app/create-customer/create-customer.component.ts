import { Component, OnInit } from '@angular/core';
import { CustomerserviceService } from '../customerservice.service';
import { CreateCustomer } from './create-customer';

@Component({
  selector: 'registerCustomer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  addcustomer: CreateCustomer = new CreateCustomer();

  constructor(private customerservice:CustomerserviceService) { }

  ngOnInit() {
  }

  addCustomers(){
    this.customerservice.addCustomer(this.addcustomer).subscribe(data => console.log(data),
    error => console.log(error));
    alert("Registration Successful")
  }

  onSubmit(){
    console.log("Inside on Submit")
    this.addCustomers();
  }


}
