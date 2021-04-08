import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './home/footer/footer.component';
import { AboutUsComponent } from './home/about-us/about-us.component';
import { DeliveryComponent } from './home/delivery/delivery.component';
import { ProductListComponent } from './home/product-list/product-list.component';
import { ProductDetailsComponent } from './home/product/product-details/product-details.component';
import { OrderFormValidationComponent } from './home/order-form-validation/order-form-validation.component';
import { MyCartComponent } from './home/my-cart/my-cart.component';


/*const blogRoutes: Routes = [
 { path: 'home', component: HomeComponent },
 { path: 'blog', component: BlogComponent },
 { path: 'articles/:id', component: DetailsArticleComponent},
 { path: 'articles/:id', component: LastEntriesComponent},
 { path: 'articles/thematique/:id', component: BlogComponent},
 { path: '', redirectTo: 'home', pathMatch: 'full' },
 { path: '**', redirectTo: 'home' }
 ];*/

const routes: Routes = [

  {
    path: "infos",
    component: AboutUsComponent
  },

  {
    path: "home",
    component: HomeComponent
  },

  {
    path: "livraisons",
    component: DeliveryComponent
  },

  {
    path: "nos-produits",
    component: ProductListComponent
  },

  {
    path: "products/:id",
    component: ProductDetailsComponent
  },
 /* {
    path: "mon-panier",
    component: MyCartComponent
  },*/

  {
    path: "validation-commande",
    component: OrderFormValidationComponent
  },


  {
    path: "**",
    redirectTo: "home"
  },

];

/*const blogRoutes: Routes = [
{ path: 'home', component: HomeComponent },
{ path: 'blog', component: BlogComponent },
{ path: 'articles/:id', component: DetailsArticleComponent},
{ path: 'articles/thematique/:id', component: BlogComponent},
{ path: '', redirectTo: 'home', pathMatch: 'full' },
{ path: '**', redirectTo: 'home' }
]; */




@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
/* avec cette variable je factorise les routes pour ne les avoir que là
et donc de ne pas modifier le fichier appmodule */
export const routingComponents = [AboutUsComponent, HomeComponent, DeliveryComponent,
  ProductListComponent, ProductDetailsComponent, OrderFormValidationComponent, FooterComponent, HomeComponent]


