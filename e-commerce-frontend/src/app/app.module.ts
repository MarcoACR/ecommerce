import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ListaProductosComponent } from './components/lista-productos/lista-productos.component';
import {HttpClientModule} from '@angular/common/http';
import { AgregarProductosComponent } from './components/agregar-productos/agregar-productos.component';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';

const routeo: Routes = [
  {path: 'productos', component: ListaProductosComponent},
  {path: 'agregar', component: AgregarProductosComponent},
  {path: 'editar/:idproducto', component: AgregarProductosComponent},
  {path: '', redirectTo: '/productos', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    ListaProductosComponent,
    AgregarProductosComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routeo),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
