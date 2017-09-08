import {Component, Input, OnInit} from "@angular/core";
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
  @Input() objectNameFilter : string;

  constructor (private agentService: JmxAgentService) {

  }
  ngOnInit(): void {
    this.objectNameFilter = "*:*";
    this.getObjectNames(null);
  }

  public getObjectNames(filter: string) {
    this.agentService.getObjectNames(filter)
      .then(data => this.agentModel = data)
    ;

  }
}
