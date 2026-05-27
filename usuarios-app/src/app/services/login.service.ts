import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private apiUrl = 'http://localhost:8080/api/usuarios/iniciar-sesion';

  constructor(private http: HttpClient) {}

  iniciarSesion(nickUsuario: string, contrasena: string): Observable<boolean> {

    const params = new HttpParams()
      .set('nickUsuario', nickUsuario)
      .set('contrasena', contrasena);

    return this.http.post<boolean>(this.apiUrl, null, { params });
  }
}
