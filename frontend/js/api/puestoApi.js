import { apiGet } from "./client.js";

export function getPuestos() {
  return apiGet("/puestos-de-trabajo");
}
