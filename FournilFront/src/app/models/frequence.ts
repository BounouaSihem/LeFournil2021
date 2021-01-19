


export class Frequence {

    private _id: number;
    private _frequencyCommandeProduct: String;

	constructor(id: number, frequencyCommandeProduct: String) {
		this._id = id;
		this._frequencyCommandeProduct = frequencyCommandeProduct;
	}

    /**
     * Getter id
     * @return {number}
     */
	public get id(): number {
		return this._id;
	}

    /**
     * Getter frequencyCommandeProduct
     * @return {String}
     */
	public get frequencyCommandeProduct(): String {
		return this._frequencyCommandeProduct;
	}

    /**
     * Setter id
     * @param {number} value
     */
	public set id(value: number) {
		this._id = value;
	}

    /**
     * Setter frequencyCommandeProduct
     * @param {String} value
     */
	public set frequencyCommandeProduct(value: String) {
		this._frequencyCommandeProduct = value;
	}

}