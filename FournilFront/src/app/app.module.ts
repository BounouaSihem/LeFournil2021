import { BrowserModule} from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { AppRoutingModule } from './app-routing.module';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { MatRippleModule } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import {MatSelectModule} from '@angular/material/select';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './home/header/header.component';
import { FooterComponent } from './home/footer/footer.component';
import { AboutUsComponent } from './home/about-us/about-us.component';
import { DeliveryComponent } from './home/delivery/delivery.component';
import {ProductListComponent } from './home/product-list/product-list.component';
import { ProductComponent } from './home/product/product.component';
import { ProductDetailsComponent } from './home/product/product-details/product-details.component';
import { OrderFormValidationComponent } from './home/order-form-validation/order-form-validation.component';
import { RouterModule } from '@angular/router';

import { ProductsService } from './services/products.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import {MatDialogModule, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {ScrollingModule} from '@angular/cdk/scrolling';
import { AddProductDialogComponent } from './home/product-list/add-product-dialog/add-product-dialog.component';
import { MatDialogRef } from '@angular/material/dialog';
import { ReactiveFormsModule } from '@angular/forms';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    AboutUsComponent,
    DeliveryComponent,
    ProductListComponent,
    ProductComponent,
    ProductDetailsComponent,
    OrderFormValidationComponent,
    AddProductDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    MatToolbarModule,
    MatIconModule,
    MatMenuModule,
    MatButtonModule,
    AppRoutingModule,
    MatRippleModule,
    MatFormFieldModule,
    MatInputModule,
    MatSidenavModule,
    MatCardModule,
    MatListModule,
    MatSelectModule,
    HttpClientModule,
    MatProgressSpinnerModule,
    FormsModule,
    MatDialogModule,
    ScrollingModule,
    ReactiveFormsModule,
    RouterModule
  

  
   
  ],
  entryComponents: [
    AddProductDialogComponent
  ],
  exports: [AddProductDialogComponent],
  providers: [
    ProductsService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
