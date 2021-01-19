import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Format } from 'src/app/models/format';
import { Frequence } from 'src/app/models/frequence';
import { ImagesProduct } from 'src/app/models/images-product';
import { PhotoProduct } from 'src/app/models/photo-product';
import { Product } from 'src/app/models/product';
import { ApiHelperService } from 'src/app/services/api-helper.service';
import { ProductsService } from 'src/app/services/products.service';
import { environment } from "src/environments/environment";
@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
  id: number;
  public product: Product;
  public formatSet: Format[];
  public format: Format;
  public isloading: boolean;    ////////////////   pour le spinner
  public frequence: Frequence[];
  public frequencyCommandeProduct: String;
  public productQuantities: number;
  public photoProductSet: PhotoProduct[];
  public productId: number;
  public urlimageBackEnd;

  constructor(private productsService: ProductsService, private api: ApiHelperService, private route: ActivatedRoute, private router: Router, private sanitizer: DomSanitizer, private http: HttpClient) {
    this.product = this.product;
    this.format=this.format
    this.formatSet = [];
    this.frequence = [];
    this.frequencyCommandeProduct = this.frequencyCommandeProduct;
    this.productQuantities;
    this.photoProductSet = [];
   

  }
    

  async ngOnInit() {
   
    this.urlimageBackEnd=environment.base_url;
    this.route.params.subscribe(async (params) => {
    this.isloading=true;
      const id = params.id;
     
        setTimeout(() => { this.productsService.findProductById(id)
        .then(res => {
          this.product = res;
          this.id = res.id;
          this.formatSet = res.formatSet;
          console.log("formatSet::::::::::::::::::")
          console.log(this.formatSet);
          this.photoProductSet = res.photoProductSet;

        }).finally (()=> this.isloading=false) }, 1000);

    });
    this.format;
    this.formatSet;
    this.product;
    this.frequencyCommandeProduct;
    this.productQuantities;
    this.photoProductSet;

    setTimeout(() => { this.productsService.findAllFrequence()
      .then(res => {
        this.frequence = res;
        console.log(this.frequence);
        this.frequencyCommandeProduct = res.frequencyCommandeProduct;
        console.log(this.frequencyCommandeProduct);

      }).finally (()=> this.isloading=false)}, 1000);

 


  }

  

 



  //////////////////////////////////
}
