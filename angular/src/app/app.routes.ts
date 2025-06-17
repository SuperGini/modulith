import {Routes} from '@angular/router';
import {CarComponent} from './car/component/CarComponent';
import {OrderComponent} from './order/component/OrderComponent';

export const routes: Routes = [


  {
    path: 'car',
    component: CarComponent,
    pathMatch: 'full',
  },

  {
    path: 'order',
    component: OrderComponent,
    pathMatch: 'full',
  }


];
