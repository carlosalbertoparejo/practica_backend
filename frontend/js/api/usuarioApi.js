import { apiGet, apiPost } from "./client.js";

export function getUsuarios() {
  return apiGet("/usuarios");
}

export function crearUsuario(usuario) {
  return apiPost("/usuarios", usuario);
}
