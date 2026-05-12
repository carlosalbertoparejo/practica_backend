import { apiGet } from "./client.js";

export function getGeneros() {
  return apiGet("/generos");
}
