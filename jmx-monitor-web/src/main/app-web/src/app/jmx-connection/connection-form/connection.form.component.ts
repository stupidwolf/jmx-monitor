import {Component, EventEmitter, Input, Output} from "@angular/core";
import { JmxConnectionModel } from "../model/jmx.connection.model";
import {JmxConnectionService} from "../service/jmx.connection.service";
import {JmxConnectionMsgModel} from "../model/jmx.connection.msg.model";
import {ToastrService} from "ngx-toastr";
import {JmxToastService} from "../../jmx-toast/jmx.toast.service";

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
  jmxConnectionModel: JmxConnectionModel = new JmxConnectionModel('', '', '');

  constructor (private jmxConnectionService: JmxConnectionService, private jmxToastService: JmxToastService) {
  }

  connectionJmx(): void {
    this.jmxConnectionService.jmxConnect(this.jmxConnectionModel)
      .then(data => {
        this.onJmxConnect.emit(data);
      });

  }

  //TODO
  jmxConnectTest(): void {
    this.jmxToastService.info('jmx 连接测试成功', null );
}
}
