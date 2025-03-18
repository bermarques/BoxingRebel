export type AlertType = 'SUCCESS' | 'DANGER';

export interface ToastInfo {
  body: string;
  type: AlertType;
}
