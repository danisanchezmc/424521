<?php
header("Content-Type: text/html; charset=utf-8");

$servicePath='http://localhost:8080/Flypay';

$paymentID=0;
$ambitoID=0;

if(isset($_GET['name'])){
	$restaurantName = $_GET['name'];
}

if(isset($_GET['payment'])){
	$paymentID = $_GET['payment'];
}

function CallAPI($method, $url, $data = false)
{
    $curl = curl_init();

    switch ($method)
    {
        case "POST":
            curl_setopt($curl, CURLOPT_POST, 1);

            if ($data)
                curl_setopt($curl, CURLOPT_POSTFIELDS, $data);
            break;
        case "PUT":
            curl_setopt($curl, CURLOPT_PUT, 1);
            break;
        default:
            if ($data)
                $url = sprintf("%s?%s", $url, http_build_query($data));
    }

    // Optional Authentication:
    curl_setopt($curl, CURLOPT_HTTPAUTH, CURLAUTH_BASIC);
    curl_setopt($curl, CURLOPT_USERPWD, "username:password");

    curl_setopt($curl, CURLOPT_URL, $url);
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);

    $result = curl_exec($curl);

    curl_close($curl);

    return $result;
}

?>	 
<head>
	<meta charset="UTF-8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<title>Flypay - Payments Reports</title>
	<meta name="author" content="DANIEL" />

</head>

<body>

<form id="filter" method="get" action="index.php">

<label for="restaurant">Restaurant</label>
<br/>
<input id="name" name="name" type="text" title="Restaurant" size="40" value="<?php if (isset($restaurantName)) echo $restaurantName;?>">

<br/>
<label for="restaurant">Payment</label>
<br/>

<select id="payment" name="payment" type="select" title="Payment" style="width:auto;" >
	<option value="0" <?php if($paymentID ==0) echo 'select'; ?>>All</option>
	<?php	
		$provJSON = json_decode(CallAPI('GET',$servicePath.'/api/payments'));
		
		foreach($provJSON as $payment){
			echo '<option value="'.$payment->code.'"'.($payment->code == $paymentID ? 'selected':'').' >'.$payment->txt_amount.'</option>';
		}
	?>
</select>

<br/>
<input type="submit" value="Filter" />
<input type="button" value="See All"   onclick="location.href='index.php';"/>

</form>

</body>	