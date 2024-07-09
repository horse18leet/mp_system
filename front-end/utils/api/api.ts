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
<<<<<<< Updated upstream
    // const refreshToken = localStorage.getItem('refresh_token');
=======
    
>>>>>>> Stashed changes
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
      console.log("отправляем в теле токен: ", token);
    }
<<<<<<< Updated upstream
    // else if(refreshToken) {
    //   config.headers.Authorization = `Bearer ${refreshToken}`;
    // }

=======
>>>>>>> Stashed changes
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

api.interceptors.response.use(
  (response) => {
<<<<<<< Updated upstream
  return response;
  },
(error) => {
  // if (error.response?.status === 401) {
  //   localStorage.removeItem("token");
  //   updateToken();
  // }
=======
    return response;
  },
(error) => {
  console.log(error);
  if (error.response?.status === 401) {
    //updateToken();
  }
>>>>>>> Stashed changes

  return Promise.reject(error);
});

export default api;