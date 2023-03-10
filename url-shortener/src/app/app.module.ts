import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { InputComponent } from './input/input.component';
import { ShadowBoxComponent } from './shadow-box/shadow-box.component';
import { TitleComponent } from './title/title.component';
import { OutputComponent } from './output/output.component';

@NgModule({
    declarations: [
        AppComponent,
        HeaderComponent,
        InputComponent,
        ShadowBoxComponent,
        TitleComponent,
        OutputComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        HttpClientModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
