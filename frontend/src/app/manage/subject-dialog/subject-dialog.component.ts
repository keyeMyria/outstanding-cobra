import {Component, OnInit, ViewEncapsulation} from "@angular/core";
import {MdDialogRef} from "@angular/material";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ManageDialog} from "../manage-dialog";
import {SemesterDto, SubjectDto} from "../model/ManageDto";

@Component({
    selector: 'subject-dialog',
    templateUrl: 'subject-dialog.component.html',
    styleUrls: ['subject-dialog.component.scss'],
    encapsulation: ViewEncapsulation.None
})
export class SubjectDialog extends ManageDialog<SubjectDto, SemesterDto> implements OnInit {

    constructor(public dialogRef: MdDialogRef<SubjectDialog>,
                private formBuilder: FormBuilder) {
        super();
    }

    private subjectForm: FormGroup;

    ngOnInit() {
        this.subjectForm = this.formBuilder.group({
                name: [this.isEditMode() ? this.params.name : '', Validators.required]
            }
        );
    }

    onCancel() {
        this.dialogRef.close(null);
    }

    onSubmit() {
        if (this.subjectForm.valid && this.subjectForm.dirty) {
            let value = this.subjectForm.value;
            value.semesterId = this.parent.id;
            this.dialogRef.close(value);
        }
        else if (this.subjectForm.pristine) {
            this.revalidateForm(this.subjectForm);
        }
    }

}