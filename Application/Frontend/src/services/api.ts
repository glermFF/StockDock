const SERVER = 'http://localhost:7000';

export default async function api(endpoint: string, config?: RequestInit & { data?: any }) {
  const cfg: RequestInit = { ...(config || {}) };
  if ((config as any)?.data !== undefined) {
    cfg.body = JSON.stringify((config as any).data);
    cfg.headers = { ...(cfg.headers as any), "Content-Type": "application/json" } as HeadersInit;
  }
  const res = await fetch(`${SERVER}${endpoint}`, cfg);
  if (res.status === 204) return null;
  const text = await res.text();
  const contentType = (res.headers.get("content-type") || "").toLowerCase();
  if (contentType.includes("application/json")) {
    try { return text ? JSON.parse(text) : null; } catch { return text; }
  }
  if (!res.ok) throw new Error(text || res.statusText);
  return text;
}