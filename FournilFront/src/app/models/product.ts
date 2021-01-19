import { Format } from './format';
import { ImagesProduct } from './images-product';
import {PhotoProduct} from './photo-product';
import { ProductInCart } from './product-in-cart';

export class Product{

    private _id : number;
	private _productName : String;
	private _productSummary : String;
	private _productSpecification : String;
	private _productPerKgPrice : number;
	private _productComposition : String;
    private _limitStockProduct : number;
    private _photoProductSet: PhotoProduct[];
    private _formatSet:Format[];
    private _quantity:number;

	constructor(data:any) {
		this._id = data.id;
		this._productName = data.productName;
		this._productSummary = data.productSummary;
		this._productSpecification = data.productSpecification;
		this._productPerKgPrice = data.productPerKgPrice;
		this._productComposition = data.productComposition;
		this._limitStockProduct = data.limitStockProduct;
		this._photoProductSet = data.photoProductSet;
        this._formatSet = data.formatSet;
        this._quantity=data.quantity
	}  

    


    /**
     * Getter id
     * @return {number}
     */
	public get id(): number {
		return this._id;
	}

    /**
     * Getter productName
     * @return {String}
     */
	public get productName(): String {
		return this._productName;
	}

    /**
     * Getter productSummary
     * @return {String}
     */
	public get productSummary(): String {
		return this._productSummary;
	}

    /**
     * Getter productSpecification
     * @return {String}
     */
	public get productSpecification(): String {
		return this._productSpecification;
	}

    /**
     * Getter productPerKgPrice
     * @return {number}
     */
	public get productPerKgPrice(): number {
		return this._productPerKgPrice;
	}

    /**
     * Getter productComposition
     * @return {String}
     */
	public get productComposition(): String {
		return this._productComposition;
	}

    /**
     * Getter limitStockProduct
     * @return {number}
     */
	public get limitStockProduct(): number {
		return this._limitStockProduct;
	}

    /**
     * Getter photoProductSet
     * @return {PhotoProduct[]}
     */
	public get photoProductSet(): PhotoProduct[] {
		return this._photoProductSet;
	}

    /**
     * Getter formatSet
     * @return {Format[]}
     */
	public get formatSet(): Format[] {
		return this._formatSet;
	}


    /**
     * Setter id
     * @param {number} value
     */
	public set id(value: number) {
		this._id = value;
	}

    /**
     * Setter productName
     * @param {String} value
     */
	public set productName(value: String) {
		this._productName = value;
	}

    /**
     * Setter productSummary
     * @param {String} value
     */
	public set productSummary(value: String) {
		this._productSummary = value;
	}

    /**
     * Setter productSpecification
     * @param {String} value
     */
	public set productSpecification(value: String) {
		this._productSpecification = value;
	}

    /**
     * Setter productPerKgPrice
     * @param {number} value
     */
	public set productPerKgPrice(value: number) {
		this._productPerKgPrice = value;
	}

    /**
     * Setter productComposition
     * @param {String} value
     */
	public set productComposition(value: String) {
		this._productComposition = value;
	}

    /**
     * Setter limitStockProduct
     * @param {number} value
     */
	public set limitStockProduct(value: number) {
		this._limitStockProduct = value;
	}

    /**
     * Setter photoProductSet
     * @param {PhotoProduct[]} value
     */
	public set photoProductSet(value: PhotoProduct[]) {
		this._photoProductSet = value;
	}

    /**
     * Setter formatSet
     * @param {Format[]} value
     */
	public set formatSet(value: Format[]) {
		this._formatSet = value;
	}


    /**
     * Getter quantity
     * @return {number}
     */
	public get quantity(): number {
		return this._quantity;
	}

    /**
     * Setter quantity
     * @param {number} value
     */
	public set quantity(value: number) {
		this._quantity = value;
	}


   

}