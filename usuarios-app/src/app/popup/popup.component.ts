import { Component, EventEmitter, Input, Output, OnInit } from '@angular/core';
import { GeneroService } from '../services/genero.service';
import { PuestoDeTrabajoService } from '../services/puesto.service';

@Component({
  selector: 'app-popup',
  templateUrl: './popup.component.html',
  styleUrls: ['./popup.component.css']
})
export class PopupComponent implements OnInit {

  @Input() visible = false;
  @Input() modo: 'create' | 'update' = 'create';
  @Input() usuario: any = { direcciones: [] };

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
    private puestoService: PuestoDeTrabajoService
  ) {}

  ngOnInit(): void {
    this.cargarGeneros();
    this.cargarPuestos();
  }

  cargarGeneros() {
    this.generoService
      .listar('admin', 'admin')
      .subscribe(data => this.generos = data || []);
  }

  cargarPuestos() {
    this.puestoService
      .listar('admin', 'admin')
      .subscribe(data => this.puestos = data || []);
  }

  agregarDireccion() {
    if (!this.usuario.direcciones) {
      this.usuario.direcciones = [];
    }

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

  onCerrar() {
    this.cerrar.emit();
  }

  onGuardar() {
    this.guardar.emit(this.usuario);
  }
}
