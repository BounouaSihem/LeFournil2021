


export class Frequence {

    private _id: number;
    private _frequencyCommandeProduct: String;
    private _factorFrequency :number;



	constructor(id: number, frequencyCommandeProduct: String, factorFrequency: number) {
		this._id = id;
		this._frequencyCommandeProduct = frequencyCommandeProduct;
		this._factorFrequency = factorFrequency;
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
     * Getter factorFrequency
     * @return {number}
     */
	public get factorFrequency(): number {
		return this._factorFrequency;
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

    /**
     * Setter factorFrequency
     * @param {number} value
     */
	public set factorFrequency(value: number) {
		this._factorFrequency = value;
	}
	
	
	

}