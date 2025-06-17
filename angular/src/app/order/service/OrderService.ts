import {inject, Injectable} from '@angular/core';
import {GetOrderResponse, ORDERService} from '@openapi-generator/car-module-openapi';
import {ResponseType} from '../../../utility/responseType';
import {Observable} from 'rxjs';

@Injectable({providedIn: 'root'})
export class OrderService {


  protected orderInvoker = inject(ORDERService);


  getAllOrders(customerId: number): Observable<GetOrderResponse[]> {
    return this.orderInvoker.getAllOrders(customerId, ResponseType.BODY);
  }


}
