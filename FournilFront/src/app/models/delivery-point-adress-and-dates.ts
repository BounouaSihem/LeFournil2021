import { Commande } from './commande';

export class DeliveryPointAdressAndDates{

    private _id: number;
    private _deliveryPointAdressAndDates: DeliveryPointAdressAndDates;
    private _deliveryDate: Date;
    private _orderDeadline: Date;
    private _commandeSet: Commande[];

	constructor(id: number, deliveryPointAdressAndDates: DeliveryPointAdressAndDates, deliveryDate: Date, orderDeadline: Date, commandeSet: Commande[]) {
		this._id = id;
		this._deliveryPointAdressAndDates = deliveryPointAdressAndDates;
		this._deliveryDate = deliveryDate;
		this._orderDeadline = orderDeadline;
		this._commandeSet = commandeSet;
	}

    /**
     * Getter id
     * @return {number}
     */
	public get id(): number {
		return this._id;
	}

    /**
     * Getter deliveryPointAdressAndDates
     * @return {DeliveryPointAdressAndDates}
     */
	public get deliveryPointAdressAndDates(): DeliveryPointAdressAndDates {
		return this._deliveryPointAdressAndDates;
	}

    /**
     * Getter deliveryDate
     * @return {Date}
     */
	public get deliveryDate(): Date {
		return this._deliveryDate;
	}

    /**
     * Getter orderDeadline
     * @return {Date}
     */
	public get orderDeadline(): Date {
		return this._orderDeadline;
	}

    /**
     * Getter commandeSet
     * @return {Commande[]}
     */
	public get commandeSet(): Commande[] {
		return this._commandeSet;
	}

    /**
     * Setter id
     * @param {number} value
     */
	public set id(value: number) {
		this._id = value;
	}

    /**
     * Setter deliveryPointAdressAndDates
     * @param {DeliveryPointAdressAndDates} value
     */
	public set deliveryPointAdressAndDates(value: DeliveryPointAdressAndDates) {
		this._deliveryPointAdressAndDates = value;
	}

    /**
     * Setter deliveryDate
     * @param {Date} value
     */
	public set deliveryDate(value: Date) {
		this._deliveryDate = value;
	}

    /**
     * Setter orderDeadline
     * @param {Date} value
     */
	public set orderDeadline(value: Date) {
		this._orderDeadline = value;
	}

    /**
     * Setter commandeSet
     * @param {Commande[]} value
     */
	public set commandeSet(value: Commande[]) {
		this._commandeSet = value;
	}


}