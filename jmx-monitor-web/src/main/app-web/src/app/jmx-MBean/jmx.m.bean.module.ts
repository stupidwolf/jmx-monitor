import { NgModule } from "@angular/core";
import {ShareModule} from "../shared/share.module";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {JmxMBeanComponent} from "./jmx.m.bean.component";
import {JmxMBeanRouting} from "./jmx.m.bean.routing";

@NgModule({
  imports: [
    ShareModule,
    NgbModule,
    JmxMBeanRouting,
  ],
  exports: [

  ],
  declarations: [
    JmxMBeanComponent
  ],
  providers: [

  ]
})

export class JmxMBeanModule { }
