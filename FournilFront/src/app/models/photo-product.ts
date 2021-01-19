export class PhotoProduct{

    private _id : number;
    private _photoUrlName : String[];

	constructor(id: number, photoUrlName: String[]) {
		this._id = id;
		this._photoUrlName = photoUrlName;
	}

    /**
     * Getter id
     * @return {number}
     */
	public get id(): number {
		return this._id;
	}

    /**
     * Getter photoUrlName
     * @return {String[]}
     */
	public get photoUrlName(): String[] {
		return this._photoUrlName;
	}

    /**
     * Setter id
     * @param {number} value
     */
	public set id(value: number) {
		this._id = value;
	}

    /**
     * Setter photoUrlName
     * @param {String[]} value
     */
	public set photoUrlName(value: String[]) {
		this._photoUrlName = value;
	}


}