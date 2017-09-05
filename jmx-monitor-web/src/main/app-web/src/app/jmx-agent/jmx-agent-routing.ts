import {RouterModule} from "@angular/router";
import {NgModule} from "@angular/core";
import {JmxAgentComponent} from "./jmx.agent.conponent";

@NgModule({
  imports: [
    RouterModule.forChild([
      {path:"", component: JmxAgentComponent}
    ])
  ],
  exports: [
    RouterModule,
  ]
})

export class JmxAgentRouting { }
