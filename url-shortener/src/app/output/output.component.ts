import { Component } from '@angular/core';
import { ApiService } from '../api.service';
import { URLEntry } from '../URLEntry';
import {
    trigger,
    transition,
    style,
    animate
} from "@angular/animations";

@Component({
    selector: 'app-output',
    templateUrl: './output.component.html',
    styleUrls: ['./output.component.css'],
    animations: [
        trigger("fadeIn", [
            transition(":enter", [
                style({opacity: 0}),
                animate("500ms 150ms", style({
                    opacity: "*"
                }))
            ]),
            transition(":leave", [
                style({opacity: "*"}),
                animate(100, style({
                    opacity: 0
                }))
            ])
        ])
    ]
})
export class OutputComponent {

    constructor(private apiService: ApiService) { }

    getError(): string {

        return this.apiService.getError();
    }

    getShortenedURL() {

        return this.apiService.getShortenedURL();
    }

    formatShortenedURL(): string {

        return 'https://shorten-url.herokuapp.com/redir/' + this.getShortenedURL()!.shortenedURL;
    }

    copyLink(): void {

        navigator.clipboard.writeText(this.formatShortenedURL());
    }
}
