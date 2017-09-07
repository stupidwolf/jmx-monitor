import {Component, Input} from "@angular/core";
import {JmxConnectionMsgModel} from "../model/jmx.connection.msg.model";

@Component({
  selector: "app-jmx-connection-msg",
  templateUrl: "connection.msg.component.html",
  styleUrls: [
    "connection.msg.css"
  ]
})

export class  ConnectionMsgComponent {
  connectionMsg: JmxConnectionMsgModel;
}
