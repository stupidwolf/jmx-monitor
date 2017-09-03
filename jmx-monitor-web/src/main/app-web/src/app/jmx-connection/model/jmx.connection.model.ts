export class JmxConnectionModel {
  /**
   * 连接方式
   */
  mode: string;

  /**
   * ip 地址
   */
  ipAddress: string;

  /**
   * 连接端口
   */
  port: string;

  /**
   * 连接 url
   */
  url: string;

  constructor (mode, ipAddress, port) {
    this.mode = mode;
    this.ipAddress = ipAddress;
    this.port = port;
  }

}
