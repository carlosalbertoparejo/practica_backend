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

  nickUsuario: string = '';
  contrasena: string = '';
  error: string = '';

  constructor(
    private loginService: LoginService,
    private authService: AuthService,
    private router: Router
  ) {}

  onLogin() {
    this.error = '';

    this.loginService.iniciarSesion(this.nickUsuario, this.contrasena)
      .subscribe({
        next: (resultado) => {

          if (resultado === true) {

            this.authService.setCredenciales(this.nickUsuario, this.contrasena);

            this.router.navigate(['/usuarios']);
          } else {
            this.error = 'Usuario o contraseña incorrectos';
          }
        },
        error: () => {
          this.error = 'Usuario o contraseña incorrectos';
        }
      });
  }
}
