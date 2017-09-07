import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
// import {ContactModule} from "../contact/contact.module";

import { AppRoutingModule } from "./app.routing.module"
import { CoreModule } from "../core/core.module";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
// import {NgbModule} from "@ng-bootstrap/ng-bootstrap";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    // ContactModule,
    AppRoutingModule,
    CoreModule,
    NgbModule,
  ],
  providers: [
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
