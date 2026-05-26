import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private apiUrl = 'http://localhost:8080/api/usuarios/iniciar-sesion';

  constructor(private http: HttpClient) {}

  iniciarSesion(nickUsuario: string, contrasena: string): Observable<boolean> {
    return this.http.get<boolean>(`${this.apiUrl}?nickUsuario=${nickUsuario}&nickContrasena=${contrasena}`);
  }
}
