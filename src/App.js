import React from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import MainPage from './components/MainPage/MainPage';
import LoginPage from './components/LoginPage/LoginPage';
import JoinPage from './components/JoinPage/JoinPage';
import IdFind from './components/IdPwFind/IdFind';
import PwFind from './components/IdPwFind/PwFind';
import UploadProductPage from './components/UploadProductPage/UploadProductPage';
import ProductDetailPage from './components/ProductDetailPage/ProductDetailPage';
import AdminPage from './components/AdminPage/AdminPage';
import './App.css';

function App() {
    return (
        <Router>
            <Switch>
                <Route exact path="/" component={MainPage} />
                <Route exact path="/admin" component={AdminPage} />
                <Route exact path="/login" component={LoginPage} />
                <Route exact path="/join" component={JoinPage} />
                <Route exact path="/find/id" component={IdFind} />
                <Route exact path="/find/password" component={PwFind} />
                <Route exact path="/product/upload" component={UploadProductPage} />
                <Route exact path="/product/:product_name" component={ProductDetailPage} />
            </Switch>
        </Router>
    );
}

export default App;
