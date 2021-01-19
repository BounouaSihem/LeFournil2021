
import { Component, OnInit } from '@angular/core';
import { Format } from 'src/app/models/format';
import { Frequence } from 'src/app/models/frequence';
import { ImagesProduct } from 'src/app/models/images-product';
import { PhotoProduct } from 'src/app/models/photo-product';
import { Product } from 'src/app/models/product';
import { ProductInCart } from 'src/app/models/product-in-cart';
import { ProductsService } from 'src/app/services/products.service';
import { environment } from 'src/environments/environment';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { AddProductDialogComponent } from './add-product-dialog/add-product-dialog.component';
import { ApiHelperService } from 'src/app/services/api-helper.service';
import { Router } from '@angular/router';

export interface DialogData {
  product: Product;
  id: number;
  formatSet: Format[];
  products: Product[];
  frequence: Frequence[];
  photoFirst: PhotoProduct
}


@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})


export class ProductListComponent implements OnInit {

  public id: number;
  public products: Product[];
  public product: Product;
  public isloading: boolean;
  public formatSet: Format[];
  public format: Format;
  public photoProductSet: PhotoProduct[];
  public urlimageBackEnd :any;
  public productQuantities: number;
  public productInCart: ProductInCart;
  public frequence: Frequence[];
  public frequencyCommandeProduct: String;
  public photoFirst: PhotoProduct
  public data: DialogData;

  constructor(private productsService: ProductsService, private router: Router,  private api: ApiHelperService, public dialog: MatDialog) {
    
    this.id;
    this.format = this.format
    this.frequence = [];
    this.frequencyCommandeProduct;
    this.productQuantities;
    this.id;
    this.product;
    this.formatSet = [];
    this.photoProductSet = [];
    this.productInCart;
    this.photoFirst;

  }

  async ngOnInit() {

    this.photoFirst;
    this.id;
    this.frequencyCommandeProduct;
    this.productQuantities;
    this.urlimageBackEnd = environment.base_url;
    this.isloading = true;
    this.product;
    this.format;
    this.productInCart
    this.formatSet;
    this.product;
    this.products;
    this.photoProductSet;
    ////////////////////////
    await this.productsService.findAllProducts()
      .then(res => {
        this.id = res.id;
        this.products = res;
        console.log("this.products=");
        console.log(this.products);
        this.formatSet = res.formatSet;
        this.photoProductSet = res.photoProductSet;
        return this.products;

      }).finally(() => this.isloading = false)
      ;

    ////////////////////////
  }
 

  detailsProduct(id: number) {
    this.router.navigate(['products', id]);

  }

  async openDialog(id: number) {

    this.urlimageBackEnd = environment.base_url;
    await this.api.get({ endpoint: `/products/${id}` })
      .then(res => {
        this.product = res;
        this.id = res.id;
        this.formatSet = res.formatSet;
        this.photoProductSet = res.photoProductSet;
        this.photoFirst = res.photoProductSet[0]
        return this.product;
      });

    await this.productsService.findAllFrequence()
      .then(res => {
        this.frequence = res; 
        console.log(this.frequence);
        this.frequencyCommandeProduct = res.frequencyCommandeProduct;
        return this.frequence;
      });

    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      products: this.products,
      product: this.product,
      formatSet: this.formatSet,
      id: this.id,
      frequence: this.frequence,
      frequencyCommandeProduct:this.frequencyCommandeProduct,
      photoFirst: this.photoFirst
    };

    let dialogRef = this.dialog.open(AddProductDialogComponent, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      this.data = result;
      console.log("Dialog result:");
      console.log(result);
    });

  }


  /////////fin du component product-list///////////////////
}






