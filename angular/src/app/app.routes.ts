import {Routes} from '@angular/router';
import {CarComponent} from './car/component/car.component';

export const routes: Routes = [


  {
    path: 'car',
    component: CarComponent,
    pathMatch: 'full',
  },


];
