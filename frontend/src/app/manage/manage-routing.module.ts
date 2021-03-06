import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {ManageComponent} from './manage.component';
import {AuthGuard} from '../shared/services/auth/auth-guard.service';

@NgModule({
    imports: [
        RouterModule.forChild([
            {
                path: 'manage',
                component: ManageComponent,
                canActivate: [AuthGuard]
            }
        ])
    ],
    exports: [
        RouterModule
    ]
})
export class ManageRoutingModule {
}
