import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { ContactRequest, ContactResponse } from '/home/axity/Documentos/CAP_Angular/AlbertoCamarillo/curso-angular/src/app/model/contacto.model';

@Component({
  selector: 'app-contacto',
  templateUrl: './contacto.component.html',
  styleUrls: ['./contacto.component.css']
})
export class ContactoComponent implements OnInit {
  formContact: FormGroup = this.formBuilder.group({});

  constructor(private formBuilder: FormBuilder) {
    this.formContact = this.formBuilder.group({
      username: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      message: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {
  }

  contact(): void {
    const username = this.formContact.get('username')?.value;
    const correo = this.formContact.get('correo')?.value;
    const message = this.formContact.get('message')?.value;


    const data = {
      username: username,
      correo: correo,
      message:message
    } as ContactRequest;

    console.log(data);
  
    // Servicio de login
  }
}

