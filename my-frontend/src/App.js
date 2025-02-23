// src/App.js
import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import HomeComponent from './components/HomeComponent';
import LoginComponent from './components/LoginComponent';
import ProductComponent from './components/ProductComponent';
import './App.css';

const App = () => {
  return (
    <Router>
      <div className="App">
        <nav>
          <ul>
            <li>
              <a href="/">Home</a>
            </li>
            <li>
              <a href="/login">Login</a>
            </li>
            <li>
              <a href="/products">Products</a>
            </li>
          </ul>
        </nav>
        <Switch>
          <Route path="/" exact component={HomeComponent} />
          <Route path="/login" component={LoginComponent} />
          <Route path="/products" component={ProductComponent} />
        </Switch>
      </div>
    </Router>
  );
};

export default App;