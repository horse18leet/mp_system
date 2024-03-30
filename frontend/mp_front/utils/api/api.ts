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
    // const refreshToken = localStorage.getItem('refresh_token');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    // else if(refreshToken) {
    //   config.headers.Authorization = `Bearer ${refreshToken}`;
    // }

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
  // if (error.response?.status === 401) {
  //   localStorage.removeItem("token");
  //   updateToken();
  // }

  return Promise.reject(error);
});

export default api;