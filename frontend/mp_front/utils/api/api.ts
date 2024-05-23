import axios from 'axios';
import { updateToken } from './auth/auth';

const baseURL = process.env.NEXT_PUBLIC_DOMAIN_NAME;

const api = axios.create({
  baseURL: baseURL,
  headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    // "Content-Type": "application/x-www-form-urlencoded",
  },
});

api.interceptors.request.use( 
  (config) => {
    const token = localStorage.getItem('token');
    
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
      console.log("отправляем в теле токен: ", token);
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

api.interceptors.response.use(
  (response) => {
    return response;
  },
(error) => {
  console.log(error);
  if (error.response?.status === 401) {
    updateToken();
  }

  return Promise.reject(error);
});

export default api;