import { NgModule} from "@angular/core";
import { CommonModule } from "@angular/common";
import { UserService } from "../service/user.service";
import { TitleComponent } from "./title.component";

import { Optional } from "@angular/core";
import { SkipSelf } from "@angular/core";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";

/**
 * 它们有一些只用于AppComponent的模板的一次性的组件（例如：加载动画、消息浮层和模态对话框等）
 * 我们不用在其它地方导入它们，因此没必要共享它们。 然而如果把它们留在根目录，还是显得太大、太乱了
 */

@NgModule({
  imports:[
    CommonModule,
    NgbModule.forRoot(),
  ],
  declarations: [
    TitleComponent,
  ],
  exports: [
    TitleComponent,
  ],
  providers: [
    UserService,
  ]
})

export class CoreModule {
  constructor (@Optional() @SkipSelf() parentModule: CoreModule) {
    if (parentModule) {
      throw new Error(
        "Core Module is already loaded. Import it in the AppModule only."
      );
    }
  }
}
