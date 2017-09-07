import { NgModule } from "@angular/core";
import {JmxConnectionRouting} from "./jmx.connection.routing";
import {JmxConnectionComponent} from "./jmx.connection.component";
import {ConnectionFormComponent} from "./connection-form/connection.form.component";
import {ConnectionMsgComponent} from "./connection-msg/connection.msg.component";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {ShareModule} from "../shared/share.module";
import {JmxConnectionService} from "./service/jmx.connection.service";
import {JmxConnectionListComponent} from "./connection-list/jmx.connection.list.component";

@NgModule({
  imports: [
    JmxConnectionRouting,
    NgbModule,
    ShareModule,
  ],
  exports: [

  ],
  declarations: [
    JmxConnectionComponent,
    ConnectionFormComponent,
    ConnectionMsgComponent,
    JmxConnectionListComponent,
  ],
  providers: [
    JmxConnectionService,
  ]
})

export class JmxConnectionModule { }
