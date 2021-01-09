import React, { useState } from 'react';
import { Row, Col, Card, Input } from 'antd';
import ImageSlider from '../utils/ImageSlider';
import './MainPage.css';
import 'antd/dist/antd.css';
import '../input.css';
import NavBar from '../NavBar/NavBar';
import { Link }from "react-router-dom";

const { Meta } = Card;

{
    /* 나중에는 서버에서 가져옴 */
}
const products = [
    { title: 'J2KB 명함', description: 'J2KB 명함' },
    { title: '제품2', description: '제품2' },
    { title: '제품3', description: '제품3' },
    { title: '제품4', description: '제품4' },
    { title: '제품5', description: '제품5' },
    { title: '제품6', description: '제품6' },
    { title: '제품7', description: '제품7' },
    { title: '제품8', description: '제품8' },
    { title: '제품9', description: '제품9' },
    { title: '제품10', description: '제품10' },
];
{
    /* 나중에는 서버에서 가져옴 */
}

function Main() {


    const renderCards = products.map((product, index) => {
        return (
            <Col key={index} lg={6} md={8} xs={24}>
                <Link to={`/product/${product.title}`} >
                    <Card cover={<ImageSlider />} >
                        <Meta title={product.title} description={product.description} />
                    </Card>
                </Link>
            </Col>
        );
    });

    return (
        <div id="wrap">
            <NavBar />
            <div className="banner">
                <p>배너</p>
            </div>
            <div className="contents" style={{ width: '55%', margin: '3rem auto' }}>
                <Row gutter={[20, 20]}>{renderCards}</Row>
            </div>
        </div>
    );
}

export default Main;
