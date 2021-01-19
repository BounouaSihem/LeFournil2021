import { Injectable } from '@angular/core';
import { Product } from '../models/product';
import { ApiHelperService } from './api-helper.service';
import {DomSanitizer} from '@angular/platform-browser';
@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  public products: Product[];
  public image_product:any;
  id:number;
 // constructor() { }

 constructor(private api: ApiHelperService, private sanitizer: DomSanitizer ) {
  this.products = [];
  
}
async findAllProducts(): Promise<any> {
  return this.api.get({ endpoint: '/products' });
}
async findProductById(id: number): Promise<any> {
  return this.api.get({ endpoint: `/products/${id}`})
}

public getAllProducts(): Promise<any> {
  let promise = new Promise((resolve, reject) => {
    this.api.get({ endpoint: '/products' })
          .then(
              res => {
                  resolve(res);
              },
              msg => {
                  reject(msg);
              }
          ).catch((error) => {
          });
  });
  return promise;
}


public findAllFrequence(): Promise<any> {
  return this.api.get({ endpoint: '/frequency_delivery_type' });
}
public findFrequenceById(id: number): Promise<any> {
  return this.api.get({ endpoint: `/frequency_delivery_type/${id}`})
}
//route pour recuperer une photo d'un produitId
public getOnePhotobyProductId(photoId:number): Promise<any> {
  let promise = new Promise((resolve, reject) => {
      this.api.get({endpoint: `/products/${this.id}/photo`, queryParams: { "photoId":photoId} })
          .then(
            dataBlob => {
                const objectURL = URL.createObjectURL(dataBlob);
                this.image_product = this.sanitizer.bypassSecurityTrustUrl(objectURL);

                  resolve(dataBlob);
              },
              msg => {
                  reject(msg);
              }
          ).catch((error) => {
          });
  });
  return promise;
}


}
