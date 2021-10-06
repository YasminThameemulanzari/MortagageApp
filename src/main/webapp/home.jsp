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
			<h1>Money Bin Inc</h1>
			<h4>Mortgage Monthly Payment Calculator</h4>
		</div>
		<div class="row">
			<div class="col-md-auto">
				<div id="error" class="alert alert-danger mt-4 d-none" role="alert">
					<ul></ul>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-md order-md-2 mb-3">
					<div class="form-group">
						<label for="userName">Name</label> <input type="text"
							class="form-control" id="userName" placeholder="Enter your name">
						<!-- <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small> -->
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 order-md-2 mb-3">
					<div class="form-group">
						<label for="totalLoan">Total Loan Amount (&euro;)</label> <input
							type="number" required class="form-control" id="totalLoan"
							placeholder="Enter Loan Amount">
						<!-- <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small> -->
					</div>
				</div>
				<div class="col-md-4 order-md-2 mb-3">
					<div class="form-group">
						<label for="interestRate">Rate of Interest (%)</label> <input
							type="number" class="form-control" id="interestRate"
							placeholder="Enter Rate of Interest (%)">
					</div>
				</div>
				<div class="col-md-4 order-md-2 mb-3">
					<div class="form-group">
						<label for="paybackYears">Payback Years</label> <input
							type="number" class="form-control" id="paybackYears"
							placeholder="Enter number of years">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-auto mt-3">
					<button type="submit" onclick="getData()" class="btn btn-primary">Calculate
						Monthly Payment</button>
				</div>
			</div>

			<div class="row">
				<div class="col-md-auto">
					<div id="result" class="alert alert-success mt-4 d-none"
						role="alert">
						Your monthly payment will be <span id="monthlyPayment">1000.00
						</span> &euro; / month for <span id="totalYears">10</span> years.
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous">
    </script>
	<script>
    function getData(){
        const data = {
        	customer_Name: document.querySelector('#userName').value,
        	total_Loan_Amount: parseFloat(document.querySelector('#totalLoan').value),
        	interest_Rate:parseFloat(document.querySelector('#interestRate').value),
            years: parseFloat(document.querySelector('#paybackYears').value)
        };

		document.querySelector('#result').classList.add('d-none');
		document.querySelector('#error').classList.add('d-none');

         fetch('http://localhost:8081/mortgages', {
           method: 'POST',  
           headers: {
             'Content-Type': 'application/json',
           },
           body: JSON.stringify(data),
         })
         .then(response => response.json())
         .then(result => {

		   if(result.error){
			console.log('Error:', result);
			   var messages = "";
			   result.errors.forEach(err => {
				   messages += "<li>" + err.defaultMessage + "</li>";
			   });
			   document.querySelector('#error ul').innerHTML = messages;
			   document.querySelector('#error').classList.remove('d-none');
			   return;
		   }

		   console.log('Success:', result);
           var monthlyPayment = result.fixed_Monthly_Payment_Amount;
           document.querySelector('#monthlyPayment').innerText = (monthlyPayment.toFixed(2));
           document.querySelector('#totalYears').innerText = (result.years);
           document.querySelector('#result').classList.remove('d-none');
         })
         .catch((error) => {
          console.error('Error:', error);
        });
        
    }  
    </script>
</body>
</html>