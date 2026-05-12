import { crearUsuario } from "../api/usuarioApi.js";
import { renderUsuarioList } from "./usuarioList.js";

export function renderUsuarioForm() {
  const container = document.getElementById("usuario-form");

  container.innerHTML = `
    <h2>Crear usuario</h2>
    <form id="form-usuario">
      <input type="text" id="nombre" placeholder="Nombre" required>
      <input type="email" id="email" placeholder="Email" required>
      <button type="submit">Guardar</button>
    </form>
  `;

  document.getElementById("form-usuario").addEventListener("submit", async (e) => {
    e.preventDefault();

    const usuario = {
      nombre: document.getElementById("nombre").value,
      email: document.getElementById("email").value
    };

    await crearUsuario(usuario);
    await renderUsuarioList();
  });
}
