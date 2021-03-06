



export class Format{
    private _id:number;
	
	private _formatType:String ;
	
	private _formatWeight: number ;



	constructor(id: number, formatType: String , formatWeight: number ) {
		this._id = id;
		this._formatType = formatType;
		this._formatWeight = formatWeight;
	}

    /**
     * Getter id
     * @return {number}
     */
	public get id(): number {
		return this._id;
	}

    /**
     * Getter formatType
     * @return {String }
     */
	public get formatType(): String  {
		return this._formatType;
	}

    /**
     * Getter formatWeight
     * @return {number }
     */
	public get formatWeight(): number  {
		return this._formatWeight;
	}

    /**
     * Setter id
     * @param {number} value
     */
	public set id(value: number) {
		this._id = value;
	}

    /**
     * Setter formatType
     * @param {String } value
     */
	public set formatType(value: String ) {
		this._formatType = value;
	}

    /**
     * Setter formatWeight
     * @param {number } value
     */
	public set formatWeight(value: number ) {
		this._formatWeight = value;
	}
	


}