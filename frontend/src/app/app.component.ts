import {Component, OnInit} from '@angular/core';
import {TranslateService} from "ng2-translate";
import {NotificationsService} from "angular2-notifications";

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {
    title = 'Outcobra!';

    constructor(translate: TranslateService, private _n: NotificationsService) {
        translate.setDefaultLang('en');
        //translate.use(translate.getBrowserLang());
        translate.use(translate.getDefaultLang());
    }

    click() {
        this._n.error('demo.error.title', 'demo.error.title');
        this._n.alert('abcdef', 'daskhdkasd');
        this._n.success('abcdef', 'daskhdkasd');
        this._n.info('abcdef', 'daskhdkasd');
    }
}
