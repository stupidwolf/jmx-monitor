import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HighlightDirective } from './directive/highlight.directive';
import { TitleComponent } from './title.component';
import { UserService } from './service/user.service';
import {ContactModule} from "./contact/contact.module";

import { AppRoutingModule } from "./app.routing.module"

@NgModule({
  declarations: [
    AppComponent,
    HighlightDirective,
    TitleComponent,
  ],
  imports: [
    BrowserModule,
    ContactModule,
    AppRoutingModule,
  ],
  providers: [
    UserService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
