import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

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
    private router: Router
  ) {}

  onLogin() {
    this.loginService.iniciarSesion(this.nickUsuario, this.contrasena)
      .subscribe((resultado) => {
        if (resultado === true) {
          this.router.navigate(['/usuarios']);
        } else {
          this.error = 'Usuario o contraseña incorrectos';
        }
      });
  }
}
