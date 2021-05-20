export interface ContactRequest {
    username: string;
    correo: string;
    message: string;
  }

export interface ContactResponse {
    sent: string;
  }