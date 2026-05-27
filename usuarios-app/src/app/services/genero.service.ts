import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GeneroService {

  private apiUrl = 'http://localhost:8080/api/generos';

  constructor(private http: HttpClient) {}

  listar(nickUsuario: string, nickContrasena: string): Observable<any[]> {
    const params = {
      nickUsuario: nickUsuario,
      nickContrasena: nickContrasena
    };
  
    return this.http.get<any[]>(this.apiUrl, { params });
  }
  

  
}
