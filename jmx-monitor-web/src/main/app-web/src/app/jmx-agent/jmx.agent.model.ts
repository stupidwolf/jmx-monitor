export class JmxAgentModel {
  domainCount: string;

  objectNames: Array<DomainObjectNameMapModel>;

}

export class DomainObjectNameMapModel {
  domain: string;

  objectNames: Array<string>;
}
