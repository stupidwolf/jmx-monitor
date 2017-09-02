import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { CrisisComponent } from "./crisis.component";
import { CrisisRoutingModule } from "./crisis.routing.module";

@NgModule({
  imports: [
    CommonModule,
    CrisisRoutingModule
  ],
  declarations: [
    CrisisComponent
  ],
})

export class CrisisModule { }
