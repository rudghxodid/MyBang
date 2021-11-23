import axios from 'axios';
// import JwtDecode from 'jwt-decode';

const baseURL = 'http://localhost:7777';
const timeout = 100000000;

const api = axios.create({
  // baseURL: ,
  baseURL,
  timeout,
  headers: {
    'Access-Control-Allow-Origin': '*',
    'Access-Control-Allow-Headers': '*',
    'Content-Type': 'application/json;charset=utf-8'
  },
});

export default api;
