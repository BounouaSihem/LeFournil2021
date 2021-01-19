import { Customer } from './customer';
import { DeliveryPointAdressAndDates } from './delivery-point-adress-and-dates';
import { ShoppingCart } from './shopping-cart';

export class Commande {

    private _id: number;
    private _customer: Customer;
    private _shoppingCart: ShoppingCart;
    private _dateCommande: Date;
    private _deliveryPointAdressandDates: DeliveryPointAdressAndDates;
    private _statutCommande: String[];



	constructor(id: number, customer: Customer, shoppingCart: ShoppingCart, dateCommande: Date, deliveryPointAdressandDates: DeliveryPointAdressAndDates, statutCommande: String[]) {
		this._id = id;
		this._customer = customer;
		this._shoppingCart = shoppingCart;
		this._dateCommande = dateCommande;
		this._deliveryPointAdressandDates = deliveryPointAdressandDates;
		this._statutCommande = statutCommande;
	}

    /**
     * Getter id
     * @return {number}
     */
	public get id(): number {
		return this._id;
	}

    /**
     * Getter customer
     * @return {Customer}
     */
	public get customer(): Customer {
		return this._customer;
	}

    /**
     * Getter shoppingCart
     * @return {ShoppingCart}
     */
	public get shoppingCart(): ShoppingCart {
		return this._shoppingCart;
	}

    /**
     * Getter dateCommande
     * @return {Date}
     */
	public get dateCommande(): Date {
		return this._dateCommande;
	}

    /**
     * Getter deliveryPointAdressandDates
     * @return {DeliveryPointAdressAndDates}
     */
	public get deliveryPointAdressandDates(): DeliveryPointAdressAndDates {
		return this._deliveryPointAdressandDates;
	}

    /**
     * Getter statutCommande
     * @return {String[]}
     */
	public get statutCommande(): String[] {
		return this._statutCommande;
	}

    /**
     * Setter id
     * @param {number} value
     */
	public set id(value: number) {
		this._id = value;
	}

    /**
     * Setter customer
     * @param {Customer} value
     */
	public set customer(value: Customer) {
		this._customer = value;
	}

    /**
     * Setter shoppingCart
     * @param {ShoppingCart} value
     */
	public set shoppingCart(value: ShoppingCart) {
		this._shoppingCart = value;
	}

    /**
     * Setter dateCommande
     * @param {Date} value
     */
	public set dateCommande(value: Date) {
		this._dateCommande = value;
	}

    /**
     * Setter deliveryPointAdressandDates
     * @param {DeliveryPointAdressAndDates} value
     */
	public set deliveryPointAdressandDates(value: DeliveryPointAdressAndDates) {
		this._deliveryPointAdressandDates = value;
	}

    /**
     * Setter statutCommande
     * @param {String[]} value
     */
	public set statutCommande(value: String[]) {
		this._statutCommande = value;
	}
	

}