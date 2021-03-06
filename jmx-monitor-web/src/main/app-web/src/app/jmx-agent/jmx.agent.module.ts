import {NgModule} from "@angular/core";
import {ShareModule} from "../shared/share.module";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {JmxAgentComponent} from "./jmx.agent.conponent";
import {JmxAgentRouting} from "./jmx-agent-routing";
import {JmxAgentService} from "./jmx.agent.service";

@NgModule({
  imports: [
    ShareModule,
    NgbModule,
    JmxAgentRouting,
  ],
  exports: [

  ],
  declarations: [
    JmxAgentComponent,
  ],
  providers: [
    JmxAgentService
  ]
})

export class JmxAgentModule { }
