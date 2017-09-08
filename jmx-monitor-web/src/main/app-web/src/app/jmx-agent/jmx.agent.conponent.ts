import { Component, OnInit } from "@angular/core";
import {JmxAgentService} from "./jmx.agent.service";
import {JmxAgentModel} from "./jmx.agent.model";

@Component({
  selector: "app-jmx-agent",
  templateUrl: "jmx.agent.component.html",
  styleUrls: [
    "jmx.agent.component.css"
  ]
})

export class JmxAgentComponent implements OnInit {
  agentModel: JmxAgentModel;

  constructor (private agentService: JmxAgentService) {

  }
  ngOnInit(): void {
      this.agentService.getObjectNames(null)
      .then(data => {
        this.agentModel = data;
      })
    ;
  }
}
