import { Component, EventEmitter, Input, Output, OnInit } from '@angular/core';
import { GeneroService } from '../services/genero.service';
import { PuestoService } from '../services/puesto.service';

@Component({
  selector: 'app-popup',
  templateUrl: './popup.component.html',
  styleUrls: ['./popup.component.css']
})
export class PopupComponent implements OnInit {

  @Input() visible = false;
  @Input() modo: 'create' | 'update' = 'create';
  @Input() usuario: any = {};

  @Output() cerrar = new EventEmitter<void>();
  @Output() guardar = new EventEmitter<any>();

  generos: any[] = [];
  puestos: any[] = [];

  direccionEditando: any = {
    tipoVia: '',
    nombreVia: '',
    numero: '',
    codigoPostal: '',
    poblacion: '',
    provincia: ''
  };

  constructor(
    private generoService: GeneroService,
    private puestoService: PuestoService
  ) {}

  ngOnInit(): void {
    this.generoService.listar().subscribe(g => this.generos = g);
    this.puestoService.listar().subscribe(p => this.puestos = p);

    if (!this.usuario.direcciones) {
      this.usuario.direcciones = [];
    }
  }

  agregarDireccion() {
    this.usuario.direcciones.push({ ...this.direccionEditando });

    this.direccionEditando = {
      tipoVia: '',
      nombreVia: '',
      numero: '',
      codigoPostal: '',
      poblacion: '',
      provincia: ''
    };
  }

  eliminarDireccion(index: number) {
    this.usuario.direcciones.splice(index, 1);
  }

  onGuardar() {
    this.guardar.emit(this.usuario);
  }

  onCerrar() {
    this.cerrar.emit();
  }
}
