import {Component, ViewChild} from "@angular/core";
import {JmxConnectionMsgModel} from "./model/jmx.connection.msg.model";
import {ConnectionMsgComponent} from "./connection-msg/connection.msg.component";

// import { ConnectionFormComponent } from "./connection-form/connection-form-component";

@Component({
  selector: 'app-jmx-connection',
  templateUrl: "./jmx.connection.component.html",
  styleUrls: [
    './jmx.connection.component.css'
  ]
})

export class JmxConnectionComponent {
  @ViewChild(ConnectionMsgComponent)
  private connectionMsgComponent: ConnectionMsgComponent;

  //TODO display connection msg in connection-msg component
  onJmxConnect(jmxConnectionMsg: JmxConnectionMsgModel) {
    // console.log(jmxConnectionMsg);
    this.connectionMsgComponent.connectionMsg = jmxConnectionMsg;
  }
}
