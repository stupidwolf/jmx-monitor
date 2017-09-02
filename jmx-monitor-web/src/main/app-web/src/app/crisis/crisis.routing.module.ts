import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { CrisisComponent } from "./crisis.component";

@NgModule({
  imports: [
    RouterModule.forChild([
      { path: '', component: CrisisComponent },
    ])
  ],
  exports: [
    RouterModule
  ]
})

export class CrisisRoutingModule { }
