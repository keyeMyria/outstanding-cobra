import {Component, OnInit, ViewEncapsulation} from "@angular/core";
import {ManageDialog} from "../manage-dialog";
import {SchoolYearDto, SchoolClassDto} from "../model/ManageDto";
import {FormGroup, FormBuilder, Validators} from "@angular/forms";
import {MdDialogRef} from "@angular/material";
import {OutcobraValidators} from "../../shared/services/outcobra-validators";
import {TranslateService} from "ng2-translate";
import {DatePipe} from "@angular/common";

@Component({
    selector: 'school-year-dialog',
    templateUrl: './school-year-dialog.component.html',
    styleUrls: ['school-year-dialog.component.scss'],
    encapsulation: ViewEncapsulation.None
})
export class SchoolYearDialog extends ManageDialog<SchoolYearDto, SchoolClassDto> implements OnInit {

    private schoolYearForm: FormGroup;

    constructor(public dialogRef: MdDialogRef<SchoolYearDialog>,
                private formBuilder: FormBuilder,
                private translate: TranslateService,
                private datePipe: DatePipe) {
        super();
    }

    ngOnInit() {
        this.schoolYearForm = this.formBuilder.group({
                name: [this.isEditMode() ? this.params.name : '', Validators.required],
                validFrom: [this.isEditMode() ? this.params.validFrom : '', Validators.required],
                validTo: [this.isEditMode() ? this.params.validTo : '', Validators.required]
            },
            {
                validator: OutcobraValidators.dateFromIsBeforeDateTo
            }
        );
    }

    getErrorText(controlName: string, errorName: string, errorProp: string) {
        let control = this.schoolYearForm.get(controlName);
        let date = this.datePipe.transform(control.getError(errorName)[errorProp], 'MM.dd.y');
        return control.hasError(errorName) ? this.translate.instant(`i18n.common.form.error.${errorName}`, {'date': date}) : "";
    }

    onCancel() {
        this.dialogRef.close(null);
    }

    onSubmit() {
        if (this.schoolYearForm.valid && this.schoolYearForm.dirty) {
            let value = this.schoolYearForm.value;
            value.schoolClassId = this.parent.id;
            this.dialogRef.close(value);
        }
        else if (this.schoolYearForm.pristine) {
            this.revalidateForm(this.schoolYearForm);
        }
    }

}
