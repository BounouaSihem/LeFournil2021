import { Format } from './format';
import { Frequence } from './frequence';
import { Product } from './product';

export class ProductInCart {

    private _id: number;
    private _product: Product;
    private _quantity: number;
    private _format: Format;
    private _frequencyDeliveryType: Frequence; 
    private _totalPricePerProduct: number;




	constructor(id: number, product: Product, quantity: number, format: Format, frequencyDeliveryType: Frequence, totalPricePerProduct: number) {
		this._id = id;
		this._product = product;
		this._quantity = quantity;
		this._format = format;
		this._frequencyDeliveryType = frequencyDeliveryType;
		this._totalPricePerProduct = totalPricePerProduct;
	}

    /**
     * Getter id
     * @return {number}
     */
	public get id(): number {
		return this._id;
	}

    /**
     * Getter product
     * @return {Product}
     */
	public get product(): Product {
		return this._product;
	}

    /**
     * Getter quantity
     * @return {number}
     */
	public get quantity(): number {
		return this._quantity;
	}

    /**
     * Getter format
     * @return {Format}
     */
	public get format(): Format {
		return this._format;
	}

    /**
     * Getter frequencyDeliveryType
     * @return {Frequence}
     */
	public get frequencyDeliveryType(): Frequence {
		return this._frequencyDeliveryType;
	}

    /**
     * Getter totalPricePerProduct
     * @return {number}
     */
	public get totalPricePerProduct(): number {
		return this._totalPricePerProduct;
	}

    /**
     * Setter id
     * @param {number} value
     */
	public set id(value: number) {
		this._id = value;
	}

    /**
     * Setter product
     * @param {Product} value
     */
	public set product(value: Product) {
		this._product = value;
	}

    /**
     * Setter quantity
     * @param {number} value
     */
	public set quantity(value: number) {
		this._quantity = value;
	}

    /**
     * Setter format
     * @param {Format} value
     */
	public set format(value: Format) {
		this._format = value;
	}

    /**
     * Setter frequencyDeliveryType
     * @param {Frequence} value
     */
	public set frequencyDeliveryType(value: Frequence) {
		this._frequencyDeliveryType = value;
	}

    /**
     * Setter totalPricePerProduct
     * @param {number} value
     */
	public set totalPricePerProduct(value: number) {
		this._totalPricePerProduct = value;
	}
	


}

