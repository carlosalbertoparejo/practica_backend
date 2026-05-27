import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../auth.service';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private apiUrl = 'http://localhost:8080/api/usuarios';

  constructor(
    private http: HttpClient,
    private authService: AuthService
  ) {}

  private buildParams(): HttpParams {
    return new HttpParams()
      .set('nickUsuario', this.authService.getNickUsuario())
      .set('nickContrasena', this.authService.getNickContrasena());
  }

  listar(): Observable<any[]> {
    const params = this.buildParams();
    return this.http.get<any[]>(this.apiUrl, { params });
  }

  crear(usuario: any): Observable<any> {
    const params = this.buildParams();
    return this.http.post<any>(this.apiUrl, usuario, { params });
  }

  actualizar(id: number, usuario: any): Observable<any> {
    const params = this.buildParams();
    return this.http.put<any>(`${this.apiUrl}/${id}`, usuario, { params });
  }

  eliminar(id: number): Observable<any> {
    const params = this.buildParams();
    return this.http.delete<any>(`${this.apiUrl}/${id}`, { params });
  }
}
