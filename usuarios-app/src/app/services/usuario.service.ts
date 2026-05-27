import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private apiUrl = 'http://localhost:8080/api/usuarios';

  constructor(private http: HttpClient) {}

  listar(nickUsuario: string, nickContrasena: string): Observable<any[]> {
    const params = new HttpParams()
      .set('nickUsuario', nickUsuario)
      .set('nickContrasena', nickContrasena);

    return this.http.get<any[]>(this.apiUrl, { params });
  }

  crear(usuario: any, nickUsuario: string, nickContrasena: string): Observable<any> {
    const params = new HttpParams()
      .set('nickUsuario', nickUsuario)
      .set('nickContrasena', nickContrasena);

    return this.http.post<any>(this.apiUrl, usuario, { params });
  }

  actualizar(id: number, usuario: any, nickUsuario: string, nickContrasena: string): Observable<any> {
    const params = new HttpParams()
      .set('nickUsuario', nickUsuario)
      .set('nickContrasena', nickContrasena);

    return this.http.put<any>(`${this.apiUrl}/${id}`, usuario, { params });
  }

  eliminar(id: number, nickUsuario: string, nickContrasena: string): Observable<any> {
    const params = new HttpParams()
      .set('nickUsuario', nickUsuario)
      .set('nickContrasena', nickContrasena);

    return this.http.delete<any>(`${this.apiUrl}/${id}`, { params });
  }

  listarTodos(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
  
}
