<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Stylish Portfolio - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="/assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Simple line icons-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.5.5/css/simple-line-icons.min.css" rel="stylesheet" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/css/styles.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://js.tosspayments.com/v1/payment-widget"></script>
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <a class="menu-toggle rounded" href="#"><i class="fas fa-bars"></i></a>
        <nav id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand"><a href="#page-top">Start Bootstrap</a></li>
                <li class="sidebar-nav-item"><a href="#page-top">Home</a></li>
                <li class="sidebar-nav-item"><a href="#about">About</a></li>
                <li class="sidebar-nav-item"><a href="#services">Services</a></li>
                <li class="sidebar-nav-item"><a href="#portfolio">Portfolio</a></li>
                <li class="sidebar-nav-item"><a href="#contact">Contact</a></li>
            </ul>
        </nav>
        <!-- Header-->

                           <div>
                        	<input type="hidden" name="orderId" value="${odrdeid}" id="odrdeid" readonly="readonly">
                        	<input type="hidden" name="amount" value="${amount}" id="amount" readonly="readonly">
                        	<input type="hidden" name="customerkey" value="${customerkey}" id="customerkey" readonly="readonly">
                        	<input type="hidden" name="clientkey" value="${clientkey}" id="clientkey" readonly="readonly">
                        	</div>
         
        <!-- About-->
        <section class="content-section bg-light" id="about">
            <div class="container px-4 px-lg-5 text-center">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-lg-10">
                        <!-- main -->
					<div>
						<div id="main">

							<div class="box_section"
								style="padding: 40px 30px 50px 30px; margin-top: 30px; margin-bottom: 50px;">
								<!-- 결제 UI -->
								<div id="payment-method"></div>
								<!-- 이용약관 UI -->
								<div id="agreement"></div>
								<!-- 쿠폰 체크박스 -->
								<div style="padding-left: 25px">
									<div class="checkable typography--p">
										<label for="coupon-box" class="checkable__label typography--regular"> 
										<input id="coupon-box" class="checkable__input" type="checkbox" aria-checked="true" /> 
										<span class="checkable__label-text">5,000원 쿠폰 적용</span></label>
									</div>
								</div>
								<!-- 결제하기 버튼 -->
								<div class="result wrapper">
									<button class="button" id="payment-button" style="margin-top: 30px">결제하기</button>
								</div>
							</div>


						</div>

				</div>
				</div>
                </div>
            </div>
        </section>
        <!-- Services-->
     
        <!-- Call to Action-->
        <section class="content-section bg-primary text-white">
            <div class="container px-4 px-lg-5 text-center">
                <h2 class="mb-4">The buttons below are impossible to resist...</h2>
                <a class="btn btn-xl btn-light me-4" href="#!">Click Me!</a>
                <a class="btn btn-xl btn-dark" href="#!">Look at Me!</a>
            </div>
        </section>
        <!-- Map-->
      
        <!-- Footer-->
      
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top"><i class="fas fa-angle-up"></i></a>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- 토스페이먼츠 -->
        <script src="/js/payment/checkout.js"></script>
        <!-- Core theme JS-->
        <script src="/js/scripts.js"></script>
    </body>
</html>
