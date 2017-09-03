import { Component, Input } from "@angular/core";
import { JmxConnectionModel } from "../model/jmx.connection.model";
import {JmxConnectionService} from "../service/jmx.connection.service";

@Component({
  selector: "app-jmx-connection-form",
  templateUrl: "connection.form.component.html",
  styleUrls: [
    "connection.form.css"
  ],
})

export class ConnectionFormComponent {
  jmxConnectionModel: JmxConnectionModel = new JmxConnectionModel('', '', '');

  constructor (private jmxConnectionService: JmxConnectionService) {

  }

  /*jmxConnectionModel: JmxConnectionModel = {
     mode: '',
     ipAddress: '',
     port: '',
     url:'',
 };*/

  connectionJmx(): void {
    console.log(this.jmxConnectionModel);
    this.jmxConnectionService.jmxConnect(this.jmxConnectionModel);
    // $();
  }
}
