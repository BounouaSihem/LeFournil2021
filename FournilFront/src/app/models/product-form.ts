import { Format } from "./format";


export class ProductForm {
private _quantity:Number;
private _formatChoosen:String;
private _frequencyCommandeProduct:String;

	constructor(quantity: Number, formatChoosen: String, frequencyCommandeProduct: String) {
		this._quantity = quantity;
		this._formatChoosen = formatChoosen;
		this._frequencyCommandeProduct = frequencyCommandeProduct;
	}

    /**
     * Getter quantity
     * @return {Number}
     */
	public get quantity(): Number {
		return this._quantity;
	}

    /**
     * Getter formatChoosen
     * @return {String}
     */
	public get formatChoosen(): String {
		return this._formatChoosen;
	}

    /**
     * Getter frequencyCommandeProduct
     * @return {String}
     */
	public get frequencyCommandeProduct(): String {
		return this._frequencyCommandeProduct;
	}

    /**
     * Setter quantity
     * @param {Number} value
     */
	public set quantity(value: Number) {
		this._quantity = value;
	}

    /**
     * Setter formatChoosen
     * @param {String} value
     */
	public set formatChoosen(value: String) {
		this._formatChoosen = value;
	}

    /**
     * Setter frequencyCommandeProduct
     * @param {String} value
     */
	public set frequencyCommandeProduct(value: String) {
		this._frequencyCommandeProduct = value;
	}



	////////////////    
}