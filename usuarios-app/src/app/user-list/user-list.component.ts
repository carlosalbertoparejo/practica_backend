import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  usuarios: any[] = [];
  seleccionado: any = null;

  popupVisible = false;
  modo: 'create' | 'update' = 'create';
  usuarioEditando: any = {};

  confirmVisible = false;

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    this.cargarUsuarios();
  }

  cargarUsuarios() {
    this.usuarioService
      .listar('admin', 'admin')
      .subscribe(data => this.usuarios = data || []);
  }

  seleccionarUsuario(u: any) {
    this.seleccionado = u;
  }

  crearUsuario() {
    this.modo = 'create';
    this.usuarioEditando = { direcciones: [] };
    this.popupVisible = true;
  }

  actualizarUsuario() {
    if (!this.seleccionado) return;

    this.modo = 'update';
    this.usuarioEditando = JSON.parse(JSON.stringify(this.seleccionado));
    this.popupVisible = true;
  }

  eliminarUsuario() {
    if (!this.seleccionado) return;
    this.confirmVisible = true;
  }
  


  guardarUsuario(usuario: any) {
    if (this.modo === 'create') {
      this.usuarioService
        .crear(usuario, 'admin', 'admin')
        .subscribe(() => {
          this.cargarUsuarios();
          this.popupVisible = false;
        });
    } else {
      this.usuarioService
        .actualizar(usuario.id, usuario, 'admin', 'admin')
        .subscribe(() => {
          this.cargarUsuarios();
          this.popupVisible = false;
        });
    }
  }

  cerrarPopup() {
    this.popupVisible = false;
  }

  logout() {
    // De momento solo recarga la página
    window.location.reload();
  }

  confirmarDelete() {
    this.usuarioService
      .eliminar(this.seleccionado.id, 'admin', 'admin')
      .subscribe(() => {
        this.cargarUsuarios();
        this.seleccionado = null;
        this.confirmVisible = false;
      });
  }
  
  cancelarDelete() {
    this.confirmVisible = false;
  }
  
}
