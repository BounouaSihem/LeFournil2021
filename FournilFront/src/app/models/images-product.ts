

export class ImagesProduct {
    private _id: number;
    private _image_product: Blob;

	constructor(id: number, image_product: Blob) {
		this._id = id;
		this._image_product = image_product;
	}

    /**
     * Getter id
     * @return {number}
     */
	public get id(): number {
		return this._id;
	}

    /**
     * Getter image_product
     * @return {Blob}
     */
	public get image_product(): Blob {
		return this._image_product;
	}

    /**
     * Setter id
     * @param {number} value
     */
	public set id(value: number) {
		this._id = value;
	}

    /**
     * Setter image_product
     * @param {Blob} value
     */
	public set image_product(value: Blob) {
		this._image_product = value;
	}

}