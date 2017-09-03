import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { AwesomePipe } from "./awesome.pipe";
import { HighlightDirective } from "./highlight.directive";
import { FormsModule } from "@angular/forms";
import {HttpModule} from "@angular/http";

@NgModule({
  imports: [
    CommonModule,
    HttpModule,
  ],
  declarations: [
    AwesomePipe,
    HighlightDirective
  ],
  exports: [
    AwesomePipe,
    HighlightDirective,
    CommonModule,
    FormsModule,
  ]
})

/**
 * shared module
 */
export class ShareModule { }
