import { Component, EventEmitter, Output } from '@angular/core';
import {
    trigger,
    state,
    style,
    transition,
    animate,
    group
} from "@angular/animations";
import { ApiService } from '../api.service';
import { URLEntry } from '../URLEntry';

@Component({
    selector: 'app-input',
    templateUrl: './input.component.html',
    styleUrls: ['./input.component.css'],
    animations: [
        trigger("focus", [
            state("true", style({
                width: "100%"
            })),
            state("false", style({
                width: "0%"
            })),
            transition("false <=> true", animate(300))
        ]),
        trigger("urlEntered", [
            state("true", style({
                width: "max-content",
                opacity: 1
            })),
            state("false", style({
                width: 0,
                opacity: 0,
                color: "transparent"
            })),
            transition("false => true", [
                group([
                    animate(300, style({width: "*"})),
                    animate("300ms 100ms", style({opacity: "*"}))
                ]),
                animate(300, style({color: "*"}))
            ]),
            transition("true => false", [
                style({width: "*", opacity: "*", color: "*"}),
                animate(300, style({color: "transparent"})),
                group([
                    animate(300, style({opacity: 0})),
                    animate("300ms 100ms", style({width: 0}))
                ])
            ])
        ])
    ]
})
export class InputComponent {

    urlString: string = ""
    focussed: boolean = false;

    constructor(private apiService: ApiService) { }

    changeURL(newURL: string): void {

        this.urlString = newURL;
    }

    focus(): void {

        this.focussed = true;
    }

    loseFocus(): void {

        this.focussed = false;
    }

    shortenURL(): void {

        console.log("communicating...");

        this.apiService.shortenURL(this.urlString).subscribe((m: URLEntry) => {

            console.log(m);
        },
        error => {
            console.log("error");
        })
    }
}
