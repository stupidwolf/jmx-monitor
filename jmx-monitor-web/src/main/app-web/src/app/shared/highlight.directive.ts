import { Directive, ElementRef} from '@angular/core';

@Directive({ selector: '[highlight]' })

export class HighlightDirective {
  constructor (el: ElementRef) {
    el.nativeElement.style.backgroundColor = 'powderblue';
    console.log(
      `* AppRoot highlight called for
      ${el.nativeElement.tagName}`
    );
  }
}
