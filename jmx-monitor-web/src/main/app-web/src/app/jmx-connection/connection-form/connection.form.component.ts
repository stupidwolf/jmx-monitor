import {Component, EventEmitter, Input, Output} from "@angular/core";
import { JmxConnectionModel } from "../model/jmx.connection.model";
import {JmxConnectionService} from "../service/jmx.connection.service";
import {JmxConnectionMsgModel} from "../model/jmx.connection.msg.model";

@Component({
  selector: "app-jmx-connection-form",
  templateUrl: "connection.form.component.html",
  styleUrls: [
    "connection.form.css"
  ],
})

export class ConnectionFormComponent {
  /**
   * 当jmx连接返回结果时，则出发本事件
   * @type {EventEmitter<JmxConnectionMsgModel>}
   */
  @Output() onJmxConnect = new EventEmitter<JmxConnectionMsgModel>();

  /*jmxConnectionModel: JmxConnectionModel = {
     mode: '',
     ipAddress: '',
     port: '',
     url:'',
 };*/

  jmxConnectionModel: JmxConnectionModel = new JmxConnectionModel('', '', '');

  constructor (private jmxConnectionService: JmxConnectionService) {
  }

  connectionJmx(): void {
    this.jmxConnectionService.jmxConnect(this.jmxConnectionModel)
      .then(data => {
        this.onJmxConnect.emit(data);
      });

  }
}
