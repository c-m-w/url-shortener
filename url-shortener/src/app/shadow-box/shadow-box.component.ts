import { Component, Input } from '@angular/core';
import {
    trigger,
    transition,
    state,
    query,
    style,
    animate,
    group,
    animateChild
} from "@angular/animations";

@Component({
    selector: 'app-shadow-box',
    templateUrl: './shadow-box.component.html',
    styleUrls: ['./shadow-box.component.css'],
    animations: [
        trigger("interacting", [
            transition("false => true", [
                query(".left", [
                    style({
                        height: 0
                    })
                ]),
                query(".bottom", [
                    style({
                        width: 0
                    })
                ]),
                group([
                    query(".left", [
                        animate(50, style({
                            height: "*"
                        }))
                    ]),
                    query(".bottom", [
                        animate("100ms 50ms", style({
                            width: "*"
                        }))
                    ])
                ])
            ]),
            transition("true => false", [
                animateChild(),
                query(".left", [
                    style({
                        height: "*"
                    })
                ]),
                query(".bottom", [
                    style({
                        width: "*"
                    })
                ]),
                group([
                    query(".bottom", [
                        animate(100, style({
                            width: "0"
                        }))
                    ]),
                    query(".left", [
                        animate("50ms 100ms", style({
                            height: "0"
                        }))
                    ])
                ])
            ])
        ])
    ]
})
export class ShadowBoxComponent {

    @Input() interactionState!: boolean;
}
