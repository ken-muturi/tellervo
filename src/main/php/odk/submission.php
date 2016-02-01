<?php
include('inc/odkauth.php');
include('inc/odkhelper.php');
require_once('../inc/dbhelper.php');
$odkauth = new ODKAuth();
$mediaStoreFolder = "/usr/share/tellervo-server/mediastore/";

function endsWith($haystack, $needle) {
    // search forward starting from end minus needle length characters
    return $needle === "" || (($temp = strlen($haystack) - strlen($needle)) >= 0 && strpos($haystack, $needle, $temp) !== FALSE);
}


if($odkauth->doAuthentication()===TRUE)
{

}
else
{
	die();
}

$deviceid = $_GET['deviceID'] or printError("Device ID is missing", "400 Bad request");
$filearray = array();

$resp=201;

// Create media folder for user if it doesn't already exist
if (!file_exists($mediaStoreFolder."/".$odkauth->getUserID())) {
    mkdir($mediaStoreFolder."/".$odkauth->getUserID(), 0777, true);
}



if( $_SERVER['REQUEST_METHOD']==="HEAD") $resp=204;
elseif( $_SERVER['REQUEST_METHOD']==="POST")
{
	$tmpname = $_FILES['xml_submission_file']['tmp_name'];
	$name = $_FILES['xml_submission_file']['name'];
	//file_put_contents('/tmp/headers.txt', "Temp name : ".$tmpname."\n", FILE_APPEND);
	//file_put_contents('/tmp/headers.txt', "Name : ".$name."\n", FILE_APPEND);

	$xml=simplexml_load_file($tmpname) or printError("Unable to parse ODK XML file", "400 Bad request");
	$instanceName = $xml->meta->instanceName or printError("Unable to parse ODK XML file", "400 Bad request");

  	//file_put_contents('/tmp/headers.txt', "Instance name: ".$instanceName."\n", FILE_APPEND);
	
	
	foreach( $_FILES as $file)
	{
		if(endsWith($file['name'], "xml")) continue;
  		//file_put_contents('/tmp/headers.txt', "Copying file: ".$file['name']." to temp folder\n", FILE_APPEND);
		//move_uploaded_file( $file['tmp_name'], $mediastorefolder.$file['name']) or printError("Failed to copy media file", "400 Bad request");
		$currentname = $file['tmp_name'];
		$storedname = $mediaStoreFolder.$odkauth->getUserID()."/".$file['name']; 
		if (file_exists($storedname))
		{
			printError("Failed to copy media file", "500 Media file storage error");
		}
		move_uploaded_file($currentname, $storedname) or printError("Failed to copy media file", "500 Media file storage error");
		$filearray[] = $storedname;

	}

	writeInstanceToDB($instanceName, $xml->asXML(), $filearray);
}

function writeInstanceToDB($instanceName, $instance, $fileArray)
{
    global $firebug;
    global $dbconn;
    global $deviceid;
    global $odkauth;

    $sql = "INSERT INTO tblodkinstance (deviceid, ownerid, name, instance, files) values (";

    $sql.=dbHelper::tellervo_pg_escape_string($deviceid).", ";
    $sql.=dbHelper::tellervo_pg_escape_string($odkauth->getUserID()).", ";
    $sql.=dbHelper::tellervo_pg_escape_string($instanceName).", ";
    $sql.=dbHelper::tellervo_pg_escape_string($instance).", ";
    $sql.=dbHelper::phpArrayToPGStrArray($fileArray); 
    $sql.=")";
  
   file_put_contents('/tmp/headers.txt', "SQL : ".$sql."\n", FILE_APPEND);

    if ($sql)
    {
       // Run SQL 
       pg_send_query($dbconn, $sql);
       $result = pg_get_result($dbconn);
       if(pg_result_error_field($result, PGSQL_DIAG_SQLSTATE)) printError(pg_result_error($result), "400 Bad request");

    }



}



header( "X-OpenRosa-Version: 1.0");
header( "X-OpenRosa-Accept-Content-Length: 2000000");
header( "Date: ".date('r'), false, $resp);

?>
<OpenRosaResponse xmlns="http://openrosa.org/http/response">
        <message nature="submit_success">Thanks</message>
</OpenRosaResponse> 

