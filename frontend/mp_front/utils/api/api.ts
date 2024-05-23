import axios from 'axios';
import { updateToken } from './auth/auth';

const baseURL = process.env.NEXT_PUBLIC_DOMAIN_NAME;

let isToken;

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

    //config.headers.Authorization = `Bearer ${token}`;
    
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
      console.log("token");
    }
    /* else if(refreshToken){
      config.headers.Authorization = `Bearer ${refreshToken}`;
      console.log("refreshhhh");
    } */

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
    console.log("updateToken");
  }

  return Promise.reject(error);
});

export default api;