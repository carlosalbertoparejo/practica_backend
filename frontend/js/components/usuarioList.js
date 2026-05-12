import { getUsuarios } from "../api/usuarioApi.js";

export async function renderUsuarioList() {
  const usuarios = await getUsuarios();
  const container = document.getElementById("usuario-list");

  container.innerHTML = `
    <h2>Listado de usuarios</h2>
    <ul>
      ${usuarios.map(u => `<li>${u.nombre} (${u.email})</li>`).join("")}
    </ul>
  `;
}
