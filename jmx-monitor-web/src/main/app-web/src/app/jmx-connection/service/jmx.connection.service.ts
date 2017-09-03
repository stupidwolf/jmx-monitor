import {Injectable} from "@angular/core";
import {JmxConnectionModel} from "../model/jmx.connection.model";
import 'rxjs/add/operator/toPromise';
import {Http} from "@angular/http";
import {JmxConnectionMsgModel} from "../model/jmx.connection.msg.model";

@Injectable()
export class JmxConnectionService {
  private testConnectionUrl = "/jmx/connection/test";
  private connectionUrl = '/jmx/connection';

  constructor (private http: Http) {

  }

  public testJmxConnection(jmxConnection: JmxConnectionModel): Promise<JmxConnectionMsgModel> {
    return this.http.get(this.testConnectionUrl)
      .toPromise()
      .then(response => response.json().data as JmxConnectionMsgModel)
      .catch(JmxConnectionService.handleError);
  }

  public jmxConnect(jmxConnection: JmxConnectionModel): Promise<JmxConnectionMsgModel>{
    return this.http.post(this.connectionUrl, jmxConnection)
      .toPromise()
      .then( response => {
        return response.json() as JmxConnectionMsgModel
      })
      .catch(JmxConnectionService.handleError);
  }

  private static handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
