import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatDialogRef } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { Format } from 'src/app/models/format';
import { Frequence } from 'src/app/models/frequence';
import { PhotoProduct } from 'src/app/models/photo-product';
import { Product } from 'src/app/models/product';
import { ApiHelperService } from 'src/app/services/api-helper.service';
import { ProductsService } from 'src/app/services/products.service';
import { environment } from "src/environments/environment";
import { DialogData, ProductListComponent } from '../product-list.component';
@Component({
  templateUrl: './add-product-dialog.component.html',
  styleUrls: ['./add-product-dialog.component.css']
})
export class AddProductDialogComponent implements OnInit {

  public id: number;
  public products: Product[];
  public product: Product;
  public isloading: boolean;
  public formatSet: Format[];
  public format: Format;
  public photoProductSet: PhotoProduct[];
  public urlimageBackEnd;
  public productQuantities: number;
  public frequence: Frequence[];
  public frequencyCommandeProduct: String;
  public photoFirst : PhotoProduct;

  constructor(private productsService: ProductsService, private api: ApiHelperService, private route: ActivatedRoute, private router: Router, private http: HttpClient,
    private dialogRef: MatDialogRef<AddProductDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: DialogData) {

    if (data) {
      this.products = data.products;
      this.id = data.id;
      this.product = data.product;
      this.format;
      this.formatSet = data.formatSet;
      this.frequence = data.frequence;
      this.photoFirst=data.photoFirst
      this.data;
      this.product;
      this.frequencyCommandeProduct;
      this.productQuantities;
      this.photoProductSet;
      this.urlimageBackEnd = environment.base_url;
    }
  }
  public closeDialog() { this.dialogRef.close(this.data); }

  async ngOnInit() {

    this.products;
    this.id;
    this.product;
    this.formatSet;
    this.product;
    this.frequencyCommandeProduct;
    this.productQuantities;
    this.photoProductSet;

    console.log("this.data=");
    console.log(this.data);

  }

  ///////////////////////////////////////////////
}
