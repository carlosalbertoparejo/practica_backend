import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-confirm-popup',
  templateUrl: './confirm-popup.component.html',
  styleUrls: ['./confirm-popup.component.css']
})
export class ConfirmPopupComponent {

  @Input() visible = false;
  @Input() mensaje = 'Are you sure?';

  @Output() aceptar = new EventEmitter<void>();
  @Output() cancelar = new EventEmitter<void>();

  onAceptar() {
    this.aceptar.emit();
  }

  onCancelar() {
    this.cancelar.emit();
  }
}
