import { Commande } from './commande';
import { ProductInCart } from './product-in-cart';

export class ShoppingCart {

    private _id: number;
    private _commande: Commande;
    private _productInCartSet: ProductInCart[];
    private _totalPriceInCart: number;


	constructor(id: number, commande: Commande, productInCartSet: ProductInCart[], totalPriceInCart: number) {
		this._id = id;
		this._commande = commande;
		this._productInCartSet = productInCartSet;
		this._totalPriceInCart = totalPriceInCart;
	}

    /**
     * Getter id
     * @return {number}
     */
	public get id(): number {
		return this._id;
	}

    /**
     * Getter commande
     * @return {Commande}
     */
	public get commande(): Commande {
		return this._commande;
	}

    /**
     * Getter productInCartSet
     * @return {ProductInCart[]}
     */
	public get productInCartSet(): ProductInCart[] {
		return this._productInCartSet;
	}

    /**
     * Getter totalPriceInCart
     * @return {number}
     */
	public get totalPriceInCart(): number {
		return this._totalPriceInCart;
	}

    /**
     * Setter id
     * @param {number} value
     */
	public set id(value: number) {
		this._id = value;
	}

    /**
     * Setter commande
     * @param {Commande} value
     */
	public set commande(value: Commande) {
		this._commande = value;
	}

    /**
     * Setter productInCartSet
     * @param {ProductInCart[]} value
     */
	public set productInCartSet(value: ProductInCart[]) {
		this._productInCartSet = value;
	}

    /**
     * Setter totalPriceInCart
     * @param {number} value
     */
	public set totalPriceInCart(value: number) {
		this._totalPriceInCart = value;
	}


}