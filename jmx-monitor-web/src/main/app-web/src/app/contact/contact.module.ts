import {NgModule} from "@angular/core";
import {ShareModule} from "../shared/share.module";
import {ContactComponent} from "./contact.component";
import {ContactService} from "./contact.service";
import {ContactRoutingModule} from "./contact.routing.module";

@NgModule({
  imports: [ ShareModule, ContactRoutingModule ],
  declarations:[
    ContactComponent,
  ],
  exports: [
    // ContactComponent,
  ],
  providers: [
    ContactService,
  ]
})

export class ContactModule { }
