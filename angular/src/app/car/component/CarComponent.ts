import {Component, inject} from '@angular/core';
import {CARService, ConstructorRequest} from '@openapi-generator/car-module-openapi';

@Component({
    selector: "car-component",
    templateUrl: "./car.html",
    styleUrl: "./car.scss",
    standalone: true
})
export class CarComponent {

    protected carService = inject(CARService);


    createManufacturer(carManufacturerName: string) {
        console.log(carManufacturerName);


        const constructorRequest: ConstructorRequest = {
            name: carManufacturerName
        }

        this.carService.createConstructor(constructorRequest, "body")
            .subscribe();

    }


}
