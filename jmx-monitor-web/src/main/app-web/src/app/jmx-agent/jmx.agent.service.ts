import {Injectable} from "@angular/core";
import 'rxjs/add/operator/toPromise';
import {Http} from "@angular/http";
import {JmxAgentModel} from "./jmx.agent.model";

@Injectable()

export class JmxAgentService {
  private getObjectNamesUrl = "/jmx/agent/objectNames";

  constructor (private http: Http) {

  }
  public getObjectNames(filter : string): Promise<JmxAgentModel> {
    let params = {};
    if (filter) {
      params["filter"] = filter;
    }
    // params.set('filter', filter);

    return this.http.get(`${this.getObjectNamesUrl}`, {
      params: params
    })
      .toPromise()
      .then(response => {
        return response.json() as JmxAgentModel;
      })
    ;
  }
}
