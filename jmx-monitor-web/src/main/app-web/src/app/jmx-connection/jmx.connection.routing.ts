import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import {JmxConnectionComponent} from "./jmx.connection.component";

@NgModule({
  imports: [
    RouterModule.forChild([
      {path: "", component: JmxConnectionComponent},
    ])
  ],
  exports: [
    RouterModule
  ]
})

export class JmxConnectionRouting {}
