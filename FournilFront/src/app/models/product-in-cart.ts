import { Frequence } from './frequence';
import { Product } from './product';

export class ProductInCart {

    private _id: number;
    private _product: Product;
    private _quantity: number;
    private _frequence: Frequence;
    private _TotalPricePerProduct: number;


	constructor(id: number, product: Product, quantity: number, frequence: Frequence, TotalPricePerProduct: number) {
		this._id = id;
		this._product = product;
		this._quantity = quantity;
		this._frequence = frequence;
		this._TotalPricePerProduct = TotalPricePerProduct;
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
     * Getter frequence
     * @return {Frequence}
     */
	public get frequence(): Frequence {
		return this._frequence;
	}

    /**
     * Getter TotalPricePerProduct
     * @return {number}
     */
	public get TotalPricePerProduct(): number {
		return this._TotalPricePerProduct;
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
     * Setter frequence
     * @param {Frequence} value
     */
	public set frequence(value: Frequence) {
		this._frequence = value;
	}

    /**
     * Setter TotalPricePerProduct
     * @param {number} value
     */
	public set TotalPricePerProduct(value: number) {
		this._TotalPricePerProduct = value;
	}




}

