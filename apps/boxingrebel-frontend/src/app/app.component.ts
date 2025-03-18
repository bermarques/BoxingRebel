import { Component, inject, OnInit, PLATFORM_ID } from '@angular/core';
import { RouterModule } from '@angular/router';
import {
  FaConfig,
  FaIconComponent,
  FaIconLibrary,
} from '@fortawesome/angular-fontawesome';
import { fontAwesomeIcons } from './shared/font-awesome-icons';
import { NavbarComponent } from './layout/navbar/navbar.component';
import { FooterComponent } from './layout/footer/footer.component';
import { Oauth2Service } from './auth/oauth2.service';
import { CommonModule, isPlatformBrowser } from '@angular/common';
import { ToastService } from './shared/toast/toast.service';

@Component({
  imports: [
    RouterModule,
    FaIconComponent,
    NavbarComponent,
    FooterComponent,
    CommonModule,
  ],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent implements OnInit {
  private faIconLibrary = inject(FaIconLibrary);
  private faConfig = inject(FaConfig);
  private oauth2service = inject(Oauth2Service);

  toastService = inject(ToastService);
  platformId = inject(PLATFORM_ID);

  ngOnInit(): void {
    this.initFontAwesome();
    this.toastService.show('hello toast', 'SUCCESS');
  }

  constructor() {
    if (isPlatformBrowser(this.platformId)) {
      this.oauth2service.initAuthentication();
    }
    this.oauth2service.connectUserQuery = this.oauth2service.fetch();
  }
  private initFontAwesome() {
    this.faConfig.defaultPrefix = 'far';
    this.faIconLibrary.addIcons(...fontAwesomeIcons);
  }
}
