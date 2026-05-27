import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private nickUsuario: string | null = null;
  private nickContrasena: string | null = null;

  setCredenciales(nickUsuario: string, nickContrasena: string) {
    this.nickUsuario = nickUsuario;
    this.nickContrasena = nickContrasena;
  }

  getNickUsuario(): string {
    return this.nickUsuario || '';
  }

  getNickContrasena(): string {
    return this.nickContrasena || '';
  }

  isLoggedIn(): boolean {
    return !!this.nickUsuario && !!this.nickContrasena;
  }

  logout() {
    this.nickUsuario = null;
    this.nickContrasena = null;
  }
}
