import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerserviceService } from '../customerservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  model: any = {}
  getValue: boolean

  constructor(private customerService:CustomerserviceService,
    private router: Router) { }

  ngOnInit() {
  }

  loginUser(){
    console.log("in side login")
    var username = this.model.username;
    var password = this.model.password;


    this.customerService.getCustomerDetails(username,password).subscribe
    ((res: boolean) =>{
      this.getValue = res;

      if(this.getValue == true)
      {
        this.router.navigate(["/home/"]);
      }
      else{
        alert(" Invalid")
      }
    })
  }

}
