<?php

$key = $_POST["keyword"];
echo $key;

if ($key !== "") {
	$key = str_replace(" ", "_", $key);

	$new_url = "http://phase3turnip.azurewebsites.net/" . $key;
	// echo $new_url;

	header("Location: " . $new_url);
}

else {
	echo "Please input a valid keyword to look up in the police directory.";
}

?>