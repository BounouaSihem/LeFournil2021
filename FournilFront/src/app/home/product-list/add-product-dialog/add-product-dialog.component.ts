import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatDialogRef } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { DeliveryPointAdressAndDates } from 'src/app/models/delivery-point-adress-and-dates';
import { Format } from 'src/app/models/format';
import { Frequence } from 'src/app/models/frequence';
import { PhotoProduct } from 'src/app/models/photo-product';
import { Product } from 'src/app/models/product';
import { ApiHelperService } from 'src/app/services/api-helper.service';
import { ProductsService } from 'src/app/services/products.service';
import { environment } from "src/environments/environment";
import { DialogData } from '../product-list.component';
import { FormGroup, FormBuilder, Validators, NgForm, FormControl, FormGroupDirective } from "@angular/forms";
import { Subject } from 'rxjs/internal/Subject';
import { ErrorStateMatcher } from '@angular/material/core';
import { ProductForm } from 'src/app/models/product-form';
import { ProductInCart } from 'src/app/models/product-in-cart';
import { createHostListener } from '@angular/compiler/src/core';
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
  public formatSelected: Format;
  public formatType: String[];
  public photoProductSet: PhotoProduct[];
  public urlimageBackEnd;
  public productQuantities: number;
  public frequence: Frequence[];
  public frequenceComandeChoisie: Frequence;
  public frequencyCommandeProduct: String;
  public photoFirst: PhotoProduct;
  public deliveryAdressAndDate: DeliveryPointAdressAndDates[];
  public deliveryPointAdress: String;
  public formData: ProductForm;
  public totalPrice: number;
  public producInCart: ProductInCart;
  public productsListInCart: ProductInCart[];
  public factor: number;
  public quantity: number;
  public formatWeight: number;
  //Pour le formulaire choix du produit

  productFormGroup: FormGroup;
  matcher = new MyErrorStateMatcher();
  //SubjectsArray: Subject[] ;
  ////////////////////////////
  constructor(private productsService: ProductsService, private api: ApiHelperService, private route: ActivatedRoute, private router: Router, private http: HttpClient,
    private dialogRef: MatDialogRef<AddProductDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: DialogData, public fb: FormBuilder) {
    this.deliveryAdressAndDate = [];
    this.deliveryPointAdress;
    if (data) {
      this.products = data.products;
      this.id = data.id;
      this.product = data.product;
      this.formatSet = data.formatSet;
      // this.formatWeight= data.formatProduct.formatWeight;
      this.frequence = data.frequence;
      this.photoFirst = data.photoFirst
      this.data;
      this.product;
      this.frequencyCommandeProduct;
      this.productQuantities;
      this.photoProductSet;
      this.urlimageBackEnd = environment.base_url;
      this.formData;
      this.productFormGroup;
      this.producInCart;
      this.productsListInCart
      this.totalPrice = 0;
      this.formatSelected;
      this.quantity;
      this.format;

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
    this.deliveryAdressAndDate;
    this.deliveryPointAdress;
    this.formData;
    this.productFormGroup;
    this.producInCart;
    this.formatWeight;
    this.format;
    this.getAllDeliveryAdress();
    this.reactiveForm();
  }

  async getAllDeliveryAdress() {
    await this.productsService.findAllDeliveryAdresse()
      .then(res => {
        this.deliveryAdressAndDate = res;
        console.log(this.deliveryAdressAndDate);
        this.deliveryPointAdress = res.deliveryPointAdress;
        return this.deliveryAdressAndDate;
      });
  }
  //Formulaire de choix du produit
  reactiveForm() {
    this.productFormGroup = this.fb.group({
      quantity: [1, Validators.required],
      formatChoosen: ['', Validators.required],
      frequencyCommandeProduct: ['', Validators.required]
    });
    this.productFormGroup.get('quantity').valueChanges.subscribe((newValuequantity) => {
      const quantityChoisie = newValuequantity;
      this.quantity=quantityChoisie;
      console.log(this.quantity);
    });

    this.productFormGroup.get('formatChoosen').valueChanges.subscribe((newValueFormat) => {
      const format = this.formatSet.find(f => f.formatType == newValueFormat);
      this.format = format;
      this.format.formatWeight=format.formatWeight;
      console.log(this.format.formatWeight);
    });

    this.productFormGroup.get('frequencyCommandeProduct').valueChanges.subscribe((newValueFrequence) => {
      const frequenceCommande = this.frequence.find(f => f.frequencyCommandeProduct == newValueFrequence);
      this.frequenceComandeChoisie = frequenceCommande;
      console.log(this.frequenceComandeChoisie);
    });
    
  }
  /*calculateTotalePrice(){
  const totalPrice=(this.format.formatWeight)*(this.product.productPerKgPrice)*(this.frequenceComandeChoisie.factorFrequency)*(this.quantity)
  console.log("this.totalPrice : ");
  this.totalPrice=totalPrice;
  console.log(this.totalPrice);
  return this.totalPrice
  }*/
  onFormSubmit() {
    if (this.productFormGroup.valid) {
      console.log(this.productFormGroup.value);
      this.addProduct();

    } else {
      return;
    }
  }

  resetForm() {
    this.productFormGroup.reset();
  }

  addProduct() {
    if (this.productFormGroup.valid) {

      this.productsService.createProductInCart(this.productFormGroup.value, this.id)
        .subscribe(dataProduct => {

          this.id = dataProduct.product.id;
          this.formData = dataProduct;
          this.productFormGroup.value.quantity = dataProduct.quantity;
          this.productFormGroup.value.formatChoosen = dataProduct.format.formatType;
          this.productFormGroup.value.frequencyCommandeProduct = dataProduct.frequencyDeliveryType.frequencyCommandeProduct;
          this.producInCart = dataProduct;
          console.log("data:");
          console.log(this.producInCart);
        });
    }
   
  }
  refreshTotalPiricePerProduct(): number {
    if (this.productFormGroup.valid) {
      this.factor = (this.producInCart.frequencyDeliveryType.factorFrequency);
      this.totalPrice = (this.factor) * (this.producInCart.quantity) * (this.producInCart.format.formatWeight) * (this.producInCart.product.productPerKgPrice);
      console.log("this.totalPrice:");
      console.log(this.totalPrice);
    }
    return this.totalPrice;
  }

  refreshTotalPiricePerProductBis(): number {
    if (this.productFormGroup.valid) {
      this.factor = (this.producInCart.frequencyDeliveryType.factorFrequency);
      this.totalPrice = (this.factor) * (this.producInCart.quantity) * (this.producInCart.format.formatWeight) * (this.producInCart.product.productPerKgPrice);
      console.log("this.totalPrice:");
      console.log(this.totalPrice);

    }
    return this.totalPrice;
  }

  ///////////////////////////////////////////////

  public onMatOptionChange(option, value) {
    console.log(option, value);
  }


}
/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}