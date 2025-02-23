import React, { useState } from 'react';
import axios from 'axios';

const LoginComponent = () => {
  const [loginStatus, setLoginStatus] = useState('');

  const handleLogin = async () => {
    try {
      const response = await axios.get('/login');
      setLoginStatus(response.data);
    } catch (error) {
      setLoginStatus('Login failed');
    }
  };

  return (
    <div>
      <h2>Login</h2>
      <button onClick={handleLogin}>Login</button>
      <p>{loginStatus}</p>
    </div>
  );
};

export default LoginComponent;