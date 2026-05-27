import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  usuario: string = '';
  contrasena: string = '';
  error: string = '';


  constructor(
    private loginService: LoginService,
    private authService: AuthService,
    private router: Router
  ) {}

  onLogin() {
    this.error = '';
  
    this.loginService.login(this.usuario, this.contrasena).subscribe(ok => {
      if (ok) {
  
        // 🔥 ESTA LÍNEA ES LA QUE FALTABA
        this.authService.setCredenciales(this.usuario, this.contrasena);
  
        this.router.navigate(['/usuarios']);
      } else {
        this.error = 'Usuario o contraseña incorrectos';
      }
    });
  }
  
}

