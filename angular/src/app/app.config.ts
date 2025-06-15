import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import {provideHttpClient} from '@angular/common/http';
import {BASE_PATH} from '@openapi-generator/car-module-openapi';
import {environment} from '../environments/environment';
//https://blog.logrocket.com/generating-openapi-api-clients-angular/   -- how to set BASE_PATH
export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideHttpClient(),
    { provide: BASE_PATH, useValue: environment.basePath } //depending on ng serve --configuration=whatever we change the base path in the openapi library for the http call to the server

  ]
};
