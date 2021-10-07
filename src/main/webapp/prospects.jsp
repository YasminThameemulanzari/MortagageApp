<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!-- Required meta tags -->
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>

<body>
	<div class="container">
		<div class="text-center">
			<h1>Money Bin Inc Bank</h1>
			<h4>Duckburg</h4>
		</div>

		<div class="container">
			<h4>Prospects for mortgages</h4>
			<p>Below are the list of prospects available for the mortgages.
				(Example: Customer wants to borrow X &euro; for a period of Z years
				and pay E &euro; each month)</p>

			<table id="result" class="table">
				<thead>
					<tr>
						<th>Customer Name</th>
						<th>Borrow Amount (&euro;)</th>
						<th>Payback Years</th>
						<th>Fixed Monthly Payment (&euro;)</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>

		</div>
		<!-- Option 1: Bootstrap Bundle with Popper -->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
			crossorigin="anonymous">
			
		</script>
</body>
<script type=text/javascript>
	fetch('http://localhost:8081/mortgages', {
           method: 'GET',  
           headers: {
             'Content-Type': 'application/json',
           }
         })
         .then(response => response.json())
         .then(result => {
			 var mortgages = "";

			result.forEach(mortgage => {
				mortgages += 
				"<tr><td>" + mortgage.customer_Name + "</td><td>" + mortgage.total_Loan_Amount  + "</td><td>" +  mortgage.years  + "</td><td>" +  mortgage.fixed_Monthly_Payment_Amount.toFixed(2)  + "</td></tr>";
			});

		   console.log('Success:', result);
           document.querySelector('#result tbody').innerHTML = mortgages;
         })
         .catch((error) => {
          console.error('Error:', error);
        });
</script>
</html>