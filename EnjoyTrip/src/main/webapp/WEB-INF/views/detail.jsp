<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous"
    />
    <script
      src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
      integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
      integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
      integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
      crossorigin="anonymous"
    ></script>
    <link rel="stylesheet" href="${root}/resources/css/styles.css" />
    <style>
		.card {
		  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
		  max-width: 800px;
		  margin: auto;
		  text-align: center;
		  font-family: arial;
		}

		.address {
		  color: grey;
		  font-size: 18px;
		}

    </style>
</head>
<body>
    <!-- navigation -->
 	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
    <div class="col-md-9">

        <!-- 관광지 검색 start -->
        <form class="d-flex my-3" method = "post" action = "${root}/attr" role="search">
          <input type="hidden" name="action" value="search">
          <select id="search-area" class="form-select me-2" name = "sido">
            <option value="0" selected>검색 할 시도 선택</option>
            	<c:forEach var = "s" items = "${sidos}">
           			<c:choose>
          				<c:when test = "${sido eq s.code}">
            				<option value = "${s.code}" selected>${s.name}</option>
          				</c:when>
          				<c:otherwise>
          					<option value = "${s.code}">${s.name}</option>
          				</c:otherwise>
          			</c:choose>
            	</c:forEach>
          </select>
          
           <select id="search-area2" class="form-select me-2" name = "gugun">
            <option value="0" selected>검색 할 구군 선택</option>
          </select>
          <select id="search-content-id" class="form-select me-2" name = "type">
            <option value="0" selected>관광지 유형</option>
            <option value="12">관광지</option>
            <option value="14">문화시설</option>
            <option value="15">축제공연행사</option>
            <option value="25">여행코스</option>
            <option value="28">레포츠</option>
            <option value="32">숙박</option>
            <option value="38">쇼핑</option>
            <option value="39">음식점</option>
          </select>
          <input
            id="search-keyword"
            name = "addr"
            class="form-check me-2"
            type="search"
            placeholder="검색어"
            aria-label="검색어"
          />
          <button type="submit" id="btn-search" class="btn btn-outline-success">검색</button>
        </form>
    </div>

    <div class="container-fluid">
      <div class="px-lg-5">
        <div class="row">
        
          <!-- Gallery item -->
          	<h2 style="text-align:center">${attraction.title}</h3>        	
            <div class="card">
              <img
                src="${attraction.img}"
                onerror="this.src='./assets/NoImage.png'"
                alt=""
                class="img-fluid card-img-top"
                style="width:100%; height:100%"
              />	            
                <p class="address">주소: ${attraction.addr}</p>
                <p>${attraction.overview}</p>
          
          <!-- End -->

          <!-- 추가하기 -->


        </div>
      </div>

    </div>
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<script>
	    document.querySelector("#search-area").addEventListener("change", function () {
	    	let id = this.value;
	    	let resultDiv = document.querySelector("#search-area2");
	    	while(resultDiv.firstChild){
	    		resultDiv.removeChild(resultDiv.firstChild);
	    	}
	    	const option = document.createElement('option');
			option.value = 0;
			option.text = "검색 할 구군 선택";
			resultDiv.add(option);
	        fetch("${root}/attr?action=gugun&id=" + id)
	           .then(response => response.json())
	           .then(data => {
						data.forEach( d =>{
							const option = document.createElement('option');
							option.value = d.code;
							option.text = d.name;
							resultDiv.add(option);
							});
	         		});	
	    });

	</script>
</body>
</html>