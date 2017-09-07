import { Injectable } from "@angular/core";
import {IndividualConfig, ToastrService} from "ngx-toastr";

@Injectable()
/**
 * 依赖于 toastrService
 */
export class JmxToastService {
  toastrConfig: IndividualConfig = {
    closeButton: true,
    timeOut: 3000
  };

  constructor (private toastrService: ToastrService) {
  }

  success(msg, title): void {
    this.toastrService.success(msg, title, this.toastrConfig);
  }

  info(msg, title): void {
    this.toastrService.info(msg, title, this.toastrConfig)
  }

  warning(msg, title): void{
    this.toastrService.warning(msg, title, this.toastrConfig)
  }

  error(msg, title): void {
    this.toastrService.error(msg, title, this.toastrConfig)
  }
}
