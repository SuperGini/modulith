import {Component, inject} from '@angular/core';
import {OrderService} from '../service/OrderService';

@Component({
    selector: 'order-component',
    templateUrl: './order.html',
    styleUrl: './order.scss'
})
export class OrderComponent {

    protected orderService = inject(OrderService);


    getAllOrders(customerId: number) {
        this.orderService.getAllOrders(customerId).subscribe((orders) => {


        });
    }


}
