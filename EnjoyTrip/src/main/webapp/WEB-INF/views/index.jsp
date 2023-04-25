<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/include/head.jsp"%>
	<link href="${root}/resources/css/styles.css" rel="stylesheet" />
	
	<!-- CSS(travel spots) -->
	<link rel="stylesheet" href="${root}/resources/css/owl.carousel.min.css" />
	<link rel="stylesheet" href="${root}/resources/css/owl.theme.default.min.css" />
	<link rel="stylesheet"
	    href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/4.5.6/css/ionicons.min.css" />
	<link rel="stylesheet" href="${root}/resources/css/spot-style.css" /> 
	
	<script src="${root}/resources/js/jquery.min.js"></script>
	 <!-- youtube-background 라이브러리 로드 -->
    <script src="https://unpkg.com/youtube-background@1.0.14/jquery.youtube-background.min.js"></script>
	
</head>
<body>
    <!-- navigation -->
 <%@ include file="/WEB-INF/views/include/nav.jsp"%>

	<!-- Masthead-->
	<header class="masthead">
		<!-- DY: 추가함!!!! -->
		<div>
			<div id="yvideo" data-vbg-autoplay="true"
				data-vbg="https://youtu.be/3P1CnWI62Ik"></div>
		</div>
		<div class="container position-relative">
			<div class="row justify-content-center">
				<div class="col-xl-6">
					<div class="text-center text-white">
						<!-- Page heading-->
						<div></div>
						<h1 class="mb-5">Imagine Korea</h1>
						<form class="form-subscribe" id="contactForm" method = "post" action = "${root}/attr" data-sb-form-api-token="API_TOKEN">
							<input type="hidden" name="action" value="search">
							<!-- Travel spots input-->
							<div class="row">
								<div class="col">
									<input class="form-control form-control-lg" id="addr" name="addr" type="text" placeholder="검색할 지역의 이름을 입력해주세요." />
								</div>
								<div class="col-auto">
									<button type = "submit"  id = "submitButton" style = "background-color:transparent; border:none">
										<a class="btn btn-primary btn-lg" id="submitButton" type="submit" style = "color: white">Submit</a>
									</button>									
								</div>
							</div>						
						</form>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Travel spots recommendation -->
	<section class="ftco-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="featured-carousel owl-carousel">
						<div class="item">
							<div class="work">
								<div class="img d-flex align-items-end justify-content-center"
									style="background-image: url(${root}/resources/assets/recommend-images/한강.jpg)">
									<div class="text w-100">
										<span class="cat">#한강 #남산 #강남</span>
										<h3>
											<a href="${root}/attr?action=search&addr=서울">서울</a>
										</h3>
									</div>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="work">
								<div class="img d-flex align-items-end justify-content-center"
									style="background-image: url(${root}/resources/assets/recommend-images/제주도.jpg)">
									<div class="text w-100">
										<span class="cat">#Jeju #바다 #감귤</span>
										<h3>
											<a href="${root}/attr?action=search&addr=제주시">제주도</a>
										</h3>
									</div>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="work">
								<div class="img d-flex align-items-end justify-content-center"
									style="background-image: url(${root}/resources/assets/recommend-images/부산.jpg)">
									<div class="text w-100">
										<span class="cat">#해운대 #광안리 #서면</span>
										<h3>
											<a href="${root}/attr?action=search&addr=부산">부산</a>
										</h3>
									</div>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="work">
								<div class="img d-flex align-items-end justify-content-center"
									style="background-image: url(${root}/resources/assets/recommend-images/강릉.jpg)">
									<div class="text w-100">
										<span class="cat">#강원도 #안목해변 #속초</span>
										<h3>
											<a href="${root}/attr?action=search&addr=강릉">강릉</a>
										</h3>
									</div>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="work">
								<div class="img d-flex align-items-end justify-content-center"
									style="background-image: url(${root}/resources/assets/recommend-images/전주.jpg)">
									<div class="text w-100">
										<span class="cat">#한옥마을 #객리단길 #비빔밥</span>
										<h3>
											<a href="${root}/attr?action=search&addr=전주">전주</a>
										</h3>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>




	<!-- footer -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>

	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
	<!-- TODO: 추가함 -->
	<script type="text/javascript" src="${root}/resources/js/sign-in.js"></script>
	<!-- DY:추가함 -->
	<script>
		$(document).ready(function() {
			$('[data-vbg]').youtube_background(); // 실행
		});
	</script>

	<!--  Travel spots recommendation js script-->
	<script src="${root}/resources/js/popper.js"></script>
	<script src="${root}/resources/js/bootstrap.min.js"></script>
	<script src="${root}/resources/js/owl.carousel.min.js"></script>
	<script src="${root}/resources/js/main.js"></script>

</body>
</html>