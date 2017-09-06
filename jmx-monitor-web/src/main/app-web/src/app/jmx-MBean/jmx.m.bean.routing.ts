import { RouterModule } from "@angular/router";
import {JmxMBeanComponent} from "./jmx.m.bean.component";
import {NgModule} from "@angular/core";

@NgModule({
  imports: [
    RouterModule.forChild([
      {path:"", component: JmxMBeanComponent}
    ])
  ],
  exports: [
    RouterModule,
  ]
})

export class JmxMBeanRouting { }
