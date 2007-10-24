<?php
//*******************************************************************
////// PHP Corina Middleware
////// License: GPL
////// Author: Peter Brewer
////// E-Mail: p.brewer@cornell.edu
//////
////// Requirements : PHP >= 5.0
//////*******************************************************************
header('Content-Type: application/xhtml+xml; charset=utf-8');

require_once("config.php");
require_once("inc/dbsetup.php");
require_once("inc/meta.php");
require_once("inc/auth.php");

$myAuth = new auth();

//$myAuth->setPassword("webuser", "tree");

// Extract parameters from request and ensure no SQL has been injected
$theMode = strtolower(addslashes($_GET['mode']));
if(isset($_GET['username'])) $theUsername = addslashes($_GET['username']);
if(isset($_GET['password'])) $thePassword = addslashes($_GET['password']);

// Create new meta object and check required input parameters and data types
switch($theMode)
{
    case "login":
        $myMetaHeader = new meta("login");
        if($theUsername == NULL) $myMetaHeader->setMessage("902", "Missing parameter - 'username' field is required.");
        if($thePassword == NULL) $myMetaHeader->setMessage("902", "Missing parameter - 'password' field is required.");
        break;

    case "logout":
        $myMetaHeader = new meta("logout");
        break;

    default:
        $myMetaHeader = new meta("help");
        // Output the resulting XML
        echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        echo "<corina>\n";
        echo $myMetaHeader->asXML();
        echo "<help> Details of how to use this web service will be added here later! </help>";
        echo "</corina>\n";
        die;
}

// Set user details
if($myAuth->isLoggedIn())
{
    $myMetaHeader->setUser($myAuth->getUsername(), $myAuth->getFirstname(), $myAuth->getLastname());
}


//Only attempt to run SQL if there are no errors so far
if(!($myMetaHeader->status == "Error"))
{
    // Creat Authentication object
    $myAuth = new auth();

    // Update parameters in object if updating or creating an object 
    if($theMode=='login')
    {
        $myAuth->login($theUsername, $thePassword);
        
        if($myAuth->isLoggedIn())
        {
            // Log in worked
        }
        else
        {
            // Log in failed
            $myMetaHeader->setMessage(101, "Authentication failed");
        }
    }

    // Delete record from db if requested
    if($theMode=='logout')
    {
        $myAuth->logout();
    }
}

// Set user details
$myMetaHeader->setUser($myAuth->getUsername(), $myAuth->getFirstname(), $myAuth->getLastname());


// Output the resulting XML
echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
echo "<corina>\n";
echo $myMetaHeader->asXML();
echo "<data>\n";
echo $xml;
echo "</data>\n";
echo "</corina>";
