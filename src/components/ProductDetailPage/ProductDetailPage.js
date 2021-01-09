import React, {useState} from 'react';
import NavBar from '../NavBar/NavBar';
import styles from "./ProductDetailPage.module.css";

function ProductDetailPage(props) {
    
    {
      /* 나중에는 서버에서 가져옴 */
    }
    const variables = {
      imgsrcs: ["https://image.freepik.com/free-photo/champagne-glasses-with-bokeh-lights_23-2148761511.jpg",
               "https://image.freepik.com/free-vector/lettering-happy-new-year-2021_52683-51730.jpg",
               "https://image.freepik.com/free-vector/realistic-christmas-party-poster-template_79603-1116.jpg"],
      prod_name: "J2KB 명함",
      prod_num: "00001",
      prod_stock: 50,
      prod_price: "25000",
      prod_detail: "J2KB 명함입니다. J2KB 명함입니다. J2KB 명함입니다. J2KB 명함입니다. J2KB 명함입니다.",

      buy_num: 1,
      buy_price: 25000
    }
    {
      /* 나중에는 서버에서 가져옴 */
    }

    const changeImg = (event) => {
      if(event.target.className === `${styles.smallImageViewer}`) {
        document.querySelector(`.${styles.bigImg}`).src = event.target.querySelector("img").src;
      } else
        document.querySelector(`.${styles.bigImg}`).src = event.target.src;
    }

    const magnify = () => {
      const bigShower = document.querySelector(`.${styles.bigShower}`);
      const bigImg = document.querySelector(`.${styles.bigImg}`);
      const ZOOM = 1.5;
      const width = 900;
      const height = 500;
      const image_width = bigImg.width;
      const image_height = bigImg.height;
      bigShower.style.width = `${width}px`;
      bigShower.style.height = `${height}px`;
      bigShower.style.background = `no-repeat url(${bigImg.src})`
      bigShower.style.backgroundSize = `${width*ZOOM}px`;

      bigShower.addEventListener("mousemove", viewBigImage)

      function viewBigImage(event) {
        event.preventDefault();
        const x = event.clientX - bigShower.getBoundingClientRect().left;
        const y = event.clientY - bigShower.getBoundingClientRect().top;
        const imgX = -( x *(ZOOM-1));
        const imgY = -( y*(width * ZOOM * image_height / (image_width * height)) - y );
        console.log(imgX, imgY);
        bigShower.style.backgroundPosition = `${imgX}px ${imgY}px`;
      }
    }

    const hideShower = (event) => {
      event.target.style.width = 0;
      event.target.style.height = 0;
    }

    return (
        <div>
          <NavBar/>
          <div className={styles.container}>
              <div>
                <h2>{variables.prod_name}</h2>
              </div>
              <div className={styles.product}>
                <div className={styles.photos}>
                  <div className={styles.imageViewer} onClick={magnify}>
                    <img id="shower" className={styles.bigImg} src={variables.imgsrcs[0]} alt="큰이미지"/>
                  </div>
                  <div className={styles.bigShower} onClick={hideShower}></div>
                  상단 이미지를 눌러 확대할 수 있습니다.
                  <div className={styles.smallImages}>
                    {variables.imgsrcs.map( src => (
                          <div key={src} className={styles.smallImageViewer} onClick={changeImg}>
                            <img className={styles.smallImg} onClick={changeImg} src={src} alt="작은이미지"></img>
                          </div>
                    ))}
                  </div>
                </div>
                <div>
                  <div className={styles.productInfo}>
                    <h3>Product Info 제품정보</h3>
                    <ul className={styles.lists}>
                      <li className={styles.list}><p className={styles.infoTit}>상품명</p><p className={styles.infoContent}>{variables.prod_name}</p></li>
                      <li className={styles.list}><p className={styles.infoTit}>상품번호</p><p className={styles.infoContent}>{variables.prod_num}</p></li>
                      <li className={styles.list}><p className={styles.infoTit}>재고</p><p className={styles.infoContent}>{variables.prod_stock}</p></li>
                      <br></br>
                      <li className={styles.list}><p className={styles.infoTit}>상품설명</p><p className={styles.infoContent}>{variables.prod_detail}</p></li>
                    </ul>
                  </div>
                  <div className={styles.priceInfo}>
                    <h3>Price Info 가격정보</h3>
                    <ul className={styles.lists}>
                      <li className={styles.list}><p className={styles.infoTit}>판매가</p><p className={styles.infoContent}>{variables.prod_price}원</p></li>
                    </ul>
                  </div>
                  <div className={styles.calInfo}>
                    <div className={styles.calculator}>
                      <p className={styles.calTit}>{variables.prod_name}</p>
                      <button className={styles.minusButton} onClick></button>
                      <p className={styles.calNum}>{variables.buy_num}</p>
                      <button className={styles.plusButton} onClick></button>
                    </div>
                    <h1>총 {variables.buy_price}원</h1>
                  </div>
                  <div className={styles.buttons}>
                    <button className={styles.buyButton}>바로주문</button>
                    <button className={styles.cartButton}></button>
                  </div>
                </div>
              </div>
          </div>
        </div>
        
      );
}
  
export default ProductDetailPage;