export class Producto {

    id?: number;
    model: string;
    brand: string;
    stock: number;
    typeproduct: string;
    price: number;
    images0: string;
    images1: string;
    images2: string;
    images3: string;
    images4: string;
    descriptionproduct1: string;
    descriptionproduct2: string;
    capsule: string;
    materials: string;

    constructor(
        model: string,
        brand: string,
        stock: number,
        typeproduct: string,
        price: number,
        images0: string,
        images1: string,
        images2: string,
        images3: string,
        images4: string,
        descriptionproduct1: string,
        descriptionproduct2: string,
        capsule: string,
        materials: string,
    ) {
        this.model=model;
        this.brand=brand;
        this.stock=stock;
        this.typeproduct=typeproduct;
        this.price=price;
        this.images0=images0;
        this.images1=images1;
        this.images2=images2;
        this.images3=images3;
        this.images4=images4;
        this.descriptionproduct1=descriptionproduct1;
        this.descriptionproduct2=descriptionproduct2;
        this.capsule=capsule;
        this.materials=materials;
    }

}
