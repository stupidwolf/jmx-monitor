import { Component, Input } from '@angular/core';
import { UserService } from '../service/user.service';
@Component({
  selector: 'app-title',
  templateUrl: './title.component.html'
})
export class TitleComponent {
  @Input() subtitle = '';
  title = 'Jmx Monitor';
  user = '';

  constructor (userService: UserService) {
    this.user = userService.userName;
  }
}
