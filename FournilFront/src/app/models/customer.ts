import { Commande } from './commande';

export class Customer {

    private _id: number;
    private _firstName: String;
    private _lastName: String;
    private _email: String;
    private _mobileNumber: String;
    private _isPresentInDB: boolean;
    private _commandeSet: Commande[];


	constructor(id: number, firstName: String, lastName: String, email: String, mobileNumber: String, isPresentInDB: boolean, commandeSet: Commande[]) {
		this._id = id;
		this._firstName = firstName;
		this._lastName = lastName;
		this._email = email;
		this._mobileNumber = mobileNumber;
		this._isPresentInDB = isPresentInDB;
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
     * Getter firstName
     * @return {String}
     */
	public get firstName(): String {
		return this._firstName;
	}

    /**
     * Getter lastName
     * @return {String}
     */
	public get lastName(): String {
		return this._lastName;
	}

    /**
     * Getter email
     * @return {String}
     */
	public get email(): String {
		return this._email;
	}

    /**
     * Getter mobileNumber
     * @return {String}
     */
	public get mobileNumber(): String {
		return this._mobileNumber;
	}

    /**
     * Getter isPresentInDB
     * @return {boolean}
     */
	public get isPresentInDB(): boolean {
		return this._isPresentInDB;
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
     * Setter firstName
     * @param {String} value
     */
	public set firstName(value: String) {
		this._firstName = value;
	}

    /**
     * Setter lastName
     * @param {String} value
     */
	public set lastName(value: String) {
		this._lastName = value;
	}

    /**
     * Setter email
     * @param {String} value
     */
	public set email(value: String) {
		this._email = value;
	}

    /**
     * Setter mobileNumber
     * @param {String} value
     */
	public set mobileNumber(value: String) {
		this._mobileNumber = value;
	}

    /**
     * Setter isPresentInDB
     * @param {boolean} value
     */
	public set isPresentInDB(value: boolean) {
		this._isPresentInDB = value;
	}

    /**
     * Setter commandeSet
     * @param {Commande[]} value
     */
	public set commandeSet(value: Commande[]) {
		this._commandeSet = value;
	}

}